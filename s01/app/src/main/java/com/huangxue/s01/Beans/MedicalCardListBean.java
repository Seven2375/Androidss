package com.huangxue.s01.Beans;

import java.util.List;

public class MedicalCardListBean {

    /**
     * msg : 查询成功
     * total : 3
     * code : 200
     * rows : [{"birthday":"1999-09-09","imgUrl":"/updata/1.jpg","address":"大连市高新区","cardId":"210211199909090014","sex":"0","name":"王大卫","tel":"13800000000","id":1,"userId":2}]
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
         * birthday : 1999-09-09
         * imgUrl : /updata/1.jpg
         * address : 大连市高新区
         * cardId : 210211199909090014
         * sex : 0
         * name : 王大卫
         * tel : 13800000000
         * id : 1
         * userId : 2
         */
        private String birthday;
        private String imgUrl;
        private String address;
        private String cardId;
        private String sex;
        private String name;
        private String tel;
        private int id;
        private int userId;

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public String getAddress() {
            return address;
        }

        public String getCardId() {
            return cardId;
        }

        public String getSex() {
            return sex;
        }

        public String getName() {
            return name;
        }

        public String getTel() {
            return tel;
        }

        public int getId() {
            return id;
        }

        public int getUserId() {
            return userId;
        }
    }
}
