package com.huangxue.s01.Beans;

import java.util.List;

public class PayClassListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/95c51b0c-9674-4784-8011-324d02bd3487.png","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"liveName":"手机话费","id":1,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/72163ab8-832a-45e0-8d06-44546294affb.png","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"liveName":"水费","id":2,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/55867f4c-461a-42b2-9822-9c4cbbf563ba.png","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"liveName":"电费","id":3,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/7ddace97-4688-4260-8a1d-231070af5bf0.png","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"liveName":"燃气费","id":4,"params":{},"searchValue":null}]
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
         * imgUrl : /prod-api/profile/upload/image/2021/05/08/95c51b0c-9674-4784-8011-324d02bd3487.png
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * liveName : 手机话费
         * id : 1
         * params : {}
         * searchValue : null
         */
        private String imgUrl;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private String liveName;
        private int id;
        private ParamsEntity params;
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

        public void setLiveName(String liveName) {
            this.liveName = liveName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
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

        public String getLiveName() {
            return liveName;
        }

        public int getId() {
            return id;
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
