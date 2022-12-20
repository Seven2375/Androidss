package com.huangxue.s01.Beans;

public class MyInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * user : {"score":1000,"balance":1000,"nickName":"牛逼哥","idCard":"210113199808242122","sex":"0","phonenumber":"100861103","avatar":"https://img1.baidu.com/it/u=3720318685,2938598939&fm=253&fmt=auto&app=138&f=JPEG?w=200&h=200","userName":"niubi","userId":1114951,"email":"niubi@qq.com"}
     */
    private String msg;
    private int code;
    private UserEntity user;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public UserEntity getUser() {
        return user;
    }

    public class UserEntity {
        /**
         * score : 1000
         * balance : 1000.0
         * nickName : 牛逼哥
         * idCard : 210113199808242122
         * sex : 0
         * phonenumber : 100861103
         * avatar : https://img1.baidu.com/it/u=3720318685,2938598939&fm=253&fmt=auto&app=138&f=JPEG?w=200&h=200
         * userName : niubi
         * userId : 1114951
         * email : niubi@qq.com
         */
        private int score;
        private double balance;
        private String nickName;
        private String idCard;
        private String sex;
        private String phonenumber;
        private String avatar;
        private String userName;
        private int userId;
        private String email;

        public void setScore(int score) {
            this.score = score;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getScore() {
            return score;
        }

        public double getBalance() {
            return balance;
        }

        public String getNickName() {
            return nickName;
        }

        public String getIdCard() {
            return idCard;
        }

        public String getSex() {
            return sex;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getUserName() {
            return userName;
        }

        public int getUserId() {
            return userId;
        }

        public String getEmail() {
            return email;
        }
    }
}
