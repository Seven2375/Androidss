package com.huangxue.s01.Beans;

import java.util.List;

public class PetClassGridBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/11e442ce-9d6b-4ae1-9a6d-01d93450d8d5.png","createBy":null,"createTime":null,"updateBy":null,"name":"小猫咪","updateTime":null,"remark":null,"id":9,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/cc103d6d-8e82-4720-9eb3-f2d1209a6640.png","createBy":null,"createTime":null,"updateBy":null,"name":"小狗","updateTime":null,"remark":null,"id":10,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/a3a628f3-baf7-472e-9834-0b038bcd7164.png","createBy":null,"createTime":null,"updateBy":null,"name":"鹦鹉","updateTime":null,"remark":null,"id":11,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/0446739d-7b1e-4b76-a024-f2dd4cedde01.png","createBy":null,"createTime":null,"updateBy":null,"name":"金鱼","updateTime":null,"remark":null,"id":12,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/11f345ba-6ca9-4d1f-a3a1-76f17bb42d3d.png","createBy":null,"createTime":null,"updateBy":null,"name":"兔子","updateTime":null,"remark":null,"id":13,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/bb14baef-0bf0-4c19-a96a-39140ae71cd7.png","createBy":null,"createTime":null,"updateBy":null,"name":"宠物猪","updateTime":null,"remark":null,"id":14,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/71b54f9f-23e4-4613-98cb-ce1dc1bfd36f.png","createBy":null,"createTime":null,"updateBy":null,"name":"仓鼠","updateTime":null,"remark":null,"id":15,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/d8d0adc8-eb1b-4ce8-a136-3c7e4fab82ef.png","createBy":null,"createTime":null,"updateBy":null,"name":"爬虫类","updateTime":null,"remark":null,"id":16,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/6809e976-f32f-4be3-9c10-db9ffc18941a.png","createBy":null,"createTime":null,"updateBy":null,"name":"小鸡","updateTime":null,"remark":null,"id":17,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/14/25876ced-9adb-4a77-a1e9-100befde3788.png","createBy":null,"createTime":null,"updateBy":null,"name":"其他","updateTime":null,"remark":null,"id":18,"params":{},"searchValue":null}]
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
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/11e442ce-9d6b-4ae1-9a6d-01d93450d8d5.png
         * createBy : null
         * createTime : null
         * updateBy : null
         * name : 小猫咪
         * updateTime : null
         * remark : null
         * id : 9
         * params : {}
         * searchValue : null
         */
        private String imgUrl;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String name;
        private String updateTime;
        private String remark;
        private int id;
        private ParamsEntity params;
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

        public void setName(String name) {
            this.name = name;
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

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public String getName() {
            return name;
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
