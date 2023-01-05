package com.huangxue.s01.Beans;

import java.io.Serializable;
import java.util.List;

public class ServicesListBean implements Serializable {

    /**
     * msg : 查询成功
     * total : 16
     * code : 200
     * rows : [{"serviceType":"车主服务","serviceDesc":"查询停车场","isRecommend":"N","link":"park/index","updateTime":"2021-05-10 09:20:12","remark":null,"pid":1,"sort":0,"params":{},"serviceName":"停哪儿","imgUrl":"/prod-api/profile/upload/image/2021/05/10/814fc6c4-de48-48a1-95f8-de3e749e348d.png","createBy":null,"createTime":"2020-10-23 16:17:56","updateBy":null,"id":17,"searchValue":null},{"serviceType":"生活服务","serviceDesc":"城市地铁路线","isRecommend":"N","link":"metro_query/index","updateTime":"2021-05-10 09:20:22","remark":null,"pid":1,"sort":1,"params":{},"serviceName":"城市地铁","imgUrl":"/prod-api/profile/upload/image/2021/05/10/3bfb33ee-459f-4878-b89b-4b125aa84013.png","createBy":null,"createTime":"2020-10-12 18:17:23","updateBy":null,"id":2,"searchValue":null},{"serviceType":"便民服务","serviceDesc":"智慧巴士站点","isRecommend":"N","link":"bus_query/custom_shuttle","updateTime":"2021-05-10 09:20:33","remark":null,"pid":1,"sort":2,"params":{},"serviceName":"智慧巴士","imgUrl":"/prod-api/profile/upload/image/2021/05/10/aa69f9d0-9718-42f9-9f79-c07b82a48c41.png","createBy":null,"createTime":"2020-10-12 18:17:33","updateBy":null,"id":3,"searchValue":null},{"serviceType":"便民服务","serviceDesc":"快捷方便不要出门也能门诊预约","isRecommend":"N","link":"outpatient/hospitalList","updateTime":"2021-05-10 09:20:43","remark":null,"pid":1,"sort":3,"params":{},"serviceName":"门诊预约","imgUrl":"/prod-api/profile/upload/image/2021/05/10/31a6533c-bf60-4890-9a25-b18db764776a.png","createBy":null,"createTime":"2020-10-12 18:17:58","updateBy":null,"id":5,"searchValue":null},{"serviceType":"车主服务","serviceDesc":"查询车辆违章","isRecommend":"N","link":"traffic/index","updateTime":"2021-05-10 09:20:53","remark":null,"pid":1,"sort":5,"params":{},"serviceName":"智慧交管","imgUrl":"/prod-api/profile/upload/image/2021/05/10/426fdd6c-c2dd-4def-97eb-76c68c0103be.png","createBy":null,"createTime":"2020-10-12 18:18:39","updateBy":null,"id":9,"searchValue":null},{"serviceType":"生活服务","serviceDesc":"不要出门也能缴费","isRecommend":"N","link":"living_expenses/index","updateTime":"2021-05-10 09:21:03","remark":null,"pid":1,"sort":6,"params":{},"serviceName":"生活缴费","imgUrl":"/prod-api/profile/upload/image/2021/05/10/7abdfdc9-de48-4639-97a4-0cf2738a3073.png","createBy":null,"createTime":"2020-10-12 18:18:21","updateBy":null,"id":7,"searchValue":null},{"serviceType":"便民服务","serviceDesc":"外卖订餐","isRecommend":"N","link":"takeout/index","updateTime":"2021-05-10 09:36:16","remark":null,"pid":null,"sort":7,"params":{},"serviceName":"外卖订餐","imgUrl":"/prod-api/profile/upload/image/2021/05/10/22523c67-24a0-4825-9c1f-8cd19c7f0c24.png","createBy":null,"createTime":"2021-05-05 11:41:35","updateBy":null,"id":19,"searchValue":null},{"serviceType":"便民服务","serviceDesc":"房屋租赁","isRecommend":"N","link":"house/index","updateTime":"2021-05-10 09:36:29","remark":null,"pid":null,"sort":8,"params":{},"serviceName":"找房子","imgUrl":"/prod-api/profile/upload/image/2021/05/10/022a6703-cebf-4c47-9218-207e2874a030.png","createBy":null,"createTime":"2021-05-05 11:42:31","updateBy":null,"id":20,"searchValue":null},{"serviceType":"生活服务","serviceDesc":"观影购票","isRecommend":"N","link":"movie/index","updateTime":"2021-05-10 09:36:40","remark":null,"pid":null,"sort":9,"params":{},"serviceName":"看电影","imgUrl":"/prod-api/profile/upload/image/2021/05/10/16ef12bf-d5eb-4df1-a896-bb08138f9fe6.png","createBy":null,"createTime":"2021-05-05 11:41:05","updateBy":null,"id":18,"searchValue":null},{"serviceType":"便民服务","serviceDesc":"招聘求职","isRecommend":"N","link":"job/index","updateTime":"2021-05-10 09:36:48","remark":null,"pid":null,"sort":10,"params":{},"serviceName":"找工作","imgUrl":"/prod-api/profile/upload/image/2021/05/10/f9f9d0ac-3203-43fa-b4a7-2515192b0041.png","createBy":null,"createTime":"2021-05-05 11:43:04","updateBy":null,"id":21,"searchValue":null},{"serviceType":"生活服务","serviceDesc":"活动管理","isRecommend":"N","link":"activity/index","updateTime":"2021-05-12 10:45:49","remark":null,"pid":null,"sort":11,"params":{},"serviceName":"活动管理","imgUrl":"/prod-api/profile/upload/image/2021/05/05/8f5d9d3a-3ac7-4e66-9d9a-630ba4bd80ef.png","createBy":null,"createTime":"2021-05-05 11:44:19","updateBy":null,"id":22,"searchValue":null},{"serviceType":"生活服务","serviceDesc":"","isRecommend":"N","link":"petHospital/index","updateTime":"2022-05-05 15:47:09","remark":null,"pid":null,"sort":12,"params":{},"serviceName":"宠物医院","imgUrl":"/prod-api/profile/upload/image/2022/05/05/83642af2-bf44-4cb0-8c37-d2762dd32f96.png","createBy":null,"createTime":"2022-05-05 15:25:23","updateBy":null,"id":23,"searchValue":null},{"serviceType":"便民服务","serviceDesc":null,"isRecommend":"N","link":"logistic/index","updateTime":"2022-05-05 15:47:15","remark":null,"pid":null,"sort":13,"params":{},"serviceName":"物流查询","imgUrl":"/prod-api/profile/upload/image/2022/05/05/b887ee58-f34a-41b1-aa22-090739b9b254.png","createBy":null,"createTime":"2022-05-05 15:25:52","updateBy":null,"id":24,"searchValue":null},{"serviceType":"生活服务","serviceDesc":null,"isRecommend":"N","link":"welfare/index","updateTime":"2022-05-05 15:47:20","remark":null,"pid":null,"sort":14,"params":{},"serviceName":"爱心捐赠","imgUrl":"/prod-api/profile/upload/image/2022/05/05/4717e93e-5dc8-42d5-ad71-c9411ae29092.png","createBy":null,"createTime":"2022-05-05 15:36:20","updateBy":null,"id":25,"searchValue":null},{"serviceType":"便民服务","serviceDesc":null,"isRecommend":"N","link":"youthStation/index","updateTime":"2022-05-05 15:47:24","remark":null,"pid":null,"sort":15,"params":{},"serviceName":"青年驿站","imgUrl":"/prod-api/profile/upload/image/2022/05/05/5bbe4cc5-caf9-498c-b1fa-b8dd163d8a36.png","createBy":null,"createTime":"2022-05-05 15:36:55","updateBy":null,"id":26,"searchValue":null},{"serviceType":"生活服务","serviceDesc":null,"isRecommend":"N","link":"analyse/index","updateTime":"2022-05-05 15:47:30","remark":null,"pid":null,"sort":16,"params":{},"serviceName":"数据分析","imgUrl":"/prod-api/profile/upload/image/2022/05/05/ceeff962-25f6-4a09-92d1-279af2e1d1e1.png","createBy":null,"createTime":"2022-05-05 15:38:57","updateBy":null,"id":27,"searchValue":null}]
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

    public static class RowsEntity implements Serializable{
        /**
         * serviceType : 车主服务
         * serviceDesc : 查询停车场
         * isRecommend : N
         * link : park/index
         * updateTime : 2021-05-10 09:20:12
         * remark : null
         * pid : 1
         * sort : 0
         * params : {}
         * serviceName : 停哪儿
         * imgUrl : /prod-api/profile/upload/image/2021/05/10/814fc6c4-de48-48a1-95f8-de3e749e348d.png
         * createBy : null
         * createTime : 2020-10-23 16:17:56
         * updateBy : null
         * id : 17
         * searchValue : null
         */
        private String serviceType;
        private String serviceDesc;
        private String isRecommend;
        private String link;
        private String updateTime;
        private String remark;
        private int pid;
        private int sort;
        private ParamsEntity params;
        private String serviceName;
        private String imgUrl;
        private String createBy;
        private String createTime;
        private String updateBy;
        private int id;
        private String searchValue;

