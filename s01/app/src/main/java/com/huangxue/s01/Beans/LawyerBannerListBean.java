package com.huangxue.s01.Beans;

import java.util.List;

public class LawyerBannerListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/3b076043-ec6a-455c-986d-0b39302e3e27.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":6,"sort":1,"params":{},"title":"涉嫌哄抬价格 两家线上蔬菜店被立案","searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/5aef0e8c-4cdb-4b19-bb74-66282a4f611d.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":7,"sort":2,"params":{},"title":"河南去年教育投入1927亿元","searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/03e2beb5-3b62-4457-98cf-df358ba7c7e8.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":8,"sort":3,"params":{},"title":"扣押150万只 警方破获一起生产销售假冒伪劣口罩","searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/b05bc97b-dd0a-437e-8318-a3189f73fe47.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":9,"sort":4,"params":{},"title":"警方破获一起非法捕杀野生动物案","searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/b4acad05-f26c-4d1b-a9bb-772704c7059a.jpeg","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":10,"sort":5,"params":{},"title":"广西崇左警方联合广东多地警方破获特大跨国贩","searchValue":null}]
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
         * imgUrl : /prod-api/profile/upload/image/2022/03/12/3b076043-ec6a-455c-986d-0b39302e3e27.jpeg
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * id : 6
         * sort : 1
         * params : {}
         * title : 涉嫌哄抬价格 两家线上蔬菜店被立案
         * searchValue : null
         */
        private String imgUrl;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private int id;
        private int sort;
        private ParamsEntity params;
        private String title;
        private String searchValue;

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
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

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public int getSort() {
            return sort;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getTitle() {
            return title;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity {
        }
    }
}
