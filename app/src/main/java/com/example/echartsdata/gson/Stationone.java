package com.example.echartsdata.gson;

/**
 * Created by Administrator on 2018/3/29.
 */

public class Stationone {
    private String name;
    private String value;
    private String state;
    private String baojing;
    private String guzhang;

    public Stationone(String name, String value, String state, String baojing, String guzhang, String tips) {
        this.name = name;
        this.value = value;
        this.state = state;
        this.baojing = baojing;
        this.guzhang = guzhang;
        this.tips = tips;
    }

    private String tips;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBaojing() {
        return baojing;
    }

    public void setBaojing(String baojing) {
        this.baojing = baojing;
    }

    public String getGuzhang() {
        return guzhang;
    }

    public void setGuzhang(String guzhang) {
        this.guzhang = guzhang;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }


}
