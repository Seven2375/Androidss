package com.huangxue.s01.Beans;

import java.util.List;

public class DeliverListBean {

    /**
     * msg : 查询成功
     * code : 200
     * rows : [{"companyId":3,"money":"4000","companyName":"虎鱼科技","id":6,"postId":1,"userName":"admin","userId":1,"satrTime":"2021-09-10"}]
     */
    private String msg;
    private int code;
    private List<RowsEntity> rows;

    public void setMsg(String msg) {
        this.msg = msg;
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

    public int getCode() {
        return code;
    }

    public List<RowsEntity> getRows() {
        return rows;
    }

    public class RowsEntity {
        /**
         * companyId : 3
         * money : 4000
         * companyName : 虎鱼科技
         * id : 6
         * postId : 1
         * userName : admin
         * userId : 1
         *
         * satrTime : 2021-09-10
         */
        private int companyId;
        private String money;
        private String companyName;
        private int id;
        private int postId;
        private String userName;
        private int userId;
        private String postName;
        private String satrTime;

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setPostId(int postId) {
            this.postId = postId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setSatrTime(String satrTime) {
            this.satrTime = satrTime;
        }

        public int getCompanyId() {
            return companyId;
        }

        public String getMoney() {
            return money;
        }

        public String getCompanyName() {
            return companyName;
        }

        public int getId() {
            return id;
        }

        public int getPostId() {
            return postId;
        }

        public String getUserName() {
            return userName;
        }

        public int getUserId() {
            return userId;
        }

        public String getSatrTime() {
            return satrTime;
        }
    }
}
