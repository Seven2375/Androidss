package com.huangxue.s01.Beans;

import java.util.List;

public class AskListBean {

    /**
     * msg : 查询成功
     * total : 2
     * code : 200
     * rows : [{"question":"我的猫把我家狗打死了","updateTime":null,"remark":null,"params":{},"userId":1114951,"doctor":{"jobName":"主治兽医师","practiceNo":"A012020430067","goodAt":"猫泌尿道综合征,膀胱结石,尿道结石,膀胱肿瘤,尿道肿瘤,乳腺肿瘤,子宫肌瘤,子宫蓄脓,阴道增生,阴道脱出,子宫脱出,前列腺增生,前列腺囊肿,前列腺肿瘤,睾丸肿瘤,","workingYears":10,"updateTime":null,"remark":null,"avatar":"/prod-api/profile/upload/image/2022/03/14/29f74240-d384-4acb-a3f4-b060ef53a22a.png","params":{},"createBy":null,"createTime":null,"updateBy":null,"name":"黄博","typeId":17,"id":35,"searchValue":null},"createBy":null,"createTime":"2022-12-31 14:15:54","updateBy":null,"doctorId":35,"imageUrls":null,"id":2642,"searchValue":null},{"question":"我们家小猫一年没睡觉了，怎么办？","updateTime":null,"remark":null,"params":{},"userId":1114951,"doctor":null,"createBy":null,"createTime":"2022-12-22 17:19:27","updateBy":null,"doctorId":9,"imageUrls":null,"id":2532,"searchValue":null}]
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
         * question : 我的猫把我家狗打死了
         * updateTime : null
         * remark : null
         * params : {}
         * userId : 1114951
         * doctor : {"jobName":"主治兽医师","practiceNo":"A012020430067","goodAt":"猫泌尿道综合征,膀胱结石,尿道结石,膀胱肿瘤,尿道肿瘤,乳腺肿瘤,子宫肌瘤,子宫蓄脓,阴道增生,阴道脱出,子宫脱出,前列腺增生,前列腺囊肿,前列腺肿瘤,睾丸肿瘤,","workingYears":10,"updateTime":null,"remark":null,"avatar":"/prod-api/profile/upload/image/2022/03/14/29f74240-d384-4acb-a3f4-b060ef53a22a.png","params":{},"createBy":null,"createTime":null,"updateBy":null,"name":"黄博","typeId":17,"id":35,"searchValue":null}
         * createBy : null
         * createTime : 2022-12-31 14:15:54
         * updateBy : null
         * doctorId : 35
         * imageUrls : null
         * id : 2642
         * searchValue : null
         */
        private String question;
        private String updateTime;
        private String remark;
        private ParamsEntity params;
        private int userId;
        private DoctorEntity doctor;
        private String createBy;
        private String createTime;
        private String updateBy;
        private int doctorId;
        private String imageUrls;
        private int id;
        private String searchValue;

        public void setQuestion(String question) {
            this.question = question;
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

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setDoctor(DoctorEntity doctor) {
            this.doctor = doctor;
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

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public void setImageUrls(String imageUrls) {
            this.imageUrls = imageUrls;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getQuestion() {
            return question;
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

        public int getUserId() {
            return userId;
        }

        public DoctorEntity getDoctor() {
            return doctor;
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

        public int getDoctorId() {
            return doctorId;
        }

        public String getImageUrls() {
            return imageUrls;
        }

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity {
        }

        public class DoctorEntity {
            /**
             * jobName : 主治兽医师
             * practiceNo : A012020430067
             * goodAt : 猫泌尿道综合征,膀胱结石,尿道结石,膀胱肿瘤,尿道肿瘤,乳腺肿瘤,子宫肌瘤,子宫蓄脓,阴道增生,阴道脱出,子宫脱出,前列腺增生,前列腺囊肿,前列腺肿瘤,睾丸肿瘤,
             * workingYears : 10
             * updateTime : null
             * remark : null
             * avatar : /prod-api/profile/upload/image/2022/03/14/29f74240-d384-4acb-a3f4-b060ef53a22a.png
             * params : {}
             * createBy : null
             * createTime : null
             * updateBy : null
             * name : 黄博
             * typeId : 17
             * id : 35
             * searchValue : null
             */
            private String jobName;
            private String practiceNo;
            private String goodAt;
            private int workingYears;
            private String updateTime;
            private String remark;
            private String avatar;
            private ParamsEntity params;
            private String createBy;
            private String createTime;
            private String updateBy;
            private String name;
            private int typeId;
            private int id;
            private String searchValue;

            public void setJobName(String jobName) {
                this.jobName = jobName;
            }

            public void setPracticeNo(String practiceNo) {
                this.practiceNo = practiceNo;
            }

            public void setGoodAt(String goodAt) {
                this.goodAt = goodAt;
            }

            public void setWorkingYears(int workingYears) {
                this.workingYears = workingYears;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public void setParams(ParamsEntity params) {
                this.params = params;
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

            public void setName(String name) {
                this.name = name;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setSearchValue(String searchValue) {
                this.searchValue = searchValue;
            }

            public String getJobName() {
                return jobName;
            }

            public String getPracticeNo() {
                return practiceNo;
            }

            public String getGoodAt() {
                return goodAt;
            }

            public int getWorkingYears() {
                return workingYears;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public String getRemark() {
                return remark;
            }

            public String getAvatar() {
                return avatar;
            }

            public ParamsEntity getParams() {
                return params;
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

            public String getName() {
                return name;
            }

            public int getTypeId() {
                return typeId;
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
}
