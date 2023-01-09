package com.huangxue.s01.Beans;

public class TakeawaySellerInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"saleQuantity":570,"other":null,"address":"辽宁省大连市甘井子区软件园路新新园1号-4","deliveryTime":30,"distance":500,"themeId":4,"updateTime":"2021-05-11 15:41:09","remark":null,"recommend":"N","params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/d87665c4-79e7-47aa-aea1-d7180890ba38.jpg","score":5,"createBy":null,"createTime":"2021-05-08 15:41:38","updateBy":null,"name":"炸匠先森·韩式炸鸡","id":5,"avgCost":20,"searchValue":null,"saleNum3hour":16,"introduction":"选好肉 炸好鸡"}
     */
    private String msg;
    private int code;
    private DataEntity data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * saleQuantity : 570
         * other : null
         * address : 辽宁省大连市甘井子区软件园路新新园1号-4
         * deliveryTime : 30
         * distance : 500.0
         * themeId : 4
         * updateTime : 2021-05-11 15:41:09
         * remark : null
         * recommend : N
         * params : {}
         * imgUrl : /prod-api/profile/upload/image/2021/05/08/d87665c4-79e7-47aa-aea1-d7180890ba38.jpg
         * score : 5.0
         * createBy : null
         * createTime : 2021-05-08 15:41:38
         * updateBy : null
         * name : 炸匠先森·韩式炸鸡
         * id : 5
         * avgCost : 20.0
         * searchValue : null
         * saleNum3hour : 16
         * introduction : 选好肉 炸好鸡
         */
        private int saleQuantity;
        private String other;
        private String address;
        private int deliveryTime;
        private double distance;
        private int themeId;
        private String updateTime;
        private String remark;
        private String recommend;
        private ParamsEntity params;
        private String imgUrl;
        private double score;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String name;
        private int id;
        private double avgCost;
        private String searchValue;
        private int saleNum3hour;
        private String introduction;

        public void setSaleQuantity(int saleQuantity) {
            this.saleQuantity = saleQuantity;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setDeliveryTime(int deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public void setThemeId(int themeId) {
            this.themeId = themeId;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setAvgCost(double avgCost) {
            this.avgCost = avgCost;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setSaleNum3hour(int saleNum3hour) {
            this.saleNum3hour = saleNum3hour;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public int getSaleQuantity() {
            return saleQuantity;
        }

        public String getOther() {
            return other;
        }

        public String getAddress() {
            return address;
        }

        public int getDeliveryTime() {
            return deliveryTime;
        }

        public double getDistance() {
            return distance;
        }

        public int getThemeId() {
            return themeId;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public String getRecommend() {
            return recommend;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public double getScore() {
            return score;
        }

        public String getCreateBy() {
            return createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public double getAvgCost() {
            return avgCost;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public int getSaleNum3hour() {
            return saleNum3hour;
        }

        public String getIntroduction() {
            return introduction;
        }

        public class ParamsEntity {
        }
    }
}
