package com.icephone.yuhao.repairerecord.bean;

import java.util.List;

public class InstallRecordBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"installBean":[{"_id":"5bdc3edaf4d21d91346961b5","time":"20181009","center_name":"清苑联社","site_name":"第一储蓄所","site_person":"小王","install_person":"李艳辉，林雨","install_pro":"电视监控","device":"摄像机","install_state":"摄像机无图像，保修期内进行更换","install_complete":0,"install_cost":"100元"}]}
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
        private List<InstallBeanBean> installBean;

        public List<InstallBeanBean> getInstallBean() {
            return installBean;
        }

        public void setInstallBean(List<InstallBeanBean> installBean) {
            this.installBean = installBean;
        }

        public static class InstallBeanBean {
            /**
             * _id : 5bdc3edaf4d21d91346961b5
             * time : 20181009
             * center_name : 清苑联社
             * site_name : 第一储蓄所
             * site_person : 小王
             * install_person : 李艳辉，林雨
             * install_pro : 电视监控
             * device : 摄像机
             * install_state : 摄像机无图像，保修期内进行更换
             * install_complete : 0
             * install_cost : 100元
             */

            private String _id;
            private String time;
            private String center_name;
            private String site_name;
            private String site_person;
            private String install_person;
            private String install_pro;
            private String device;
            private String install_state;
            private int install_complete;
            private String install_cost;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getCenter_name() {
                return center_name;
            }

            public void setCenter_name(String center_name) {
                this.center_name = center_name;
            }

            public String getSite_name() {
                return site_name;
            }

            public void setSite_name(String site_name) {
                this.site_name = site_name;
            }

            public String getSite_person() {
                return site_person;
            }

            public void setSite_person(String site_person) {
                this.site_person = site_person;
            }

            public String getInstall_person() {
                return install_person;
            }

            public void setInstall_person(String install_person) {
                this.install_person = install_person;
            }

            public String getInstall_pro() {
                return install_pro;
            }

            public void setInstall_pro(String install_pro) {
                this.install_pro = install_pro;
            }

            public String getDevice() {
                return device;
            }

            public void setDevice(String device) {
                this.device = device;
            }

            public String getInstall_state() {
                return install_state;
            }

            public void setInstall_state(String install_state) {
                this.install_state = install_state;
            }

            public int getInstall_complete() {
                return install_complete;
            }

            public void setInstall_complete(int install_complete) {
                this.install_complete = install_complete;
            }

            public String getInstall_cost() {
                return install_cost;
            }

            public void setInstall_cost(String install_cost) {
                this.install_cost = install_cost;
            }
        }
    }
}
