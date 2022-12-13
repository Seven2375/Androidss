package com.huangxue.s01.Beans;

import java.util.List;

public class StopRecordBean {

    /**
     * msg : 查询成功
     * total : 127
     * code : 200
     * rows : [{"parkNo":"1","monetary":"20","address":"沈阳三源色试驾基地","parkName":"沈阳三源色试驾基地停车场","updateTime":null,"remark":null,"lotId":22,"params":{},"plateNumber":"辽B43215","createBy":null,"entryTime":"2021-08-20 00:00:00","createTime":null,"updateBy":null,"id":4482,"searchValue":null,"outTime":"2021-08-20 00:00:00"},{"parkNo":"1","monetary":"20","address":"沈阳三源色试驾基地","parkName":"沈阳三源色试驾基地停车场","updateTime":null,"remark":null,"lotId":22,"params":{},"plateNumber":"辽B51135","createBy":null,"entryTime":"2021-05-10 00:00:00","createTime":null,"updateBy":null,"id":4483,"searchValue":null,"outTime":"2021-05-10 00:00:00"}]
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
         * parkNo : 1
         * monetary : 20
         * address : 沈阳三源色试驾基地
         * parkName : 沈阳三源色试驾基地停车场
         * updateTime : null
         * remark : null
         * lotId : 22
         * params : {}
         * plateNumber : 辽B43215
         * createBy : null
         * entryTime : 2021-08-20 00:00:00
         * createTime : null
         * updateBy : null
         * id : 4482
         * searchValue : null
         * outTime : 2021-08-20 00:00:00
         */
        private String parkNo;
        private String monetary;
        private String address;
        private String parkName;
        private String updateTime;
        private String remark;
        private int lotId;
        private ParamsEntity params;
        private String plateNumber;
        private String createBy;
        private String entryTime;
        private String createTime;
        private String updateBy;
        private int id;
        private String searchValue;
        private String outTime;

        public void setParkNo(String parkNo) {
            this.parkNo = parkNo;
        }

        public void setMonetary(String monetary) {
            this.monetary = monetary;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setParkName(String parkName) {
            this.parkName = parkName;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setLotId(int lotId) {
            this.lotId = lotId;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public void setEntryTime(String entryTime) {
            this.entryTime = entryTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public void setOutTime(String outTime) {
            this.outTime = outTime;
        }

        public String getParkNo() {
            return parkNo;
        }

        public String getMonetary() {
            return monetary;
        }

        public String getAddress() {
            return address;
        }

        public String getParkName() {
            return parkName;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public int getLotId() {
            return lotId;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getPlateNumber() {
            return plateNumber;
        }

        public String getCreateBy() {
            return createBy;
        }

        public String getEntryTime() {
            return entryTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public String getOutTime() {
            return outTime;
        }

        public class ParamsEntity {
        }
    }
}
