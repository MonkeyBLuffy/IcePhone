package com.icephone.yuhao.repairerecord.bean;

import java.io.Serializable;
import java.util.List;

public class PeopleBean implements Serializable {

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
