package com.huangxue.s01.Beans;

import java.util.List;

public class MyAskInfoListBean {

    /**
     * msg : 查询成功
     * total : 2
     * code : 200
     * rows : [{"createBy":null,"createTime":"2022-12-31 15:50:43","updateBy":null,"inquiryId":2642,"updateTime":null,"remark":null,"id":1073,"params":{},"searchValue":null,"fromId":1114951,"content":"这小猫从出生到现在12岁了，就没吃过饭，咋整啊医生~","fromRole":"0"},{"createBy":null,"createTime":"2022-12-31 14:56:14","updateBy":null,"inquiryId":2642,"updateTime":null,"remark":null,"id":1072,"params":{},"searchValue":null,"fromId":1114951,"content":"这小猫从出生到现在12岁了，就没吃过饭，咋整啊医生~","fromRole":"0"}]
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
         * createBy : null
         * createTime : 2022-12-31 15:50:43
         * updateBy : null
         * inquiryId : 2642
         * updateTime : null
         * remark : null
         * id : 1073
         * params : {}
         * searchValue : null
         * fromId : 1114951
         * content : 这小猫从出生到现在12岁了，就没吃过饭，咋整啊医生~
         * fromRole : 0
         */
        private String createBy;
        private String createTime;
        private String updateBy;
        private int inquiryId;
        private String updateTime;
        private String remark;
        private int id;
        private ParamsEntity params;
        private String searchValue;
        private int fromId;
        private String content;
        private String fromRole;

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setInquiryId(int inquiryId) {
            this.inquiryId = inquiryId;
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

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setFromId(int fromId) {
            this.fromId = fromId;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setFromRole(String fromRole) {
            this.fromRole = fromRole;
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

        public int getInquiryId() {
            return inquiryId;
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

        public ParamsEntity getParams() {
            return params;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public int getFromId() {
            return fromId;
        }

        public String getContent() {
            return content;
        }

        public String getFromRole() {
            return fromRole;
        }

        public class ParamsEntity {
        }
    }
}
