package com.huangxue.s01.Beans;

import java.util.List;

public class SubwayListBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"preStep":{"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},"currentName":"建国门","lineId":31,"lineName":"2号线","nextStep":{"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},"reachTime":4},{"preStep":{"name":"东单","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":34,"lineName":"5号线"},{"lineId":35,"lineName":"1号线"},{"lineId":39,"lineName":"5号线"}]},"currentName":"建国门","lineId":33,"lineName":"1号线","nextStep":{"name":"永安里","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":35,"lineName":"1号线"}]},"reachTime":4},{"preStep":{"name":"永安里","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":35,"lineName":"1号线"}]},"currentName":"建国门","lineId":35,"lineName":"1号线","nextStep":{"name":"东单","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":34,"lineName":"5号线"},{"lineId":35,"lineName":"1号线"},{"lineId":39,"lineName":"5号线"}]},"reachTime":6},{"preStep":{"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},"currentName":"建国门","lineId":38,"lineName":"2号线","nextStep":{"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},"reachTime":5}]
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
         * preStep : {"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]}
         * currentName : 建国门
         * lineId : 31
         * lineName : 2号线
         * nextStep : {"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]}
         * reachTime : 4
         */
        private PreStepEntity preStep;
        private String currentName;
        private int lineId;
        private String lineName;
        private NextStepEntity nextStep;
        private int reachTime;

        public void setPreStep(PreStepEntity preStep) {
            this.preStep = preStep;
        }

        public void setCurrentName(String currentName) {
            this.currentName = currentName;
        }

        public void setLineId(int lineId) {
            this.lineId = lineId;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public void setNextStep(NextStepEntity nextStep) {
            this.nextStep = nextStep;
        }

        public void setReachTime(int reachTime) {
            this.reachTime = reachTime;
        }

        public PreStepEntity getPreStep() {
            return preStep;
        }

        public String getCurrentName() {
            return currentName;
        }

        public int getLineId() {
            return lineId;
        }

        public String getLineName() {
            return lineName;
        }

        public NextStepEntity getNextStep() {
            return nextStep;
        }

        public int getReachTime() {
            return reachTime;
        }

        public class PreStepEntity {
            /**
             * name : 朝阳门
             * lines : [{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]
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
                 * lineId : 21
                 * lineName : 6号线
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

        public class NextStepEntity {
            /**
             * name : 北京站
             * lines : [{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]
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
                 * lineId : 31
                 * lineName : 2号线
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
}
