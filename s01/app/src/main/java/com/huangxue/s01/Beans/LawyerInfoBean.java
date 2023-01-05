package com.huangxue.s01.Beans;

public class LawyerInfoBean {


    /**
     * msg : 操作成功
     * code : 200
     * data : {"baseInfo":"张付杰律师秉承\u201c专注\u201d、\u201c专业\u201d、\u201c专心\u201d执业理念，专注相关法律领域，以专业的技能专心为委托人提供优质的法律服务，先后承办多起国内重大案件，被主流媒体跟踪报道，最终维护了相关当事人的合法权益，伸张了法律的正义。现担任多家企业法律顾问，参与多起重大商务谈判，为委托人的发展保驾护航，得到了委托人的一致好评。","licenseNo":"13101201310126434","avatarUrl":"/prod-api/profile/upload/2022/03/12/a32e46e9-f0fc-406e-a3f5-33751131c109.jpeg","workStartAt":"2020-03-10","serviceTimes":3,"eduInfo":"中央法律学院优秀毕业生，政法专业。","updateTime":null,"remark":null,"sort":"favorableRate","params":{},"favorableRate":100,"legalExpertiseId":15,"createBy":null,"favorableCount":0,"createTime":null,"updateBy":null,"legalExpertiseName":"劳动纠纷","name":"张付杰律师","certificateImgUrl":"/dev-api/profile/upload/2022/03/12/e4461d95-3dda-4cd7-a560-d642e5b726bd.jpeg","id":21,"searchValue":null}
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
         * baseInfo : 张付杰律师秉承“专注”、“专业”、“专心”执业理念，专注相关法律领域，以专业的技能专心为委托人提供优质的法律服务，先后承办多起国内重大案件，被主流媒体跟踪报道，最终维护了相关当事人的合法权益，伸张了法律的正义。现担任多家企业法律顾问，参与多起重大商务谈判，为委托人的发展保驾护航，得到了委托人的一致好评。
         * licenseNo : 13101201310126434
         * avatarUrl : /prod-api/profile/upload/2022/03/12/a32e46e9-f0fc-406e-a3f5-33751131c109.jpeg
         * workStartAt : 2020-03-10
         * serviceTimes : 3
         * eduInfo : 中央法律学院优秀毕业生，政法专业。
         * updateTime : null
         * remark : null
         * sort : favorableRate
         * params : {}
         * favorableRate : 100
         * legalExpertiseId : 15
         * createBy : null
         * favorableCount : 0
         * createTime : null
         * updateBy : null
         * legalExpertiseName : 劳动纠纷
         * name : 张付杰律师
         * certificateImgUrl : /dev-api/profile/upload/2022/03/12/e4461d95-3dda-4cd7-a560-d642e5b726bd.jpeg
         * id : 21
         * searchValue : null
         */
        private String baseInfo;
        private String licenseNo;
        private String avatarUrl;
        private String workStartAt;
        private int serviceTimes;
        private String eduInfo;
        private String updateTime;
        private String remark;
        private String sort;
        private ParamsEntity params;
        private int favorableRate;
        private int legalExpertiseId;
        private String createBy;
        private int favorableCount;
        private String createTime;
        private String updateBy;
        private String legalExpertiseName;
        private String name;
        private String certificateImgUrl;
        private int id;
        private String searchValue;

        public void setBaseInfo(String baseInfo) {
            this.baseInfo = baseInfo;
        }

        public void setLicenseNo(String licenseNo) {
            this.licenseNo = licenseNo;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public void setWorkStartAt(String workStartAt) {
            this.workStartAt = workStartAt;
        }

        public void setServiceTimes(int serviceTimes) {
            this.serviceTimes = serviceTimes;
        }

        public void setEduInfo(String eduInfo) {
            this.eduInfo = eduInfo;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setFavorableRate(int favorableRate) {
            this.favorableRate = favorableRate;
        }

        public void setLegalExpertiseId(int legalExpertiseId) {
            this.legalExpertiseId = legalExpertiseId;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setFavorableCount(int favorableCount) {
            this.favorableCount = favorableCount;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setLegalExpertiseName(String legalExpertiseName) {
            this.legalExpertiseName = legalExpertiseName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCertificateImgUrl(String certificateImgUrl) {
            this.certificateImgUrl = certificateImgUrl;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getBaseInfo() {
            return baseInfo;
        }

        public String getLicenseNo() {
            return licenseNo;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public String getWorkStartAt() {
            return workStartAt;
        }

        public int getServiceTimes() {
            return serviceTimes;
        }

        public String getEduInfo() {
            return eduInfo;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public String getSort() {
            return sort;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public int getFavorableRate() {
            return favorableRate;
        }

        public int getLegalExpertiseId() {
            return legalExpertiseId;
        }

        public String getCreateBy() {
            return createBy;
        }

        public int getFavorableCount() {
            return favorableCount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public String getLegalExpertiseName() {
            return legalExpertiseName;
        }

        public String getName() {
            return name;
        }

        public String getCertificateImgUrl() {
            return certificateImgUrl;
        }

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity {
        }
    }
}
