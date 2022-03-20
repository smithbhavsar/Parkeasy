package com.smithbhavsar.parkeasy.models;

public class Spotdetails {

    int distance;
    String in_range;
    String name;
    long timestamp;

    public Spotdetails() {
    }

    public Spotdetails(int distance, String in_range, String name, long timestamp) {
        this.distance = distance;
        this.in_range = in_range;
        this.name = name;
        this.timestamp = timestamp;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getIn_range() {
        return in_range;
    }

    public void setIn_range(String in_range) {
        this.in_range = in_range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
