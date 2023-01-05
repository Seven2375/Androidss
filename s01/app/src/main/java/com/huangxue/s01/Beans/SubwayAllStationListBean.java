package com.huangxue.s01.Beans;

import java.util.List;

public class SubwayAllStationListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"name":"奥体中心","lines":[{"lineId":7,"lineName":"8号线"},{"lineId":27,"lineName":"8号线"}]},{"name":"紫草坞","lines":[{"lineId":3,"lineName":"燕房线"},{"lineId":29,"lineName":"燕房线"}]}]
     */
    private String msg;
    private int code;
    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * name : 奥体中心
         * lines : [{"lineId":7,"lineName":"8号线"},{"lineId":27,"lineName":"8号线"}]
         */
        private String name;
        private List<LinesEntity> lines;

        public void setName(String name) {
            this.name = name;
        }

        public void setLines(List<LinesEntity> lines) {
            this.lines = lines;
        }

        public String getName() {
            return name;
        }

        public List<LinesEntity> getLines() {
            return lines;
        }

        public class LinesEntity {
            /**
             * lineId : 7
             * lineName : 8号线
             */
            private int lineId;
            private String lineName;

            public void setLineId(int lineId) {
                this.lineId = lineId;
            }

            public void setLineName(String lineName) {
                this.lineName = lineName;
            }

            public int getLineId() {
                return lineId;
            }

            public String getLineName() {
                return lineName;
            }
        }
    }
}
