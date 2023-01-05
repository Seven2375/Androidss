package com.huangxue.s01.Beans;

public class CompanyInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"createBy":null,"createTime":null,"updateBy":null,"companyName":"虎鱼科技","updateTime":null,"remark":null,"id":3,"params":{},"introductory":"营收和利润的主要来源是商用POS机,智能POS机，智能POS称，肉菜追溯批发自助交易终端，智能印章管理系统","searchValue":null}
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
         * createBy : null
         * createTime : null
         * updateBy : null
         * companyName : 虎鱼科技
         * updateTime : null
         * remark : null
         * id : 3
         * params : {}
         * introductory : 营收和利润的主要来源是商用POS机,智能POS机，智能POS称，肉菜追溯批发自助交易终端，智能印章管理系统
         * searchValue : null
         */
        private String createBy;
        private String createTime;
        private String updateBy;
        private String companyName;
        private String updateTime;
        private String remark;
        private int id;
        private ParamsEntity params;
        private String introductory;
        private String searchValue;

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
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

        public void setIntroductory(String introductory) {
            this.introductory = introductory;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
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

        public String getCompanyName() {
            return companyName;
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

        public String getIntroductory() {
            return introductory;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity {
        }
    }
}
