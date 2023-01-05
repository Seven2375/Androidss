package com.huangxue.s01.Beans;

import java.util.List;

public class SubwayInfoBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"stationsNumber":6,"km":10,"name":"2号线","runStationsName":"鼓楼大街","end":"积水潭","startTime":"05:10","id":31,"endTime":"22:20","cityId":1,"first":"内环(积水潭)","metroStepList":[{"firstCh":"J","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"积水潭","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":457,"params":{},"searchValue":null,"seq":1},{"firstCh":"G","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"鼓楼大街","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":458,"params":{},"searchValue":null,"seq":2},{"firstCh":"A","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"安定门","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":459,"params":{},"searchValue":null,"seq":3},{"firstCh":"Y","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"雍和宫","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":460,"params":{},"searchValue":null,"seq":4},{"firstCh":"D","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"东直门","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":461,"params":{},"searchValue":null,"seq":5},{"firstCh":"D","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"东四十条","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":462,"params":{},"searchValue":null,"seq":6},{"firstCh":"C","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"朝阳门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":463,"params":{},"searchValue":null,"seq":7},{"firstCh":"J","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"建国门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":464,"params":{},"searchValue":null,"seq":8},{"firstCh":"B","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"北京站","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":465,"params":{},"searchValue":null,"seq":9},{"firstCh":"C","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"崇文门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":466,"params":{},"searchValue":null,"seq":10},{"firstCh":"Q","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"前门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":467,"params":{},"searchValue":null,"seq":11},{"firstCh":"H","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"和平门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":468,"params":{},"searchValue":null,"seq":12},{"firstCh":"X","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"宣武门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":469,"params":{},"searchValue":null,"seq":13},{"firstCh":"C","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"长椿街","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":470,"params":{},"searchValue":null,"seq":14},{"firstCh":"F","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"复兴门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":471,"params":{},"searchValue":null,"seq":15},{"firstCh":"F","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"阜成门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":472,"params":{},"searchValue":null,"seq":16},{"firstCh":"C","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"车公庄","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":473,"params":{},"searchValue":null,"seq":17},{"firstCh":"X","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"西直门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":474,"params":{},"searchValue":null,"seq":18},{"firstCh":"J","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"积水潭","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":475,"params":{},"searchValue":null,"seq":19}],"remainingTime":2}
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
         * stationsNumber : 6
         * km : 10
         * name : 2号线
         * runStationsName : 鼓楼大街
         * end : 积水潭
         * startTime : 05:10
         * id : 31
         * endTime : 22:20
         * cityId : 1
         * first : 内环(积水潭)
         * metroStepList : [{"firstCh":"J","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"积水潭","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":457,"params":{},"searchValue":null,"seq":1},{"firstCh":"G","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"鼓楼大街","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":458,"params":{},"searchValue":null,"seq":2},{"firstCh":"A","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"安定门","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":459,"params":{},"searchValue":null,"seq":3},{"firstCh":"Y","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"雍和宫","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":460,"params":{},"searchValue":null,"seq":4},{"firstCh":"D","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"东直门","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":461,"params":{},"searchValue":null,"seq":5},{"firstCh":"D","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"东四十条","lineId":31,"updateTime":"2021-04-05 15:47:12","remark":null,"id":462,"params":{},"searchValue":null,"seq":6},{"firstCh":"C","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"朝阳门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":463,"params":{},"searchValue":null,"seq":7},{"firstCh":"J","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"建国门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":464,"params":{},"searchValue":null,"seq":8},{"firstCh":"B","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"北京站","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":465,"params":{},"searchValue":null,"seq":9},{"firstCh":"C","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"崇文门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":466,"params":{},"searchValue":null,"seq":10},{"firstCh":"Q","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"前门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":467,"params":{},"searchValue":null,"seq":11},{"firstCh":"H","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"和平门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":468,"params":{},"searchValue":null,"seq":12},{"firstCh":"X","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"宣武门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":469,"params":{},"searchValue":null,"seq":13},{"firstCh":"C","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"长椿街","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":470,"params":{},"searchValue":null,"seq":14},{"firstCh":"F","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"复兴门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":471,"params":{},"searchValue":null,"seq":15},{"firstCh":"F","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"阜成门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":472,"params":{},"searchValue":null,"seq":16},{"firstCh":"C","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"车公庄","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":473,"params":{},"searchValue":null,"seq":17},{"firstCh":"X","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"西直门","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":474,"params":{},"searchValue":null,"seq":18},{"firstCh":"J","createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"name":"积水潭","lineId":31,"updateTime":"2021-04-05 15:47:13","remark":null,"id":475,"params":{},"searchValue":null,"seq":19}]
         * remainingTime : 2
         */
        private int stationsNumber;
        private int km;
        private String name;
        private String runStationsName;
        private String end;
        private String startTime;
        private int id;
        private String endTime;
        private int cityId;
        private String first;
        private List<MetroStepListEntity> metroStepList;
        private int remainingTime;

        public void setStationsNumber(int stationsNumber) {
            this.stationsNumber = stationsNumber;
        }

        public void setKm(int km) {
            this.km = km;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRunStationsName(String runStationsName) {
            this.runStationsName = runStationsName;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public void setMetroStepList(List<MetroStepListEntity> metroStepList) {
            this.metroStepList = metroStepList;
        }

        public void setRemainingTime(int remainingTime) {
            this.remainingTime = remainingTime;
        }

        public int getStationsNumber() {
            return stationsNumber;
        }

        public int getKm() {
            return km;
        }

        public String getName() {
            return name;
        }

        public String getRunStationsName() {
            return runStationsName;
        }

        public String getEnd() {
            return end;
        }

        public String getStartTime() {
            return startTime;
        }

        public int getId() {
            return id;
        }

        public String getEndTime() {
            return endTime;
        }

        public int getCityId() {
            return cityId;
        }

        public String getFirst() {
            return first;
        }

        public List<MetroStepListEntity> getMetroStepList() {
            return metroStepList;
        }

        public int getRemainingTime() {
            return remainingTime;
        }

        public class MetroStepListEntity {
            /**
             * firstCh : J
             * createBy : null
             * createTime : 2018-07-23 02:28:40
             * updateBy : null
             * name : 积水潭
             * lineId : 31
             * updateTime : 2021-04-05 15:47:12
             * remark : null
             * id : 457
             * params : {}
             * searchValue : null
             * seq : 1
             */
            private String firstCh;
            private String createBy;
            private String createTime;
            private String updateBy;
            private String name;
            private int lineId;
            private String updateTime;
            private String remark;
            private int id;
            private ParamsEntity params;
            private String searchValue;
            private int seq;

            public void setFirstCh(String firstCh) {
                this.firstCh = firstCh;
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

            public void setLineId(int lineId) {
                this.lineId = lineId;
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

            public void setParams(ParamsEntity params) {
                this.params = params;
            }

            public void setSearchValue(String searchValue) {
                this.searchValue = searchValue;
            }

            public void setSeq(int seq) {
                this.seq = seq;
            }

            public String getFirstCh() {
                return firstCh;
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

            public int getLineId() {
                return lineId;
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

            public ParamsEntity getParams() {
                return params;
            }

            public String getSearchValue() {
                return searchValue;
            }

            public int getSeq() {
                return seq;
            }

            public class ParamsEntity {
            }
        }
    }
}
