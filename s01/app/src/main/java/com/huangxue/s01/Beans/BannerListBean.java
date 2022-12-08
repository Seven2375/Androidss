package com.huangxue.s01.Beans;

import java.util.List;

public class BannerListBean {

    /**
     * msg : 查询成功
     * total : 3
     * code : 200
     * rows : [{"targetId":28,"updateTime":"2021-06-25 11:02:40","remark":null,"sort":2,"advTitle":"首页轮播","params":{},"type":"2","advImg":"/prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png","servModule":"新闻详情","createBy":"admin","createTime":"2021-05-06 15:40:17","updateBy":"1","appType":"smart_city","id":25,"searchValue":null,"status":"1"},{"targetId":29,"updateTime":"2021-06-25 11:02:51","remark":null,"sort":3,"advTitle":"首页轮播","params":{},"type":"2","advImg":"/prod-api/profile/upload/image/2021/05/06/e614cb7f-63b0-4cda-bf47-db286ea1b074.png","servModule":"新闻详情","createBy":"admin","createTime":"2021-05-06 15:40:59","updateBy":"1111129","appType":"smart_city","id":26,"searchValue":null,"status":"1"},{"targetId":30,"updateTime":"2021-06-25 11:03:10","remark":null,"sort":4,"advTitle":"首页轮播","params":{},"type":"2","advImg":"/prod-api/profile/upload/image/2021/05/06/242e06f7-9fb0-4e16-b197-206f999c98f2.png","servModule":"新闻详情","createBy":"admin","createTime":"2021-05-06 15:41:20","updateBy":"1111129","appType":"smart_city","id":27,"searchValue":null,"status":"1"}]
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
         * targetId : 28
         * updateTime : 2021-06-25 11:02:40
         * remark : null
         * sort : 2
         * advTitle : 首页轮播
         * params : {}
         * type : 2
         * advImg : /prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png
         * servModule : 新闻详情
         * createBy : admin
         * createTime : 2021-05-06 15:40:17
         * updateBy : 1
         * appType : smart_city
         * id : 25
         * searchValue : null
         * status : 1
         */
        private int targetId;
        private String updateTime;
        private String remark;
        private int sort;
        private String advTitle;
        private ParamsEntity params;
        private String type;
        private String advImg;
        private String servModule;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String appType;
        private int id;
        private String searchValue;
        private String status;

        public void setTargetId(int targetId) {
            this.targetId = targetId;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setAdvTitle(String advTitle) {
            this.advTitle = advTitle;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setAdvImg(String advImg) {
            this.advImg = advImg;
        }

        public void setServModule(String servModule) {
            this.servModule = servModule;
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

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getTargetId() {
            return targetId;
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

        public String getAdvTitle() {
            return advTitle;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getType() {
            return type;
        }

        public String getAdvImg() {
            return advImg;
        }

        public String getServModule() {
            return servModule;
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
