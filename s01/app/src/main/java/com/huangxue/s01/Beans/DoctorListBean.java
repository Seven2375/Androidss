package com.huangxue.s01.Beans;

import java.util.List;

public class DoctorListBean {

    /**
     * msg : 查询成功
     * total : 4
     * code : 200
     * rows : [{"jobName":"主治兽医师","practiceNo":"A012018110114","goodAt":"国家认证执业兽医师，擅长猫内科、兔科、鼠类、龟、擅长猫内科疾病，兔科内科疾病和其他异宠疾病，北京小动物内科协会会，有丰富大量的临床经验。","workingYears":8,"updateTime":null,"remark":null,"avatar":"/prod-api/profile/upload/image/2022/03/14/922f1a88-6164-4f7b-9754-bc97b2b6c4f4.jpeg","params":{},"createBy":null,"createTime":null,"updateBy":null,"name":"周建","typeId":15,"id":17,"searchValue":null},{"jobName":"主治兽医师","practiceNo":"A012019430117","goodAt":"湖南农业大学动物医院主治医生,擅长犬猫专科，呼吸系统疾病，泌尿系统疾病，肝胆系统疾病，消化道疾病，传染病，皮肤病。","workingYears":6,"updateTime":null,"remark":null,"avatar":"/prod-api/profile/upload/image/2022/03/14/9ed400b6-7ae8-4961-b9da-5badb30c7939.jpeg","params":{},"createBy":null,"createTime":null,"updateBy":null,"name":"魏煜","typeId":15,"id":15,"searchValue":null},{"jobName":"主治兽医师","practiceNo":"A012018430087","goodAt":"尿结石、胰腺外分泌功能不全、猫急性肾损伤、猫重症急救，传染性腹膜炎等、外耳炎、咽炎、胃内异物、眼睑内翻、再生障碍性贫血、真菌性鼻炎、甲状腺机能亢进、慢性口炎、幽门阻塞、支气管肺炎、猫弓形虫病、牙周炎、猫急性胃肠炎、尿路感染、糖尿病、胃肠炎、耳痒螨病、牙周炎、特异性膀胱炎","workingYears":6,"updateTime":null,"remark":null,"avatar":"/prod-api/profile/upload/image/2022/03/14/92d64e32-f445-4f0a-bcf9-202672555957.png","params":{},"createBy":null,"createTime":null,"updateBy":null,"name":"徐琦","typeId":15,"id":39,"searchValue":null},{"jobName":"技术院长","practiceNo":"A012016320093","goodAt":"研究方向犬猫内科，软组织外科，影像科。擅长犬猫皮肤病，呼吸系统疾病，消化系统疾病，泌尿疾病，肝胆系统疾病，肾病，心脏病，传染病等。兔子消化系统疾病，牙科疾病，皮肤疾病，肝肾内科。","workingYears":2,"updateTime":null,"remark":null,"avatar":"/prod-api/profile/upload/image/2022/03/14/14d0e8ac-03a3-431c-b01f-69f9a045b34c.jpeg","params":{},"createBy":null,"createTime":null,"updateBy":null,"name":"高振","typeId":15,"id":29,"searchValue":null}]
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
         * jobName : 主治兽医师
         * practiceNo : A012018110114
         * goodAt : 国家认证执业兽医师，擅长猫内科、兔科、鼠类、龟、擅长猫内科疾病，兔科内科疾病和其他异宠疾病，北京小动物内科协会会，有丰富大量的临床经验。
         * workingYears : 8
         * updateTime : null
         * remark : null
         * avatar : /prod-api/profile/upload/image/2022/03/14/922f1a88-6164-4f7b-9754-bc97b2b6c4f4.jpeg
         * params : {}
         * createBy : null
         * createTime : null
         * updateBy : null
         * name : 周建
         * typeId : 15
         * id : 17
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
