package com.icephone.yuhao.repairerecord.bean;

public class RepairRecordBean {

    private String _id;
    private String time;
    private String site_name;
    private String repair_pro;
    private String repair_person;
    private String site_person;
    private String center_name;

    public RepairRecordBean(String id, String time, String site_name, String repair_pro,String repair_person, String site_person, String center_name) {
        this._id = id;
        this.time = time;
        this.site_name = site_name;
        this.repair_pro = repair_pro;
        this.repair_person = repair_person;
        this.site_person = site_person;
        this.center_name = center_name;
    }

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

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getRepair_pro() {
        return repair_pro;
    }

    public void setRepair_pro(String repair_pro) {
        this.repair_pro = repair_pro;
    }

    public String getRepair_person() {
        return repair_person;
    }

    public void setRepair_person(String repair_person) {
        this.repair_person = repair_person;
    }

    public String getSite_person() {
        return site_person;
    }

    public void setSite_person(String site_person) {
        this.site_person = site_person;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

}
