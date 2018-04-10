package com.example.echartsdata.gson;

/**
 * Created by Administrator on 2018/3/29.
 */

public class Geoaddress {
    private String lng;
    private String lat;

    public Geoaddress(String lng, String lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
