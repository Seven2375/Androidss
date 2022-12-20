package com.huangxue.s01.Beans;

import java.util.List;

public class BusLineListBean {


    /**
     * msg : 查询成功
     * total : 4
     * code : 200
     * rows : [{"updateTime":"2020-10-21 11:23:35","remark":null,"params":{},"createBy":null,"createTime":"2020-10-05 11:23:32","updateBy":null,"price":8,"name":"一号线","end":"南湖大厦","startTime":"6:30","id":1,"endTime":"19:45","searchValue":null,"first":"光谷金融街","mileage":"20"},{"updateTime":"2020-10-22 12:29:00","remark":null,"params":{},"createBy":null,"createTime":"2020-10-13 12:28:57","updateBy":null,"price":8,"name":"二号线","end":"万达广场","startTime":"6:30","id":2,"endTime":"21:45","searchValue":null,"first":"光谷金融街","mileage":"22"},{"updateTime":"2020-10-27 16:57:21","remark":null,"params":{},"createBy":null,"createTime":"2020-10-27 16:57:07","updateBy":null,"price":9,"name":"三号线","end":"金石沙滩","startTime":"6:30","id":3,"endTime":"22:00","searchValue":null,"first":"香炉礁","mileage":"30"},{"updateTime":"2020-10-27 16:59:06","remark":null,"params":{},"createBy":null,"createTime":"2020-10-27 16:59:03","updateBy":null,"price":12,"name":"十二号线","end":"辛寨子","startTime":"5:30","id":4,"endTime":"23:00","searchValue":null,"first":"河口","mileage":"40"}]
     */
    private String msg;
    private int total;
    private int code;
    private List<RowsEntity> rows;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setRows(List<RowsEntity> rows) {
        this.rows = rows;
    }

    public String getMsg() {
        return msg;
    }

    public int getTotal() {
        return total;
    }

    public int getCode() {
        return code;
    }

    public List<RowsEntity> getRows() {
        return rows;
    }

    public class RowsEntity {
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
