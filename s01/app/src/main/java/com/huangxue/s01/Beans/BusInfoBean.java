package com.huangxue.s01.Beans;

public class BusInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"updateTime":"2020-10-21 11:23:35","remark":null,"params":{},"createBy":null,"createTime":"2020-10-05 11:23:32","updateBy":null,"price":8,"name":"一号线","end":"南湖大厦","startTime":"6:30","id":1,"endTime":"19:45","searchValue":null,"first":"光谷金融街","mileage":"20"}
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
         * updateTime : 2020-10-21 11:23:35
         * remark : null
         * params : {}
         * createBy : null
         * createTime : 2020-10-05 11:23:32
         * updateBy : null
         * price : 8.0
         * name : 一号线
         * end : 南湖大厦
         * startTime : 6:30
         * id : 1
         * endTime : 19:45
         * searchValue : null
         * first : 光谷金融街
         * mileage : 20
         */
        private String updateTime;
        private String remark;
        private ParamsEntity params;
        private String createBy;
        private String createTime;
        private String updateBy;
        private double price;
        private String name;
        private String end;
        private String startTime;
        private int id;
        private String endTime;
        private String searchValue;
        private String first;
        private String mileage;

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
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

        public void setPrice(double price) {
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public void setMileage(String mileage) {
            this.mileage = mileage;
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

        public String getCreateBy() {
            return createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public String getEnd() {
            return end;
        }

        public String getStartTime() {
            return startTime;
        }

        public int getId() {
            return id;
        }

        public String getEndTime() {
            return endTime;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public String getFirst() {
            return first;
        }

        public String getMileage() {
            return mileage;
        }

        public class ParamsEntity {
        }
    }
}
