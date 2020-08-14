package com.example.intentapp3;

import java.io.Serializable;

public class Member implements Serializable {
    private String id;
    private String pw;
    private String name;
    private String phone;

    public Member(String id, String pw, String name, String phone) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
