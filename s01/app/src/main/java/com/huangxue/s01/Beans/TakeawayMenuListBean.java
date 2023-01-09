package com.huangxue.s01.Beans;

import java.util.List;

public class TakeawayMenuListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"saleQuantity":2,"updateTime":"2021-05-09 14:24:58","remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/0fcb6979-b420-458a-985b-cde087151c2c.jpg","createBy":null,"favorRate":97,"sellerId":1,"createTime":"2021-05-08 20:39:51","updateBy":null,"price":22,"name":"咖喱鸡肉饭","id":34,"detail":"五常长粒大米","searchValue":null,"categoryId":20,"status":"1"},{"saleQuantity":1,"updateTime":"2021-05-09 14:24:49","remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/51f95991-b240-4e0b-b43e-ad08d9946d0d.jpg","createBy":null,"favorRate":99,"sellerId":1,"createTime":"2021-05-08 20:40:48","updateBy":null,"price":25.8,"name":"芝士焗饭单人餐","id":35,"detail":"芝士鸡皇焗饭/尼斯海鲜焗饭/咖喱牛肉焗饭+可乐","searchValue":null,"categoryId":20,"status":"1"},{"saleQuantity":2,"updateTime":"2021-05-09 14:24:54","remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/08/d60d6060-78a8-48c6-ab1a-c0f8ef6dda75.jpg","createBy":null,"favorRate":99,"sellerId":1,"createTime":"2021-05-08 20:40:48","updateBy":null,"price":29.9,"name":"牛气冲天焗饭单人餐","id":36,"detail":"咖喱牛肉焗饭+可乐+串烧鸡脆骨","searchValue":null,"categoryId":20,"status":"1"},{"saleQuantity":2,"updateTime":null,"remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/09/e3e6474c-6292-475f-80da-b28a9a718845.jpg","createBy":null,"favorRate":98,"sellerId":1,"createTime":"2021-05-09 15:46:27","updateBy":null,"price":22,"name":"咖喱牛肉焗饭","id":246,"detail":"芝士牛肉","searchValue":null,"categoryId":20,"status":"1"},{"saleQuantity":3,"updateTime":null,"remark":null,"params":{},"imgUrl":"/prod-api/profile/upload/image/2021/05/09/6682cbf0-98da-4d00-8b1f-95e01536ea64.jpg","createBy":null,"favorRate":98,"sellerId":1,"createTime":"2021-05-09 15:47:35","updateBy":null,"price":21,"name":"茄汁肉丸意大利面","id":247,"detail":null,"searchValue":null,"categoryId":20,"status":"1"}]
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
         * saleQuantity : 2
         * updateTime : 2021-05-09 14:24:58
         * remark : null
         * params : {}
         * imgUrl : /prod-api/profile/upload/image/2021/05/08/0fcb6979-b420-458a-985b-cde087151c2c.jpg
         * createBy : null
         * favorRate : 97.0
         * sellerId : 1
         * createTime : 2021-05-08 20:39:51
         * updateBy : null
         * price : 22.0
         * name : 咖喱鸡肉饭
         * id : 34
         * detail : 五常长粒大米
         * searchValue : null
         * categoryId : 20
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
        private int quantity;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

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
