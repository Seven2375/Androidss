package com.huangxue.s01.Beans;

import java.util.List;

public class TakeoutMenuClassListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"createBy":null,"sellerId":1,"createTime":"2021-05-08 15:30:07","updateBy":null,"name":"披萨","themeId":5,"updateTime":"2021-05-09 14:23:23","remark":null,"id":3,"sort":1,"params":{},"searchValue":null},{"createBy":null,"sellerId":1,"createTime":"2021-05-09 14:24:08","updateBy":null,"name":"组合套餐","themeId":3,"updateTime":"2021-05-09 14:25:17","remark":null,"id":19,"sort":2,"params":{},"searchValue":null},{"createBy":null,"sellerId":1,"createTime":"2021-05-09 14:24:23","updateBy":null,"name":"焗饭","themeId":3,"updateTime":"2021-05-11 21:36:08","remark":null,"id":20,"sort":3,"params":{},"searchValue":null}]
     */
    private String msg;
    private int code;
    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * createBy : null
         * sellerId : 1
         * createTime : 2021-05-08 15:30:07
         * updateBy : null
         * name : 披萨
         * themeId : 5
         * updateTime : 2021-05-09 14:23:23
         * remark : null
         * id : 3
         * sort : 1
         * params : {}
         * searchValue : null
         */
        private String createBy;
        private int sellerId;
        private String createTime;
        private String updateBy;
        private String name;
        private int themeId;
        private String updateTime;
        private String remark;
        private int id;
        private int sort;
        private ParamsEntity params;
        private String searchValue;

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
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

        public void setThemeId(int themeId) {
            this.themeId = themeId;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public int getSellerId() {
            return sellerId;
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

        public int getThemeId() {
            return themeId;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public int getId() {
            return id;
        }

        public int getSort() {
            return sort;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity {
        }
    }
}
