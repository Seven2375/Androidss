package com.huangxue.s01.Beans;

import java.util.List;

public class LawyerExpertiseListBean {

    /**
     * msg : 查询成功
     * total : 16
     * code : 200
     * rows : [{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/c97db288-c13d-4d62-9027-418b402bbc01.png","createBy":null,"createTime":null,"updateBy":null,"name":"拆迁安置","updateTime":null,"remark":null,"id":10,"sort":1,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/e5499ece-ea2b-4f31-b97c-3309fd2eb5ec.png","createBy":null,"createTime":null,"updateBy":null,"name":"债务追讨","updateTime":null,"remark":null,"id":11,"sort":2,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/3308177d-cba4-4f7c-addf-9abb59f9d688.png","createBy":null,"createTime":null,"updateBy":null,"name":"医疗纠纷","updateTime":null,"remark":null,"id":12,"sort":3,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/8e4816c6-f859-40bc-b827-290b0efbeeb6.png","createBy":null,"createTime":null,"updateBy":null,"name":"交通事故","updateTime":null,"remark":null,"id":13,"sort":4,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/e0fc5eb0-ec50-4f08-b268-5e4cf9ea6e28.png","createBy":null,"createTime":null,"updateBy":null,"name":"合同纠纷","updateTime":null,"remark":null,"id":14,"sort":5,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/792b1950-bf09-42ae-b14a-b8ab76d1878a.png","createBy":null,"createTime":null,"updateBy":null,"name":"劳动纠纷","updateTime":null,"remark":null,"id":15,"sort":6,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/87bc2209-13f7-4944-b6ba-3c28ea2051dc.png","createBy":null,"createTime":null,"updateBy":null,"name":"工伤赔偿","updateTime":null,"remark":null,"id":16,"sort":7,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/f1867ba3-44f4-4f02-9c2d-4fcfaace58bd.png","createBy":null,"createTime":null,"updateBy":null,"name":"人身损害","updateTime":null,"remark":null,"id":17,"sort":8,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/5f591c5c-729f-472b-942b-80b4cd45e1fb.png","createBy":null,"createTime":null,"updateBy":null,"name":"保险理赔","updateTime":null,"remark":null,"id":18,"sort":9,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/a18bae36-d315-4c67-8e11-785f0fb9d441.png","createBy":null,"createTime":null,"updateBy":null,"name":"新闻侵权","updateTime":null,"remark":null,"id":19,"sort":10,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/6bc12058-681d-49da-a06a-aa756293652c.png","createBy":null,"createTime":null,"updateBy":null,"name":"婚姻家庭","updateTime":null,"remark":null,"id":20,"sort":11,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/343e065d-2406-463a-829c-dc652e926d42.png","createBy":null,"createTime":null,"updateBy":null,"name":"遗产继承","updateTime":null,"remark":null,"id":21,"sort":12,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/f9a599aa-cf67-450d-8764-ccfecad0fbf9.png","createBy":null,"createTime":null,"updateBy":null,"name":"旅游纠纷","updateTime":null,"remark":null,"id":22,"sort":13,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/69533fe3-0e71-4d2e-9cdd-4ccbc6fe8086.png","createBy":null,"createTime":null,"updateBy":null,"name":"农村承包","updateTime":null,"remark":null,"id":23,"sort":14,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/dbac7f17-a3d2-4fad-9146-b6982a291a78.png","createBy":null,"createTime":null,"updateBy":null,"name":"消费权益","updateTime":null,"remark":null,"id":24,"sort":15,"params":{},"searchValue":null},{"imgUrl":"/prod-api/profile/upload/image/2022/03/12/c75014a1-6f78-4e1a-8d8f-33518bd80de8.png","createBy":null,"createTime":null,"updateBy":null,"name":"抵押担保","updateTime":null,"remark":null,"id":25,"sort":16,"params":{},"searchValue":null}]
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

    public static class RowsEntity {
        /**
         * imgUrl : /prod-api/profile/upload/image/2022/03/12/c97db288-c13d-4d62-9027-418b402bbc01.png
         * createBy : null
         * createTime : null
         * updateBy : null
         * name : 拆迁安置
         * updateTime : null
         * remark : null
         * id : 10
         * sort : 1
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
        private int sort;
        private ParamsEntity params;
        private String searchValue;

        public RowsEntity(String name) {
            this.name = name;

            this.imgUrl = null;
            this.createBy = null;
            this.createTime = null;
            this.updateBy = null;
            this.updateTime = null;
            this.remark = null;
            this.id = 100;
            this.sort = 100;
            this.params = null;
            this.searchValue = null;
        }

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

        public void setSort(int sort) {
            this.sort = sort;
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

        public int getSort() {
            return sort;
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
