package com.huangxue.s01.Beans;

import java.util.List;

public class NewsClassBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"updateTime":null,"remark":null,"sort":1,"params":{},"parentId":null,"createBy":null,"createTime":null,"updateBy":null,"appType":"smart_city","name":"今日要闻","id":9,"searchValue":null,"status":"Y"},{"updateTime":null,"remark":null,"sort":5,"params":{},"parentId":null,"createBy":null,"createTime":null,"updateBy":null,"appType":"smart_city","name":"专题聚焦","id":17,"searchValue":null,"status":"Y"},{"updateTime":null,"remark":null,"sort":7,"params":{},"parentId":null,"createBy":null,"createTime":null,"updateBy":null,"appType":"smart_city","name":"政策解读","id":19,"searchValue":null,"status":"Y"},{"updateTime":null,"remark":null,"sort":8,"params":{},"parentId":null,"createBy":null,"createTime":null,"updateBy":null,"appType":"smart_city","name":"经济发展","id":20,"searchValue":null,"status":"Y"},{"updateTime":null,"remark":null,"sort":9,"params":{},"parentId":null,"createBy":null,"createTime":null,"updateBy":null,"appType":"smart_city","name":"文化旅游","id":21,"searchValue":null,"status":"Y"},{"updateTime":null,"remark":null,"sort":10,"params":{},"parentId":null,"createBy":null,"createTime":null,"updateBy":null,"appType":"smart_city","name":"科技创新","id":22,"searchValue":null,"status":"Y"}]
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
         * updateTime : null
         * remark : null
         * sort : 1
         * params : {}
         * parentId : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * appType : smart_city
         * name : 今日要闻
         * id : 9
         * searchValue : null
         * status : Y
         */
        private String updateTime;
        private String remark;
        private int sort;
        private ParamsEntity params;
        private String parentId;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String appType;
        private String name;
        private int id;
        private String searchValue;
        private String status;

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
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

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public int getSort() {
            return sort;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getParentId() {
            return parentId;
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

        public String getAppType() {
            return appType;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public String getStatus() {
            return status;
        }

        public class ParamsEntity {
        }
    }
}
