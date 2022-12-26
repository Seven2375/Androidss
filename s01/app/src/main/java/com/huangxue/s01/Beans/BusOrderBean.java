package com.huangxue.s01.Beans;

import java.util.List;

public class BusOrderBean {

    /**
     * msg : 查询成功
     * total : 3
     * code : 200
     * rows : [{"payTime":null,"start":"马楼大厦","orderNum":"54545035","updateTime":null,"remark":null,"userTel":"100861103","params":{},"userName":"niubi","userId":1114951,"paymentType":null,"path":"一号线","createBy":null,"createTime":"2022-12-20 22:10:50","updateBy":null,"price":100,"end":"牛逼北路","id":2567,"searchValue":null,"status":0},{"payTime":null,"start":"马楼大厦","orderNum":"54579896","updateTime":null,"remark":null,"userTel":"100861103","params":{},"userName":"niubi","userId":1114951,"paymentType":null,"path":"一号线","createBy":null,"createTime":"2022-12-20 22:16:39","updateBy":null,"price":100,"end":"牛逼北路","id":2568,"searchValue":null,"status":0},{"payTime":null,"start":"够比村","orderNum":"54653758","updateTime":null,"remark":null,"userTel":"100861103","params":{},"userName":"niubi","userId":1114951,"paymentType":null,"path":"一号线","createBy":null,"createTime":"2022-12-20 22:28:58","updateBy":null,"price":2,"end":"傻逼村","id":2569,"searchValue":null,"status":0}]
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
         * payTime : null
         * start : 马楼大厦
         * orderNum : 54545035
         * updateTime : null
         * remark : null
         * userTel : 100861103
         * params : {}
         * userName : niubi
         * userId : 1114951
         * paymentType : null
         * path : 一号线
         * createBy : null
         * createTime : 2022-12-20 22:10:50
         * updateBy : null
         * price : 100.0
         * end : 牛逼北路
         * id : 2567
         * searchValue : null
         * status : 0
         */
        private String payTime;
        private String start;
        private String orderNum;
        private String updateTime;
        private String remark;
        private String userTel;
        private ParamsEntity params;
        private String userName;
        private int userId;
        private String paymentType;
        private String path;
        private String createBy;
        private String createTime;
        private String updateBy;
        private double price;
        private String end;
        private int id;
        private String searchValue;
        private int status;

        public void setPayTime(String payTime) {
            this.payTime = payTime;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        public void setPath(String path) {
            this.path = path;
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

        public void setEnd(String end) {
            this.end = end;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getPayTime() {
            return payTime;
        }

        public String getStart() {
            return start;
        }

        public String getOrderNum() {
            return orderNum;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public String getUserTel() {
            return userTel;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getUserName() {
            return userName;
        }

        public int getUserId() {
            return userId;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public String getPath() {
            return path;
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

        public String getEnd() {
            return end;
        }

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public int getStatus() {
            return status;
        }

        public class ParamsEntity {
        }
    }
}
