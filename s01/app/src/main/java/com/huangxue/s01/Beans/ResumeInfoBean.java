package com.huangxue.s01.Beans;

public class ResumeInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"positionName":null,"education":"本科","address":"北京","mostEducation":"博士","money":"7000","positionId":2,"files":"/dev-apihttp://localhost:9090/profile/upload/2021/04/22 /1ac5e66a-0381-4867-9026-3ec00fff3ecf.pdf","id":1,"experience":"1 年","userName":null,"userId":1,"individualResume":"性格有点内向、乐观上进、有爱心并善于施教并行; 对待工作认真负责，善于沟通、协调有较强的组织能力与团队精神;上进心强、 勤于学习能不断进步自身的能力与综合素质。在未来的工作中，我将以充沛的精 力，刻苦钻研的精神来努力工作，稳定地进步自己的工作能力，与公司同步发展。 "}
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
         * positionName : null
         * education : 本科
         * address : 北京
         * mostEducation : 博士
         * money : 7000
         * positionId : 2
         * files : /dev-apihttp://localhost:9090/profile/upload/2021/04/22 /1ac5e66a-0381-4867-9026-3ec00fff3ecf.pdf
         * id : 1
         * experience : 1 年
         * userName : null
         * userId : 1
         * individualResume : 性格有点内向、乐观上进、有爱心并善于施教并行; 对待工作认真负责，善于沟通、协调有较强的组织能力与团队精神;上进心强、 勤于学习能不断进步自身的能力与综合素质。在未来的工作中，我将以充沛的精 力，刻苦钻研的精神来努力工作，稳定地进步自己的工作能力，与公司同步发展。
         */
        private String positionName;
        private String education;
        private String address;
        private String mostEducation;
        private String money;
        private int positionId;
        private String files;
        private int id;
        private String experience;
        private String userName;
        private int userId;
        private String individualResume;

        public void setPositionName(String positionName) {
            this.positionName = positionName;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setMostEducation(String mostEducation) {
            this.mostEducation = mostEducation;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public void setPositionId(int positionId) {
            this.positionId = positionId;
        }

        public void setFiles(String files) {
            this.files = files;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setIndividualResume(String individualResume) {
            this.individualResume = individualResume;
        }

        public String getPositionName() {
            return positionName;
        }

        public String getEducation() {
            return education;
        }

        public String getAddress() {
            return address;
        }

        public String getMostEducation() {
            return mostEducation;
        }

        public String getMoney() {
            return money;
        }

        public int getPositionId() {
            return positionId;
        }

        public String getFiles() {
            return files;
        }

        public int getId() {
            return id;
        }

        public String getExperience() {
            return experience;
        }

        public String getUserName() {
            return userName;
        }

        public int getUserId() {
            return userId;
        }

        public String getIndividualResume() {
            return individualResume;
        }
    }
}
