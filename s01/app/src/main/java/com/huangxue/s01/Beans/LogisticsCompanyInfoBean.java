package com.huangxue.s01.Beans;

import java.util.List;

public class LogisticsCompanyInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"introduce":"快捷速递有限公司(FAST EXPRESS LIMITED)，简称\u201c快捷速递\u201d (FAST EXPRESS)，是专业的中港速递网络的建设者，早期致力于香港与广东地区间的快递往来业务，通过多年的努力和积累，已成功地将\u201c快捷速递\u201d建设成一个优秀的民族速递品牌。\u201c快捷\u201d的英文是\u201cFAST\u201d，以此为品牌，提供的是专业的、具有中国特色的速递产品；是为广大终端客户服务的、为直接用户担当货物安全快速送达的使者。长期以来，为客户提供全面的、无盲区的国内速递服务。","shippingMethod":"海运，空运，陆运","updateTime":null,"remark":null,"sort":15,"params":{},"priceList":[],"imgUrl":"/prod-api/profile/upload/image/2022/03/14/6609a40d-f095-4fff-999c-cb4cad620e44.jpeg","newsList":[],"createBy":null,"createTime":null,"updateBy":null,"phone":"17582838853","name":"快捷快递","id":23,"searchValue":null}
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
         * introduce : 快捷速递有限公司(FAST EXPRESS LIMITED)，简称“快捷速递” (FAST EXPRESS)，是专业的中港速递网络的建设者，早期致力于香港与广东地区间的快递往来业务，通过多年的努力和积累，已成功地将“快捷速递”建设成一个优秀的民族速递品牌。“快捷”的英文是“FAST”，以此为品牌，提供的是专业的、具有中国特色的速递产品；是为广大终端客户服务的、为直接用户担当货物安全快速送达的使者。长期以来，为客户提供全面的、无盲区的国内速递服务。
         * shippingMethod : 海运，空运，陆运
         * updateTime : null
         * remark : null
         * sort : 15
         * params : {}
         * priceList : []
         * imgUrl : /prod-api/profile/upload/image/2022/03/14/6609a40d-f095-4fff-999c-cb4cad620e44.jpeg
         * newsList : []
         * createBy : null
         * createTime : null
         * updateBy : null
         * phone : 17582838853
         * name : 快捷快递
         * id : 23
         * searchValue : null
         */
        private String introduce;
        private String shippingMethod;
        private String updateTime;
        private String remark;
        private int sort;
        private ParamsEntity params;
        private List<?> priceList;
        private String imgUrl;
        private List<?> newsList;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String phone;
        private String name;
        private int id;
        private String searchValue;

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public void setShippingMethod(String shippingMethod) {
            this.shippingMethod = shippingMethod;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setPriceList(List<?> priceList) {
            this.priceList = priceList;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setNewsList(List<?> newsList) {
            this.newsList = newsList;
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

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getIntroduce() {
            return introduce;
        }

        public String getShippingMethod() {
            return shippingMethod;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public int getSort() {
            return sort;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public List<?> getPriceList() {
            return priceList;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public List<?> getNewsList() {
            return newsList;
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

        public String getPhone() {
            return phone;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity {
        }
    }
}
