package com.huangxue.s01.Beans;

import java.util.List;

public class LawyerAskListBean {

    /**
     * msg : 查询成功
     * total : 3
     * code : 200
     * rows : [{"lawyerName":"陈宇律师","fromUserId":1114951,"updateTime":null,"remark":null,"likeCount":288,"params":{},"content":"要把沙发装冰箱，总共分几步？","legalExpertiseId":7,"score":0,"createBy":null,"createTime":"2023-01-05 19:33:38","updateBy":null,"phone":"18842656666","imageUrls":null,"legalExpertiseName":null,"id":1007,"lawyerId":10,"state":"0","searchValue":null,"evaluate":null},{"lawyerName":"王珂律师","fromUserId":1114951,"updateTime":null,"remark":null,"likeCount":288,"params":{},"content":"翘车头上高速违法吗","legalExpertiseId":13,"score":0,"createBy":null,"createTime":"2023-01-05 22:28:26","updateBy":null,"phone":"163336699","imageUrls":null,"legalExpertiseName":"交通事故","id":1008,"lawyerId":18,"state":"0","searchValue":null,"evaluate":null},{"lawyerName":"金颖律师","fromUserId":1114951,"updateTime":null,"remark":null,"likeCount":288,"params":{},"content":null,"legalExpertiseId":13,"score":0,"createBy":null,"createTime":"2023-01-05 22:34:12","updateBy":null,"phone":"99999","imageUrls":null,"legalExpertiseName":"交通事故","id":1009,"lawyerId":16,"state":"0","searchValue":null,"evaluate":null}]
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
         * lawyerName : 陈宇律师
         * fromUserId : 1114951
         * updateTime : null
         * remark : null
         * likeCount : 288
         * params : {}
         * content : 要把沙发装冰箱，总共分几步？
         * legalExpertiseId : 7
         * score : 0
         * createBy : null
         * createTime : 2023-01-05 19:33:38
         * updateBy : null
         * phone : 18842656666
         * imageUrls : null
         * legalExpertiseName : null
         * id : 1007
         * lawyerId : 10
         * state : 0
         * searchValue : null
         * evaluate : null
         */
        private String lawyerName;
        private int fromUserId;
        private String updateTime;
        private String remark;
        private int likeCount;
        private ParamsEntity params;
        private String content;
        private int legalExpertiseId;
        private int score;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String phone;
        private String imageUrls;
        private String legalExpertiseName;
        private int id;
        private int lawyerId;
        private String state;
        private String searchValue;
        private String evaluate;

        public void setLawyerName(String lawyerName) {
            this.lawyerName = lawyerName;
        }

        public void setFromUserId(int fromUserId) {
            this.fromUserId = fromUserId;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setLegalExpertiseId(int legalExpertiseId) {
            this.legalExpertiseId = legalExpertiseId;
        }

        public void setScore(int score) {
            this.score = score;
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

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setImageUrls(String imageUrls) {
            this.imageUrls = imageUrls;
        }

        public void setLegalExpertiseName(String legalExpertiseName) {
            this.legalExpertiseName = legalExpertiseName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLawyerId(int lawyerId) {
            this.lawyerId = lawyerId;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setEvaluate(String evaluate) {
            this.evaluate = evaluate;
        }

        public String getLawyerName() {
            return lawyerName;
        }

        public int getFromUserId() {
            return fromUserId;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getContent() {
            return content;
        }

        public int getLegalExpertiseId() {
            return legalExpertiseId;
        }

        public int getScore() {
            return score;
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

        public String getPhone() {
            return phone;
        }

        public String getImageUrls() {
            return imageUrls;
        }

        public String getLegalExpertiseName() {
            return legalExpertiseName;
        }

        public int getId() {
            return id;
        }

        public int getLawyerId() {
            return lawyerId;
        }

        public String getState() {
            return state;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public String getEvaluate() {
            return evaluate;
        }

        public class ParamsEntity {
        }
    }
}
