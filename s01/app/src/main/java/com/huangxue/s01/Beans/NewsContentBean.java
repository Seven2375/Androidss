package com.huangxue.s01.Beans;

public class NewsContentBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"publishDate":"2021-05-08","updateTime":"2022-12-05 17:08:00","remark":null,"params":{},"title":"iPhone 13再爆猛料：不止刘海屏有望缩小，超大杯或将搭载LTPO屏","type":"22","hot":"N","content":"<p>\t按照去年iPhone 12系列的发布时间节点来看，如今距离苹果新一代iPhone发布的时间还有很长一段时间，但这并未能够阻挡消费者对于iPhone 13系列的关注热情。每当网上一有关于新机的爆料信息，总能引起了不少网友的围观与讨论<\/p><p><br><\/p><p>\t就在近日，国外一数码博主便通过一则视频，向广大网友展示疑似iPhone 13 Pro Max的机模。根据该视频显示，全新的iPhone 13 Pro Max在外观上并没有做出太大的改变，依旧保持了刘海屏设计，同时后置依旧采用了三摄模组。区别的是，相较于上一代iPhone 13 Pro Max似乎机身厚度变大了些许，且摄像头模组的凸起程度也更高，而且正面的刘海屏也能感觉到明显变窄了不少。<\/p><p><br><\/p><p><img src=\"/prod-api/profile/upload/image/2021/05/17/863b3306-9fad-4255-a065-0f59b57c7cc4.jpg\"><\/p><p>\t<\/p><p>      至于配置方面，iPhone 13 Pro Max有望搭载LTPO显示屏，借助于这一屏幕材质的特殊性，能够有效降低屏幕的功耗，iPhone 13 Pro Max大概率将会支持120Hz屏幕刷新率，从而拉开苹果手机的高刷屏序幕。此外，存储空间也或将升级至1TB内存。如果真的如此的话，那么对于广大果粉朋友来说，绝对算得上是近几年苹果带给用户最大的福音。<\/p><p><img src=\"/prod-api/profile/upload/image/2021/05/17/ec953328-80e2-457a-a18b-d61009a8e498.jpg\"><\/p>","tags":null,"likeNum":427,"cover":"/prod-api/profile/upload/image/2021/05/08/c044462a-2ce3-4f28-b2a3-908164b82498.jpg","commentNum":525,"createBy":"1","subTitle":null,"top":"N","createTime":"2021-05-08 09:57:54","updateBy":"1","readNum":2134,"appType":"smart_city","id":28,"searchValue":null,"status":"Y"}
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
         * publishDate : 2021-05-08
         * updateTime : 2022-12-05 17:08:00
         * remark : null
         * params : {}
         * title : iPhone 13再爆猛料：不止刘海屏有望缩小，超大杯或将搭载LTPO屏
         * type : 22
         * hot : N
         * content : <p>	按照去年iPhone 12系列的发布时间节点来看，如今距离苹果新一代iPhone发布的时间还有很长一段时间，但这并未能够阻挡消费者对于iPhone 13系列的关注热情。每当网上一有关于新机的爆料信息，总能引起了不少网友的围观与讨论</p><p><br></p><p>	就在近日，国外一数码博主便通过一则视频，向广大网友展示疑似iPhone 13 Pro Max的机模。根据该视频显示，全新的iPhone 13 Pro Max在外观上并没有做出太大的改变，依旧保持了刘海屏设计，同时后置依旧采用了三摄模组。区别的是，相较于上一代iPhone 13 Pro Max似乎机身厚度变大了些许，且摄像头模组的凸起程度也更高，而且正面的刘海屏也能感觉到明显变窄了不少。</p><p><br></p><p><img src="/prod-api/profile/upload/image/2021/05/17/863b3306-9fad-4255-a065-0f59b57c7cc4.jpg"></p><p>	</p><p>      至于配置方面，iPhone 13 Pro Max有望搭载LTPO显示屏，借助于这一屏幕材质的特殊性，能够有效降低屏幕的功耗，iPhone 13 Pro Max大概率将会支持120Hz屏幕刷新率，从而拉开苹果手机的高刷屏序幕。此外，存储空间也或将升级至1TB内存。如果真的如此的话，那么对于广大果粉朋友来说，绝对算得上是近几年苹果带给用户最大的福音。</p><p><img src="/prod-api/profile/upload/image/2021/05/17/ec953328-80e2-457a-a18b-d61009a8e498.jpg"></p>
         * tags : null
         * likeNum : 427
         * cover : /prod-api/profile/upload/image/2021/05/08/c044462a-2ce3-4f28-b2a3-908164b82498.jpg
         * commentNum : 525
         * createBy : 1
         * subTitle : null
         * top : N
         * createTime : 2021-05-08 09:57:54
         * updateBy : 1
         * readNum : 2134
         * appType : smart_city
         * id : 28
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
