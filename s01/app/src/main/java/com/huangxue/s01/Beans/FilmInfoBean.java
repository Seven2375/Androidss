package com.huangxue.s01.Beans;

public class FilmInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"other":null,"updateTime":null,"remark":null,"language":"英文","recommend":"Y","params":{},"likeNum":178,"favoriteNum":230,"cover":"/prod-api/profile/upload/image/2021/04/07/c7fba3ca-59bb-4e25-9b8f-237ca7a99970.png","duration":180,"score":4,"createBy":null,"createTime":null,"updateBy":null,"playType":"1","playDate":"2021-04-08","name":"变形金刚","id":2,"category":"8","searchValue":null,"introduction":"<p>请问恶趣味翁翁<\/p>"}
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
         * other : null
         * updateTime : null
         * remark : null
         * language : 英文
         * recommend : Y
         * params : {}
         * likeNum : 178
         * favoriteNum : 230
         * cover : /prod-api/profile/upload/image/2021/04/07/c7fba3ca-59bb-4e25-9b8f-237ca7a99970.png
         * duration : 180
         * score : 4
         * createBy : null
         * createTime : null
         * updateBy : null
         * playType : 1
         * playDate : 2021-04-08
         * name : 变形金刚
         * id : 2
         * category : 8
         * searchValue : null
         * introduction : <p>请问恶趣味翁翁</p>
         */
        private String other;
        private String updateTime;
        private String remark;
        private String language;
        private String recommend;
        private ParamsEntity params;
        private int likeNum;
        private int favoriteNum;
        private String cover;
        private int duration;
        private int score;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String playType;
        private String playDate;
        private String name;
        private int id;
        private String category;
        private String searchValue;
        private String introduction;

        public void setOther(String other) {
            this.other = other;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setLikeNum(int likeNum) {
            this.likeNum = likeNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setDuration(int duration) {
            this.duration = duration;
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

        public void setPlayType(String playType) {
            this.playType = playType;
        }

        public void setPlayDate(String playDate) {
            this.playDate = playDate;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getOther() {
            return other;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public String getLanguage() {
            return language;
        }

        public String getRecommend() {
            return recommend;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public int getLikeNum() {
            return likeNum;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public String getCover() {
            return cover;
        }

        public int getDuration() {
            return duration;
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

        public String getPlayType() {
            return playType;
        }

        public String getPlayDate() {
            return playDate;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getCategory() {
            return category;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public String getIntroduction() {
            return introduction;
        }

        public class ParamsEntity {
        }
    }
}
