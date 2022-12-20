package com.huangxue.s01.Beans;

public class LookRoomInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"address":"西安路08年框架电梯房 70年LOFT 一室一厅封闭小区","houseType":"租房","description":"第五郡经典一室小房好楼层自住保持非常好小区一共36栋楼,8栋小高,28栋洋,小区绿树","updateTime":null,"remark":null,"pic":"/prod-api/profile/upload/image/2021/05/17/dc8951f9-8eff-40df-8713-166b8ccf7a66.jpg","params":{},"createBy":null,"createTime":null,"updateBy":null,"price":"28300/㎡","tel":"18546474547","id":2,"sourceName":"西安路08年框架电梯房 70年LOFT 一室一厅封闭小区","searchValue":null,"areaSize":88}
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
         * address : 西安路08年框架电梯房 70年LOFT 一室一厅封闭小区
         * houseType : 租房
         * description : 第五郡经典一室小房好楼层自住保持非常好小区一共36栋楼,8栋小高,28栋洋,小区绿树
         * updateTime : null
         * remark : null
         * pic : /prod-api/profile/upload/image/2021/05/17/dc8951f9-8eff-40df-8713-166b8ccf7a66.jpg
         * params : {}
         * createBy : null
         * createTime : null
         * updateBy : null
         * price : 28300/㎡
         * tel : 18546474547
         * id : 2
         * sourceName : 西安路08年框架电梯房 70年LOFT 一室一厅封闭小区
         * searchValue : null
         * areaSize : 88
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
