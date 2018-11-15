package com.icephone.yuhao.repairerecord.bean;

import java.util.List;

public class DeviceBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"DeviceBean":[{"_id":"5bdc3ea4f4d21d91346961b2","device_name":"红外摄像机"},{"_id":"5bdc3eacf4d21d91346961b3","device_name":"柜员枪机"},{"_id":"5bdc3eb6f4d21d91346961b4","device_name":"网线"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<DeviceBeanBean> DeviceBean;

        public List<DeviceBeanBean> getDeviceBean() {
            return DeviceBean;
        }

        public void setDeviceBean(List<DeviceBeanBean> DeviceBean) {
            this.DeviceBean = DeviceBean;
        }

        public static class DeviceBeanBean {
            /**
             * _id : 5bdc3ea4f4d21d91346961b2
             * device_name : 红外摄像机
             */

            private String _id;
            private String device_name;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getDevice_name() {
                return device_name;
            }

            public void setDevice_name(String device_name) {
                this.device_name = device_name;
            }
        }
    }
}
