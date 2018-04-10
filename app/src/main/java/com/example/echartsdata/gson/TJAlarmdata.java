package com.example.echartsdata.gson;

/**
 * Created by Administrator on 2018/3/29.
 */

public class TJAlarmdata {
    public Stationone stationone;
    public Stationtwo stationtwo;

    public TJAlarmdata(Stationone stationone, Stationtwo stationtwo) {
        this.stationone = stationone;
        this.stationtwo = stationtwo;
    }

    public Stationone getStationone() {
        return stationone;
    }

    public void setStationone(Stationone stationone) {
        this.stationone = stationone;
    }

    public Stationtwo getStationtwo() {
        return stationtwo;
    }

    public void setStationtwo(Stationtwo stationtwo) {
        this.stationtwo = stationtwo;
    }
}