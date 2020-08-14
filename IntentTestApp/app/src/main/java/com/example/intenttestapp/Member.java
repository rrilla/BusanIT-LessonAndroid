package com.example.intenttestapp;

import java.io.Serializable;

public class Member implements Serializable {
    private String name;
    private int age;
    private String[] hobby;

    public Member(){}

    public Member(String name, int age, String[] hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}
