package com.huangxue.s01.Beans;

import java.util.List;

public class LookRoomListBean {

    /**
     * msg : 查询成功
     * total : 4
     * code : 200
     * rows : [{"address":"泉水B6区泉水小学北站附近多层一室一厅得房率高","houseType":"二手","description":"房主现在比较着急 房子如果真看好的话 价格可议 手续这边齐全 房子没有抵押 产权证在手 随时配合过户 房主现在已经搬走了 房子现在是空置状态","updateTime":null,"remark":null,"pic":"/prod-api/profile/upload/image/2021/05/17/71ac2d26-4504-412d-81f1-0749f64b42d7.png","params":{},"createBy":null,"createTime":null,"updateBy":null,"price":"16262/㎡","tel":"18546474545","id":1,"sourceName":"泉水B6区泉水小学北站附近多层一室一厅得房率高\n","searchValue":null,"areaSize":52},{"address":"数码路118号","houseType":"二手","description":"我去看过这个房子，位置好，不挡光，中间楼层，精装修赠送全部家具家电，拎包即住，看房方便，照片视频等都是实景拍摄，欢迎随时咨询。","updateTime":null,"remark":null,"pic":"/prod-api/profile/upload/image/2021/05/17/ca7d9a19-143d-4579-9cbe-574bb3be737f.jpg","params":{},"createBy":null,"createTime":null,"updateBy":null,"price":"21000/㎡","tel":"18546474549","id":3,"sourceName":"大华实验双学 区长江路 好楼层 单价超低 看房方便","searchValue":null,"areaSize":100},{"address":"西安路08年框架电梯房 70年LOFT 一室一厅封闭小区","houseType":"二手","description":null,"updateTime":null,"remark":null,"pic":null,"params":{},"createBy":null,"createTime":null,"updateBy":null,"price":"28300/㎡","tel":"18546474547","id":32,"sourceName":"西安路08年框架电梯房 70年LOFT 一室一厅封闭小区","searchValue":null,"areaSize":89},{"address":"数码路118号","houseType":"二手","description":null,"updateTime":null,"remark":null,"pic":null,"params":{},"createBy":null,"createTime":null,"updateBy":null,"price":"21000/㎡","tel":"18546474543","id":37,"sourceName":"阳光生态城一","searchValue":null,"areaSize":121}]
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
         * address : 泉水B6区泉水小学北站附近多层一室一厅得房率高
         * houseType : 二手
         * description : 房主现在比较着急 房子如果真看好的话 价格可议 手续这边齐全 房子没有抵押 产权证在手 随时配合过户 房主现在已经搬走了 房子现在是空置状态
         * updateTime : null
         * remark : null
         * pic : /prod-api/profile/upload/image/2021/05/17/71ac2d26-4504-412d-81f1-0749f64b42d7.png
         * params : {}
         * createBy : null
         * createTime : null
         * updateBy : null
         * price : 16262/㎡
         * tel : 18546474545
         * id : 1
         * sourceName : 泉水B6区泉水小学北站附近多层一室一厅得房率高
         * searchValue : null
         * areaSize : 52
         */
        private String address;
        private String houseType;
        private String description;
        private String updateTime;
        private String remark;
        private String pic;
        private ParamsEntity params;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String price;
        private String tel;
        private int id;
        private String sourceName;
        private String searchValue;
        private int areaSize;

        public void setAddress(String address) {
            this.address = address;
        }

        public void setHouseType(String houseType) {
            this.houseType = houseType;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
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

        public void setPrice(String price) {
            this.price = price;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setAreaSize(int areaSize) {
            this.areaSize = areaSize;
        }

        public String getAddress() {
            return address;
        }

        public String getHouseType() {
            return houseType;
        }

        public String getDescription() {
            return description;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public String getPic() {
            return pic;
        }

        public ParamsEntity getParams() {
            return params;
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

        public String getPrice() {
            return price;
        }

        public String getTel() {
            return tel;
        }

        public int getId() {
            return id;
        }

        public String getSourceName() {
            return sourceName;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public int getAreaSize() {
            return areaSize;
        }

        public class ParamsEntity {
        }
    }
}
