package com.huangxue.s01.Datas;

import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class PoorCaseListData {

    private int img;
    private String title;
    private String desc;

    public PoorCaseListData(int img, String title, String desc) {
        this.img = img;
        this.title = title;
        this.desc = desc;
    }

    private static int[] imgArray = {R.drawable.poor_case01,R.drawable.poor_case02,R.drawable.poor_case03,R.drawable.poor_case04,R.drawable.poor_case05};
    private static String[] titleArray = {"景宁600”区域公共品牌助农增收","磐安县乌石村旅游振兴乡村","永嘉县来料加工带动就业致富","丽水市大搬快聚富民安居","柯城区扶贫小额信贷惠农解困"};
    private static String[] descArray = {"景宁畲族自治县以“景宁600”区域公共品牌带动农产品销售，全年销售额6.1亿元，平均溢价率超过35%，直接带动1138户低收入农户，户均增收3000元以上。",
    "乌石村近一半农户开办农家乐，直接从业人员300多人，户均收入10万元以上，最高达到30多万元。","永嘉县聚焦家庭妇女、低收入农户等山区农村留守群体，发展来料加工，从业人员达3万余人，每年发放加工费6.5亿元。",
    "丽水市全面实施大搬快聚富民安居工程，完成投资34.7亿元，新建、续建安置小区44个、安置点14个，搬迁农民14050户、38352人。","衢州市柯城区2017年以来累计发放扶贫小额信贷1.23亿元，为低收入农户贴息492万元。"};

    public static List<PoorCaseListData> getData(){
        List<PoorCaseListData> list = new ArrayList<>();
        for (int i = 0; i < imgArray.length; i++) {
            list.add(new PoorCaseListData(imgArray[i],titleArray[i],descArray[i]));
        }
        return list;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
