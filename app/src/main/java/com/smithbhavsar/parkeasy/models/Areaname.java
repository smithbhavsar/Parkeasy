package com.smithbhavsar.parkeasy.models;


import com.bignerdranch.expandablerecyclerview.Model.ParentObject;


public class Areaname {

    private String title;
    private String sub;
    private int available;
    private double lat;
    private double lan;


    public Areaname(){
    }

    public Areaname(String title, int available, double lat, double lan, String sub) {
        this.title = title;
        this.available = available;
        this.lat = lat;
        this.lan = lan;
        this.sub = sub ;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }

}
