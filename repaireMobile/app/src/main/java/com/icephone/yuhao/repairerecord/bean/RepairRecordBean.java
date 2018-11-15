package com.icephone.yuhao.repairerecord.bean;

import java.io.Serializable;
import java.util.List;

public class RepairRecordBean implements Serializable {

    /**
     * _id : 5bcc5ea1775c42d5c8480028
     * time : 20181007
     * site_name : 南大冉信用社
     * repair_pro : 电视监控
     * repair_person : 林雨
     * site_person : 张三，王五
     * center_name : 清苑联社
     * device : 电视监控
     * fix_state : 摄像机无图像，保修期内进行更换
     * return_fix : 1
     * fix_cost :
     * return_time : 未返厂
     */

    private String _id;
    private String time;
    private String site_name;
    private String repair_pro;
    private String repair_person;
    private String site_person;
    private String center_name;
    private String device;
    private String fix_state;
    private int return_fix;
    private String fix_cost;
    private String return_time;

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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getFix_state() {
        return fix_state;
    }

    public void setFix_state(String fix_state) {
        this.fix_state = fix_state;
    }

    public int getReturn_fix() {
        return return_fix;
    }

    public void setReturn_fix(int return_fix) {
        this.return_fix = return_fix;
    }

    public String getFix_cost() {
        return fix_cost;
    }

    public void setFix_cost(String fix_cost) {
        this.fix_cost = fix_cost;
    }

    public String getReturn_time() {
        return return_time;
    }

    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }

}
