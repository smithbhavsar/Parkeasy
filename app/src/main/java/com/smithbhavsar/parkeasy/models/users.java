package com.smithbhavsar.parkeasy.models;

public class users {
    private String Uid;
    private String username;
    private String email;

    public users() {
    }

    public users(String username) {
        this.username = username;
    }

    public users(String uid, String username, String email) {
        Uid = uid;
        this.username = username;
        this.email = email;
    }


    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
