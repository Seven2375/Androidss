package com.huangxue.s01.Beans;

import java.util.List;

public class TakeawayClassListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/f8c06dfc-9da2-41cc-9784-8cf234c999f2.png","createBy":null,"themeName":"美食","createTime":"2021-04-13 16:52:46","updateBy":null,"updateTime":"2021-05-08 11:56:50","remark":null,"id":1,"themeDesc":"美食来找我","sort":1,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/12d84c9a-fca8-488b-9d92-383cbe448555.png","createBy":null,"themeName":"甜点饮品","createTime":"2021-04-13 16:53:13","updateBy":null,"updateTime":"2021-05-08 11:57:00","remark":null,"id":2,"themeDesc":null,"sort":2,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/61478234-24b7-4f7e-8ce8-05a74ae2e56b.png","createBy":null,"themeName":"汉堡披萨","createTime":"2021-04-13 16:53:59","updateBy":null,"updateTime":"2021-05-08 11:57:08","remark":null,"id":3,"themeDesc":null,"sort":3,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/0348a4c8-2353-40bb-a17a-31672ecd1dad.png","createBy":null,"themeName":"炸鸡炸串","createTime":"2021-04-13 16:56:43","updateBy":null,"updateTime":"2021-05-08 11:57:23","remark":null,"id":4,"themeDesc":null,"sort":4,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2021/05/08/0b4b5757-ac06-4ac5-91eb-dc49e4846959.png","createBy":null,"themeName":"美味面馆","createTime":"2021-04-13 16:58:34","updateBy":null,"updateTime":"2021-05-08 11:57:33","remark":null,"id":5,"themeDesc":null,"sort":5,"params":{},"searchValue":null}]
     */
    private String msg;
    private int code;
    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * imgUrl : /prod-api/profile/upload/image/2021/05/08/f8c06dfc-9da2-41cc-9784-8cf234c999f2.png
         * createBy : null
         * themeName : 美食
         * createTime : 2021-04-13 16:52:46
         * updateBy : null
         * updateTime : 2021-05-08 11:56:50
         * remark : null
         * id : 1
         * themeDesc : 美食来找我
         * sort : 1
         * params : {}
         * searchValue : null
         */
        private String imgUrl;
        private String createBy;
        private String themeName;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private int id;
        private String themeDesc;
        private int sort;
        private ParamsEntity params;
        private String searchValue;

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setThemeName(String themeName) {
            this.themeName = themeName;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setThemeDesc(String themeDesc) {
            this.themeDesc = themeDesc;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public String getCreateBy() {
            return createBy;
        }

        public String getThemeName() {
            return themeName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public int getId() {
            return id;
        }

        public String getThemeDesc() {
            return themeDesc;
        }

        public int getSort() {
            return sort;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity {
        }
    }
}
