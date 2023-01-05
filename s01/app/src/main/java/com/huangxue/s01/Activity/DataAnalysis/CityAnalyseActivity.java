package com.huangxue.s01.Activity.DataAnalysis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.gson.Gson;
import com.huangxue.s01.Beans.LookJobRecruitListBean;
import com.huangxue.s01.Beans.TakeoutListBean;
import com.huangxue.s01.Beans.TakeoutMenuClassListBean;
import com.huangxue.s01.Beans.TakeoutMenuInfoListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CityAnalyseActivity extends AppCompatActivity {

    private static final String TAG = "CityAnalyseActivity";
    private List<LookJobRecruitListBean.RowsEntity> jobRows;
    private PieChart pie;
    private ProgressBar pb;
    private BarChart hBar;
    private Map<String, Float> realData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_analyse);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("智慧城市数据分析");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        new Thread(()->{
            initHttp();
        }).start();
    }
    private void initHttp(){
        Gson gson = new Gson();
        //工作饼图数据获取
        String jobBody = WorkOkHttp.get("/prod-api/api/job/post/list");
        jobRows = gson.fromJson(jobBody, LookJobRecruitListBean.class).getRows();

        //外卖水平柱状图数据获取
        //获取外卖店铺列表
        String takeoutBody = WorkOkHttp.get("/prod-api/api/takeout/seller/list");
        List<TakeoutListBean.RowsEntity> takeoutRows = gson.fromJson(takeoutBody, TakeoutListBean.class).getRows();
        //创建一个map，key为店铺信息，value为店铺菜单分类
        Map<TakeoutListBean.RowsEntity, List<Integer>> tIDmIDMap = new HashMap<>();
        //循环店铺列表
        for (TakeoutListBean.RowsEntity data : takeoutRows) {
            //根据当前店铺的id访问店铺的菜单分类
            String body = WorkOkHttp.get("/prod-api/api/takeout/category/list?sellerId=" + data.getId());
            List<TakeoutMenuClassListBean.DataEntity> rows = gson.fromJson(body, TakeoutMenuClassListBean.class).getData();
            //新建一个集合保存菜单分类id
            List<Integer> menuID = new ArrayList<>();
            //循环菜单分类
            for (TakeoutMenuClassListBean.DataEntity r : rows) {
                //保存菜单分类
                menuID.add(r.getId());
            }
            //保存店铺信息，和它所有菜单分类的id
            tIDmIDMap.put(data,menuID);
        }
        //创建一个map，key为店铺名字，value为该店铺的所有商品
        Map<String, List<List<TakeoutMenuInfoListBean.DataEntity>>> originData = new HashMap<>();
        //循环所有店铺
        for (TakeoutListBean.RowsEntity i : tIDmIDMap.keySet()) {
            //创建一个集合用来保存店铺的商品
            List<List<TakeoutMenuInfoListBean.DataEntity>> hhh = new ArrayList<>();
            //循环分类大小
            for (int j = 0; j < tIDmIDMap.get(i).size(); j++) {
                //访问当前商品分类的详细商品
                String body = WorkOkHttp.get("/prod-api/api/takeout/product/list?sellerId=" + i.getId() + "&" + "categoryId=" + tIDmIDMap.get(i).get(j));
                //初始化商品数据
                List<TakeoutMenuInfoListBean.DataEntity> menuInfoData = gson.fromJson(body, TakeoutMenuInfoListBean.class).getData();
//                Log.d(TAG, "initHttp: "+body);
                //添加商品
                hhh.add(menuInfoData);
            }
            //添加商品名称，商品分类的所有商品
            originData.put(i.getName(),hhh);
        }
//        Log.e(TAG, "initHttp: "+originData.get("尊宝比萨").get(1).get(0).getName());
        //创建一个map,key为店铺名字，value为店铺每个商家菜品平均价格占该商家菜品总价的的百分比
        realData = new HashMap<>();
        //循环每个店铺
        for (String s : originData.keySet()) {
            //用来保存该店铺所有商品的价格
            float ff = 0;
            //用来看该店铺有多少商品
            int nn = 0;
            //循环该店铺菜品分类长度大小
            for (int i = 0; i < originData.get(s).size(); i++) {
                //循环该菜品分类里的商品长度大小
                for (int j = 0; j < originData.get(s).get(i).size(); j++) {
                    ff += originData.get(s).get(i).get(j).getPrice();
                    nn+=1;
                }
            }
//            Log.e(TAG, s+"店铺的所有商品总金额："+ff);
//            Log.e(TAG, s+"有多少个商品："+nn);
            float oo = (ff/nn)/ff;
//            Log.e(TAG, s+"的百分比："+oo);
            realData.put(s,oo);
        }

        runOnUiThread(()->{
            initPieChart();
            initHBarChart();
            pb.setVisibility(View.GONE);
        });

    }

    private void initHBarChart() {
        Random random = new Random();
        List<BarEntry> barEntryList = new ArrayList<>();
        List<Integer> colorsList = new ArrayList<>();
        Map<Integer,String> nameMap = new HashMap<>();
        int i = 0;
        for (String s : realData.keySet()) {
            i+=1;
            colorsList.add(Color.rgb(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            barEntryList.add(new BarEntry(i,realData.get(s)));
            nameMap.put(i,s);
        }

        hBar.animateY(1000);
        hBar.getDescription().setText("商家菜品平均价格占菜品总价的的百分比");
        hBar.getLegend().setEnabled(false);
//        hBar.setExtraOffsets(30,0,30,30);

        XAxis xAxis = hBar.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(12,false);
        xAxis.setGranularity(1f);
        xAxis.setLabelRotationAngle(45);
//        xAxis.setAxisMinimum(0);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return nameMap.get((int)value);
            }
        });
        hBar.getAxisLeft().setEnabled(false);
        YAxis axisRight = hBar.getAxisRight();

        axisRight.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return String.format("%.2f",value)+"%";
            }
        });

        BarDataSet dataSet = new BarDataSet(barEntryList,"");
        dataSet.setColors(colorsList);

        dataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.format("%.2f",value)+"%";
            }
        });

        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.3f);

        xAxis.setAxisMaximum(barEntryList.size()+1);
        hBar.setVisibleXRange(0,5);

        hBar.setData(barData);


        hBar.setVisibility(View.VISIBLE);
    }

    private void initPieChart() {
        //数据处理
        //创建一个map,键是岗位，值是岗位需求的多少
        Map<String,Integer> pieMap = new HashMap<>();
        //循环数据集合
        for (LookJobRecruitListBean.RowsEntity data : jobRows) {
            //初始化值，判断map里有没有当前岗位，如果有获取他的值，没有就初始化它的值为1
            int count = (pieMap.containsKey(data.getProfessionName()) ? pieMap.get(data.getProfessionName()):1);
            //如果key里面有岗位，它的值加一
            if(pieMap.containsKey(data.getProfessionName())){
                pieMap.replace(data.getProfessionName(),count+1);
            }else{//如果key还没有岗位，添加岗位，初始化值
                pieMap.put(data.getProfessionName(),1);
            }
        }

//        for (String i : pieMap.keySet()) {
//            Log.d(TAG, "key:"+i+"value:"+pieMap.get(i));
//        }
//        pie.getLegend().setEnabled(false);

        //设置样式
        Legend legend = pie.getLegend();
        legend.setWordWrapEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        pie.getDescription().setEnabled(false);
        pie.animateY(1000, Easing.EaseInOutCubic);
        pie.setUsePercentValues(true);
        pie.setCenterText("招聘岗位比例");
        pie.setEntryLabelColor(Color.BLACK);
        pie.setEntryLabelTextSize(8);
        pie.setExtraOffsets(20,0,20,0);
        Random random = new Random();

        List<PieEntry> pieEntryList = new ArrayList<>();
        List<Integer> colorsList = new ArrayList<>();
        for (String s : pieMap.keySet()) {
            colorsList.add(Color.rgb(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            pieEntryList.add(new PieEntry(pieMap.get(s),s==null ? "其它":s));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"");
        pieDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getPieLabel(float value, PieEntry pieEntry) {
                return String.format("%.2f",value)+"%";
            }
        });

        pieDataSet.setColors(colorsList);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setSliceSpace(4f);
        pieDataSet.setValueLineColor(Color.BLACK);
        pieDataSet.setValueLinePart1OffsetPercentage(70);
        pieDataSet.setValueLinePart1Length(0.2f);
        pieDataSet.setValueLinePart2Length(0.3f);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData pieData = new PieData(pieDataSet);
        pie.setData(pieData);
        pie.setVisibility(View.VISIBLE);
    }

    private void initView() {
        pb = findViewById(R.id.item_progress);
        pie = findViewById(R.id.city_analyse_pie);
        hBar = findViewById(R.id.city_analyse_horizontal_bar);
    }
}