        public RowsEntity(String serviceType, String serviceName, String imgUrl,int id) {
            this.serviceType = serviceType;
            this.serviceName = serviceName;
            this.imgUrl = imgUrl;
            this.id = id;

            this.serviceDesc = null;
            this.isRecommend = "N";
            this.link = null;
            this.updateTime = null;
            this.remark = null;
            this.pid = 0;
            this.sort = 0;
            this.params = null;
            this.createBy = null;
            this.createTime = null;
            this.updateBy = null;
            this.searchValue = null;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public void setServiceDesc(String serviceDesc) {
            this.serviceDesc = serviceDesc;
        }

        public void setIsRecommend(String isRecommend) {
            this.isRecommend = isRecommend;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setParams(ParamsEntity params) {
            this.params = params;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
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

        public void setId(int id) {
            this.id = id;
        }

        public void setSearchValue(String searchValue) {
            this.searchValue = searchValue;
        }

        public String getServiceType() {
            return serviceType;
        }

        public String getServiceDesc() {
            return serviceDesc;
        }

        public String getIsRecommend() {
            return isRecommend;
        }

        public String getLink() {
            return link;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public int getPid() {
            return pid;
        }

        public int getSort() {
            return sort;
        }

        public ParamsEntity getParams() {
            return params;
        }

        public String getServiceName() {
            return serviceName;
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

        public int getId() {
            return id;
        }

        public String getSearchValue() {
            return searchValue;
        }

        public class ParamsEntity implements Serializable{
        }
    }
}
