package com.example.xml.model;

import lombok.Getter;

public class UserDto {

    @Getter
    private Long id;
    @Getter
    private String userName;
    @Getter
    private String password;
    @Getter
    private String address;
    @Getter
    private int age;
    private boolean isLive;

    public UserDto(Long id, String userName, String password, String address, int age, boolean isLive) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.age = age;
        this.isLive = isLive;
    }

    public UserDto(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
