package com.huangxue.s01.Beans;

public class StopInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"address":"广达","parkName":"广达停车场","distance":"20","rates":"5","priceCaps":"30","updateTime":null,"remark":null,"params":{},"imgUrl":"/profile/p3.jpg","createBy":null,"allPark":"90","createTime":null,"updateBy":null,"id":3,"searchValue":null,"vacancy":"30","open":"Y"}
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
         * address : 广达
         * parkName : 广达停车场
         * distance : 20
         * rates : 5
         * priceCaps : 30
         * updateTime : null
         * remark : null
         * params : {}
         * imgUrl : /profile/p3.jpg
         * createBy : null
         * allPark : 90
         * createTime : null
         * updateBy : null
         * id : 3
         * searchValue : null
         * vacancy : 30
         * open : Y
         */
        private String address;
        private String parkName;
        private String distance;
        private String rates;
        private String priceCaps;
        private String updateTime;
        private String remark;
        private ParamsEntity params;
        private String imgUrl;
        private String createBy;
        private String allPark;
        private String createTime;
        private String updateBy;
        private int id;
        private String searchValue;
        private String vacancy;
        private String open;

        public void setAddress(String address) {
            this.address = address;
        }

        public void setParkName(String parkName) {
            this.parkName = parkName;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public void setRates(String rates) {
            this.rates = rates;
        }

        public void setPriceCaps(String priceCaps) {
            this.priceCaps = priceCaps;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setAllPark(String allPark) {
            this.allPark = allPark;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setVacancy(String vacancy) {
            this.vacancy = vacancy;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getAddress() {
            return address;
        }

        public String getParkName() {
            return parkName;
        }

        public String getDistance() {
            return distance;
        }

        public String getRates() {
            return rates;
        }

        public String getPriceCaps() {
            return priceCaps;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public String getCreateBy() {
            return createBy;
        }

        public String getAllPark() {
            return allPark;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public String getVacancy() {
            return vacancy;
        }

        public String getOpen() {
            return open;
        }

        public class ParamsEntity {
        }
    }
}
