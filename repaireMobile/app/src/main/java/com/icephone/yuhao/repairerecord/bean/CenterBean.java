package com.icephone.yuhao.repairerecord.bean;

public class CenterBean {

    private String _id;
    private String centerName;

    public CenterBean(String id, String centerName) {
        this._id = id;
        this.centerName = centerName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }


}
