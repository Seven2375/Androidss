package com.huangxue.s01.Beans;

import java.util.List;

public class NewsListBean {

    /**
     * msg : 查询成功
     * total : 51
     * code : 200
     * rows : [{"publishDate":"2021-05-06","updateTime":"2022-12-01 16:34:52","remark":null,"params":{},"title":"一组数字告诉你 这个\u201c五一\u201d小长假有多火！","type":"21","hot":"Y","content":"<p>今年的\u201c五一\u201d小长假似乎格外火爆<\/p><p>\u201c补偿式出游\u201d热度爆棚<\/p><p>各大景区游人如织<\/p><p>消费市场热闹非凡<\/p><p>旅游新趋势不断显现<\/p><p>一组数字告诉你<\/p><p>这个小长假有多火<\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/5d76d464-0932-40a4-a91a-839bafa7792e.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/06bcd8ac-3567-46e7-925e-94a57819148f.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/319ebde6-f9ce-4ad0-a7c1-2e1c18bcd719.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/29683435-bcba-4564-971a-01134251ccf2.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/4a185845-63ac-4e9a-9858-30a7ed88b437.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/1d8538e8-f175-44a7-83b7-181ae68c7df6.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/6628b0b5-f1ad-49f0-acd7-ab61fe62b563.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/e4f05a81-385e-44eb-ae6f-0e112d93a984.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/3bb9290e-b278-4258-a4fb-50194ef08e64.png\"><\/p><p class=\"ql-align-center\"><img src=\"/prod-api/profile/upload/image/2021/05/17/43a51afd-c222-4024-8288-ddf3dfb4352a.png\"><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p><p class=\"ql-align-center\"><br><\/p>","tags":null,"likeNum":329,"cover":"/prod-api/profile/upload/image/2021/05/06/794615b6-a9ea-44d5-9780-b999daff4185.png","commentNum":34,"createBy":"1","subTitle":null,"top":"N","createTime":"2021-05-06 16:54:12","updateBy":"1","readNum":2468,"appType":"smart_city","id":21,"searchValue":null,"status":"Y"}]
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
         * publishDate : 2021-05-06
         * updateTime : 2022-12-01 16:34:52
         * remark : null
         * params : {}
         * title : 一组数字告诉你 这个“五一”小长假有多火！
         * type : 21
         * hot : Y
         * content : <p>今年的“五一”小长假似乎格外火爆</p><p>“补偿式出游”热度爆棚</p><p>各大景区游人如织</p><p>消费市场热闹非凡</p><p>旅游新趋势不断显现</p><p>一组数字告诉你</p><p>这个小长假有多火</p><p class="ql-align-center"><br></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/5d76d464-0932-40a4-a91a-839bafa7792e.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/06bcd8ac-3567-46e7-925e-94a57819148f.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/319ebde6-f9ce-4ad0-a7c1-2e1c18bcd719.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/29683435-bcba-4564-971a-01134251ccf2.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/4a185845-63ac-4e9a-9858-30a7ed88b437.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/1d8538e8-f175-44a7-83b7-181ae68c7df6.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/6628b0b5-f1ad-49f0-acd7-ab61fe62b563.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/e4f05a81-385e-44eb-ae6f-0e112d93a984.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/3bb9290e-b278-4258-a4fb-50194ef08e64.png"></p><p class="ql-align-center"><img src="/prod-api/profile/upload/image/2021/05/17/43a51afd-c222-4024-8288-ddf3dfb4352a.png"></p><p class="ql-align-center"><br></p><p class="ql-align-center"><br></p><p class="ql-align-center"><br></p><p class="ql-align-center"><br></p><p class="ql-align-center"><br></p><p class="ql-align-center"><br></p>
         * tags : null
         * likeNum : 329
         * cover : /prod-api/profile/upload/image/2021/05/06/794615b6-a9ea-44d5-9780-b999daff4185.png
         * commentNum : 34
         * createBy : 1
         * subTitle : null
         * top : N
         * createTime : 2021-05-06 16:54:12
         * updateBy : 1
         * readNum : 2468
         * appType : smart_city
         * id : 21
         * searchValue : null
         * status : Y
         */
        private String publishDate;
        private String updateTime;
        private String remark;
        private ParamsEntity params;
        private String title;
        private String type;
        private String hot;
        private String content;
        private String tags;
        private int likeNum;
        private String cover;
        private int commentNum;
        private String createBy;
        private String subTitle;
        private String top;
        private String createTime;
        private String updateBy;
        private int readNum;
        private String appType;
        private int id;
        private String searchValue;
        private String status;

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
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

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public void setLikeNum(int likeNum) {
            this.likeNum = likeNum;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setReadNum(int readNum) {
            this.readNum = readNum;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPublishDate() {
            return publishDate;
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

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }

        public String getHot() {
            return hot;
        }

        public String getContent() {
            return content;
        }

        public String getTags() {
            return tags;
        }

        public int getLikeNum() {
            return likeNum;
        }

        public String getCover() {
            return cover;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public String getCreateBy() {
            return createBy;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public String getTop() {
            return top;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public int getReadNum() {
            return readNum;
        }

        public String getAppType() {
            return appType;
        }

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public String getStatus() {
            return status;
        }

        public class ParamsEntity {
        }
    }
}
