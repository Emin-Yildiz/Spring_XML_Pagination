package com.example.xml.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JacksonXmlProperty(localName = "username")
    private String userName;
    @JacksonXmlProperty(localName = "password")
    private String password;
    @JacksonXmlProperty(localName = "address")
    private String address;
    @JacksonXmlProperty(localName = "age")
    private int age;
    @JacksonXmlProperty(localName = "islive")
    private boolean isLive;



    public User(Long id, String userName, String password, String address, int age, boolean isLive) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.age = age;
        this.isLive = isLive;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public boolean geIsLive() {
        return isLive;
    }

    public void setIsLive(boolean live) {
        isLive = live;
    }
    public User(Long id){
        this.id = id;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
