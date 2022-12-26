package com.huangxue.s01.Beans;

import java.util.List;

public class TakeoutMenuInfoListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"saleQuantity":12,"updateTime":null,"remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/b2ef7ccd-17c5-4688-b019-6efea94d7434.jpg","createBy":null,"favorRate":98,"sellerId":1,"createTime":"2021-05-08 20:33:48","updateBy":null,"price":42,"name":"10英寸比萨随心拼","id":28,"detail":"10寸比萨随心拼","searchValue":null,"categoryId":3,"status":"1"},{"saleQuantity":73,"updateTime":null,"remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/37f5f5d1-17ae-44e4-bb72-4e0eec51c158.jpg","createBy":null,"favorRate":97,"sellerId":1,"createTime":"2021-05-08 20:34:41","updateBy":null,"price":29.9,"name":"10英寸新奥尔良烤鸡肉比萨","id":29,"detail":"10英寸新奥尔良烤鸡肉比萨","searchValue":null,"categoryId":3,"status":"1"},{"saleQuantity":8,"updateTime":null,"remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/9aace014-d039-45a6-bf58-c5b27861b277.jpg","createBy":null,"favorRate":98,"sellerId":1,"createTime":"2021-05-08 20:35:30","updateBy":null,"price":40,"name":"10寸人气爆款比萨","id":30,"detail":"新奥尔良烤肉比萨+酸奶水果捞比萨","searchValue":null,"categoryId":3,"status":"1"},{"saleQuantity":98,"updateTime":null,"remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/98deb1bd-5bab-4487-ac4b-278e24118041.jpg","createBy":null,"favorRate":98,"sellerId":1,"createTime":"2021-05-08 20:36:24","updateBy":null,"price":19.9,"name":"8寸奥尔良比萨","id":31,"detail":"8寸奥尔良比萨","searchValue":null,"categoryId":3,"status":"1"},{"saleQuantity":4,"updateTime":null,"remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/e31dd821-d886-4576-90ed-c0bc35fb58a4.jpg","createBy":null,"favorRate":98,"sellerId":1,"createTime":"2021-05-08 20:39:05","updateBy":null,"price":36,"name":"10寸人气爆款比萨","id":33,"detail":"超级豪华比萨/夏威夷比萨","searchValue":null,"categoryId":3,"status":"1"}]
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
         * saleQuantity : 12
         * updateTime : null
         * remark : null
         * params : {}
         * imgUrl : /prod-api/profile/upload/image/2021/05/08/b2ef7ccd-17c5-4688-b019-6efea94d7434.jpg
         * createBy : null
         * favorRate : 98.0
         * sellerId : 1
         * createTime : 2021-05-08 20:33:48
         * updateBy : null
         * price : 42.0
         * name : 10英寸比萨随心拼
         * id : 28
         * detail : 10寸比萨随心拼
         * searchValue : null
         * categoryId : 3
         * status : 1
         */
        private int saleQuantity;
        private String updateTime;
        private String remark;
        private ParamsEntity params;
        private String imgUrl;
        private String createBy;
        private double favorRate;
        private int sellerId;
        private String createTime;
        private String updateBy;
        private double price;
        private String name;
        private int id;
        private String detail;
        private String searchValue;
        private int categoryId;
        private String status;

        public void setSaleQuantity(int saleQuantity) {
            this.saleQuantity = saleQuantity;
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

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setFavorRate(double favorRate) {
            this.favorRate = favorRate;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getSaleQuantity() {
            return saleQuantity;
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

        public String getImgUrl() {
            return imgUrl;
        }

        public String getCreateBy() {
            return createBy;
        }

        public double getFavorRate() {
            return favorRate;
        }

        public int getSellerId() {
            return sellerId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getDetail() {
            return detail;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public String getStatus() {
            return status;
        }

        public class ParamsEntity {
        }
    }
}
