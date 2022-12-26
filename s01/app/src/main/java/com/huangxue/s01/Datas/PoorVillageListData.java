package com.huangxue.s01.Datas;

import android.util.ArrayMap;

import com.huangxue.s01.Adatper.PoorFragmentViewPager;
import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoorVillageListData {

    public static Map<Integer, List<DataInfo>> getDatas(){
        Map<Integer, List<DataInfo>> nb = new HashMap<>();

        for (int i = 0; i < imgArray.length; i++) {
            List<DataInfo> dataInfos = new ArrayList<>();
            dataInfos.add(new DataInfo(imgArray[i],titleArray[i],descArray[i]));
            nb.put(i,dataInfos);
        }

        return nb;
    }

    private Map<Integer, List<DataInfo>> data;

    public PoorVillageListData(Map<Integer, List<DataInfo>> data) {
        this.data = data;
    }

    public Map<Integer, List<DataInfo>> getData() {
        return data;
    }

    public void setData(Map<Integer, List<DataInfo>> data) {
        this.data = data;
    }

    public static class DataInfo{
        private int img;
        private String title;
        private String desc;

        public DataInfo(int img, String title, String desc) {
            this.img = img;
            this.title = title;
            this.desc = desc;
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

    private static int[] imgArray = {R.drawable.poor_village01,R.drawable.poor_village02,R.drawable.poor_village03,R.drawable.poor_village04,R.drawable.poor_village05};
    private static String[] titleArray = {"溶解度村","免费更换村","五个村","果然村","喉咙村",};
    private static String[] descArray = {"该村产业以林果业为支柱产业，现有1500亩桃树种植基地，优质桃年产量3000万公斤，形成以种植、运输、销售全方面服务体系。加工业及养殖业发展迅速。高金亭、孙彦民发起成立了郑州市嫘祖园畜禽产业发展有限公司，整个企业由36个肉鸡养殖场、5万套种鸡场、500万只鸡苗孵化场、6000吨饲料厂、200万只肉鸡加工厂和5000吨绿色有机肥厂等配套场(厂)组成，设计总投资1000万元。公司的长足进展极大地带动了村民发展养殖的积极性，目前已有60户村民加盟公司，为农民致富奔小康做出了巨大贡献。",
    "2001年3月村民代表会议作出“迁村并点兴建新村”决议，同年5月20日，新郑市人民政府批准整体规划。新村整体设计按照“环境优美、布局合理、设施齐全、生活便利”的原则，制定了包括六个居住区、一个行政服务区、一个广场商业区、两个花园、园林休闲区等生活区和供排水、用电、道路、停车场、学校、卫生所、活动中心、垃圾回收处理站、广播电视通讯等一流的基础设施。\n" +
            "\n" +
            "　　2001年10月10日新村建设开始启动，到目前，已建成别墅式小楼50幢，有100户村民入住新村;\n" +
            "\n" +
            "　　已部分完成中心大道、主要街道的硬化、绿化工作;",
    "XX村位于X市X区X镇西南方向，距离镇中心2.8公里，全村人口235户，640人，下辖X、X、X、X等四个自然村，耕地面积585亩，山林面积1565亩，以种植桂花、红叶石楠、红榉木等苗木为主，兼产毛芋、竹笋等农产品。村内绿树成荫，农房错落有致，联网公路东经X、X两村进入镇属X分中心区域，联通X县;西至X、X两村通达X大道;北接X集镇中心直通X市区;南到X区X镇和风景秀丽的X湖旅游度假区，道路四通八达，出行十分便利。",
    "　新中国社会主义建设初期，为支持国家大举兴修水利设施，我村先由X水库X乡X村迁往油麻山，后再由X乡油麻山迁到现X的乌石垅，两次搬迁后建成新的村庄，遂将村名改为X，时为X人民公社X生产大队。1983年称X乡X村，1986年改称X镇X村至今，中华民国三十七年三月版《X县全图》曾有详细标注和记载。改革开放以后，X村民不甘落后，在历届X村两委的带领下，发扬移民精神，投身经济建设，逐步改变了X村的面貌，成为X镇后劲十足的美丽乡村之一。",
    "进入新的世纪，在党的富民惠农政策支持下，在上级党委政府的正确领导下，X村两委紧抓机遇，乘势而上，带领全体村民攻坚克难，奋发有为，取得了有目共睹的成绩。xx年康庄工程实施，村路民道交错纵横;xx年村办公楼和老年活动中心崭新落成，并完成了X渠道三面光工程;xx年村污水处理、自来水改造全部完成;xx年村庄整治、坞石金塘改造胜利竣工;xx年以新建的村卫生服务中心、扩建的村办公楼和村民服务中心为标志，完成了市级农村示范社区的验收。村先后荣获“市级村庄整治示范村”、“区级绿化示范村”、“区级文化示范村”等称号，多次获得上级“优秀党支部”、“先进村委会”、“先进计生协会”等表彰。"};


}
