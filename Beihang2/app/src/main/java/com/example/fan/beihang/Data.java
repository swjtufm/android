package com.example.fan.beihang;

import java.io.Serializable;

public class Data implements Serializable{

    private String avatar;
    private int id;
    private int userId;
    private String name;
    private int flag;
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    public int getFlag() {
        return flag;
    }

}