package com.huangxue.s01.Beans;

import java.util.List;

public class LawyerUserEvaluateListBean {

    /**
     * msg : 查询成功
     * total : 4
     * code : 200
     * rows : [{"fromUserName":"user01","myLikeState":false,"adviceId":26,"score":3,"createTime":"2022-03-13T07:40:43.000+0800","evaluateContent":"律师已经帮忙解答了，还是不太明白。不过结单了，因为已报警。","likeCount":2,"fromUserAvatar":""},{"fromUserName":"czzz","myLikeState":false,"adviceId":211,"score":0,"createTime":"2022-11-17T17:49:50.000+0800","evaluateContent":null,"likeCount":0,"fromUserAvatar":"/profile/upload/2022/12/15/b55158c5-d118-4c59-b6c1-d4f4298b2cdf.gif"},{"fromUserName":"czzz","myLikeState":false,"adviceId":212,"score":0,"createTime":"2022-11-17T17:49:50.000+0800","evaluateContent":null,"likeCount":0,"fromUserAvatar":"/profile/upload/2022/12/15/b55158c5-d118-4c59-b6c1-d4f4298b2cdf.gif"},{"fromUserName":"暴躁小王","myLikeState":false,"adviceId":419,"score":0,"createTime":"2022-11-26T19:27:08.000+0800","evaluateContent":null,"likeCount":0,"fromUserAvatar":"/prod-api/profile/upload/2022/12/10/1fc67e8e-3e5d-4fb0-b913-2ee6388a0a9f.jpg"}]
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
         * fromUserName : user01
         * myLikeState : false
         * adviceId : 26
         * score : 3
         * createTime : 2022-03-13T07:40:43.000+0800
         * evaluateContent : 律师已经帮忙解答了，还是不太明白。不过结单了，因为已报警。
         * likeCount : 2
         * fromUserAvatar :
         */
        private String fromUserName;
        private boolean myLikeState;
        private int adviceId;
        private int score;
        private String createTime;
        private String evaluateContent;
        private int likeCount;
        private String fromUserAvatar;

        public void setFromUserName(String fromUserName) {
            this.fromUserName = fromUserName;
        }

        public void setMyLikeState(boolean myLikeState) {
            this.myLikeState = myLikeState;
        }

        public void setAdviceId(int adviceId) {
            this.adviceId = adviceId;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setEvaluateContent(String evaluateContent) {
            this.evaluateContent = evaluateContent;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public void setFromUserAvatar(String fromUserAvatar) {
            this.fromUserAvatar = fromUserAvatar;
        }

        public String getFromUserName() {
            return fromUserName;
        }

        public boolean isMyLikeState() {
            return myLikeState;
        }

        public int getAdviceId() {
            return adviceId;
        }

        public int getScore() {
            return score;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getEvaluateContent() {
            return evaluateContent;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public String getFromUserAvatar() {
            return fromUserAvatar;
        }
    }
}
