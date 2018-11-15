package com.icephone.yuhao.repairerecord.bean;

import java.io.Serializable;
import java.util.List;

public class PeopleBean implements Serializable {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"personBean":[{"_id":"5bdc3efef4d21d91346961b6","nick_name":"陈双才","account":"chenshaungcai","password":"123456","limit":1,"manage_center":"顺平联社"},{"_id":"5bdc3f15f4d21d91346961b7","nick_name":"闫保德","account":"yanbaode","password":"123456","limit":1,"manage_center":"曲阳联社"},{"_id":"5bdc3f49f4d21d91346961b8","nick_name":"林雨","account":"linyu","password":"123456","limit":2,"manage_center":""},{"_id":"5bdc3f59f4d21d91346961b9","nick_name":"徐金永","account":"xujinyong","password":"123456","limit":0,"manage_center":""},{"_id":"5bdc3f65f4d21d91346961ba","nick_name":"李艳辉","account":"liyanhui","password":"123456","limit":2,"manage_center":""}]}
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
        private List<PersonBeanBean> personBean;

        public List<PersonBeanBean> getPersonBean() {
            return personBean;
        }

        public void setPersonBean(List<PersonBeanBean> personBean) {
            this.personBean = personBean;
        }

        public static class PersonBeanBean {
            /**
             * _id : 5bdc3efef4d21d91346961b6
             * nick_name : 陈双才
             * account : chenshaungcai
             * password : 123456
             * limit : 1
             * manage_center : 顺平联社
             */

            private String _id;
            private String nick_name;
            private String account;
            private String password;
            private int limit;
            private String manage_center;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public String getManage_center() {
                return manage_center;
            }

            public void setManage_center(String manage_center) {
                this.manage_center = manage_center;
            }
        }
    }
}
