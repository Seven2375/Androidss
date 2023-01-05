package com.huangxue.s01.Beans;

public class JobInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"address":"大连市万达广场","need":"工作经验1-2年","companyName":null,"updateTime":null,"remark":null,"params":{},"salary":"5000","createBy":null,"companyId":3,"createTime":null,"updateBy":null,"obligation":"负责软件的设计开发测试以及上线","professionName":null,"name":"软件开发","id":1,"searchValue":null,"contacts":"张先生","professionId":1}
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
         * address : 大连市万达广场
         * need : 工作经验1-2年
         * companyName : null
         * updateTime : null
         * remark : null
         * params : {}
         * salary : 5000
         * createBy : null
         * companyId : 3
         * createTime : null
         * updateBy : null
         * obligation : 负责软件的设计开发测试以及上线
         * professionName : null
         * name : 软件开发
         * id : 1
         * searchValue : null
         * contacts : 张先生
         * professionId : 1
         */
        private String address;
        private String need;
        private String companyName;
        private String updateTime;
        private String remark;
        private ParamsEntity params;
        private String salary;
        private String createBy;
        private int companyId;
        private String createTime;
        private String updateBy;
        private String obligation;
        private String professionName;
        private String name;
        private int id;
        private String searchValue;
        private String contacts;
        private int professionId;

        public void setAddress(String address) {
            this.address = address;
        }

        public void setNeed(String need) {
            this.need = need;
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

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setObligation(String obligation) {
            this.obligation = obligation;
        }

        public void setProfessionName(String professionName) {
            this.professionName = professionName;
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

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public void setProfessionId(int professionId) {
            this.professionId = professionId;
        }

        public String getAddress() {
            return address;
        }

        public String getNeed() {
            return need;
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

        public ParamsEntity getParams() {
            return params;
        }

        public String getSalary() {
            return salary;
        }

        public String getCreateBy() {
            return createBy;
        }

        public int getCompanyId() {
            return companyId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public String getObligation() {
            return obligation;
        }

        public String getProfessionName() {
            return professionName;
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

        public String getContacts() {
            return contacts;
        }

        public int getProfessionId() {
            return professionId;
        }

        public class ParamsEntity {
        }
    }
}
