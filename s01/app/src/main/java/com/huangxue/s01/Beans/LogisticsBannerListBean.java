package com.huangxue.s01.Beans;

import java.util.List;

public class LogisticsBannerListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/1d403222-d598-4a1c-8eab-437e226e094d.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":7,"sort":1,"params":{},"title":"顺丰快递推出小时达同城服务","searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/f466ebc3-5044-436a-9825-d95dd7c415e4.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":8,"sort":2,"params":{},"title":"韵达快递收件时发件可享5折优惠","searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/8e5d2c4c-0d99-4b26-9576-5593a3a37ec8.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":9,"sort":3,"params":{},"title":"京东物流全面支持第三方发件服务","searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/08d70db6-f567-4ea1-aca4-697fddab76fc.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":10,"sort":4,"params":{},"title":"申通快递全国运费降价","searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/c58402cc-bd4a-43dd-8df7-886cf750b571.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":11,"sort":5,"params":{},"title":"圆通快递新进物流运输车，运输速度更加迅速","searchValue":null}]
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
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/1d403222-d598-4a1c-8eab-437e226e094d.jpeg
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * id : 7
         * sort : 1
         * params : {}
         * title : 顺丰快递推出小时达同城服务
         * searchValue : null
         */
        private String imgUrl;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private int id;
        private int sort;
        private ParamsEntity params;
        private String title;
        private String searchValue;

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
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

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getImgUrl() {
            return imgUrl;
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

        public String getTitle() {
            return title;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity {
        }
    }
}
