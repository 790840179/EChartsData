package com.example.echartsdata.gson;

/**
 * Created by Administrator on 2018/3/29.
 */

public class GeoCoordMap {
    private String name;
    public Geoaddress geoaddress;

    public GeoCoordMap(String name, Geoaddress geoaddress) {
        this.name = name;
        this.geoaddress = geoaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geoaddress getGeoaddress() {
        return geoaddress;
    }

    public void setGeoaddress(Geoaddress geoaddress) {
        this.geoaddress = geoaddress;
    }
}
