package com.huangxue.s01.Beans;

import java.util.List;

public class NewsCommentListBean {

    /**
     * msg : 查询成功
     * total : 3
     * code : 200
     * rows : [{"updateTime":null,"remark":null,"params":{},"userName":"lizheng","userId":1113470,"content":"你在干嘛","likeNum":16,"createBy":null,"newsId":8,"createTime":null,"updateBy":null,"appType":"park","commentDate":"2022-11-30 12:54:21","newsTitle":"六城市成智慧城市基础设施与智能网联汽车协同发展试点","id":3814,"searchValue":null},{"updateTime":null,"remark":null,"params":{},"userName":"lizheng","userId":1113470,"content":"","likeNum":6,"createBy":null,"newsId":8,"createTime":null,"updateBy":null,"appType":"park","commentDate":"2022-11-30 12:54:24","newsTitle":"六城市成智慧城市基础设施与智能网联汽车协同发展试点","id":3815,"searchValue":null},{"updateTime":null,"remark":null,"params":{},"userName":"lizheng","userId":1113470,"content":"333","likeNum":0,"createBy":null,"newsId":8,"createTime":null,"updateBy":null,"appType":"park","commentDate":"2022-12-05 14:38:01","newsTitle":"六城市成智慧城市基础设施与智能网联汽车协同发展试点","id":4148,"searchValue":null}]
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
         * updateTime : null
         * remark : null
         * params : {}
         * userName : lizheng
         * userId : 1113470
         * content : 你在干嘛
         * likeNum : 16
         * createBy : null
         * newsId : 8
         * createTime : null
         * updateBy : null
         * appType : park
         * commentDate : 2022-11-30 12:54:21
         * newsTitle : 六城市成智慧城市基础设施与智能网联汽车协同发展试点
         * id : 3814
         * searchValue : null
         */
        private String updateTime;
        private String remark;
        private ParamsEntity params;
        private String userName;
        private int userId;
        private String content;
        private int likeNum;
        private String createBy;
        private int newsId;
        private String createTime;
        private String updateBy;
        private String appType;
        private String commentDate;
        private String newsTitle;
        private int id;
        private String searchValue;

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setLikeNum(int likeNum) {
            this.likeNum = likeNum;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public void setCommentDate(String commentDate) {
            this.commentDate = commentDate;
        }

        public void setNewsTitle(String newsTitle) {
            this.newsTitle = newsTitle;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
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

        public String getUserName() {
            return userName;
        }

        public int getUserId() {
            return userId;
        }

        public String getContent() {
            return content;
        }

        public int getLikeNum() {
            return likeNum;
        }

        public String getCreateBy() {
            return createBy;
        }

        public int getNewsId() {
            return newsId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public String getAppType() {
            return appType;
        }

        public String getCommentDate() {
            return commentDate;
        }

        public String getNewsTitle() {
            return newsTitle;
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
