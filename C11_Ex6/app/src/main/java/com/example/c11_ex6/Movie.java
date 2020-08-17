package com.example.c11_ex6;

import java.io.Serializable;

public class Movie implements Serializable {
    private String[] name = {"써니", "완득이", "괴물", "라디오 스타", "비열한 거리", "왕의 남자", "아일랜드",
    "웰컴 투 동막골", "헬보이", "몰라", "여인의 향기", "쥬라기 공원", "포레스트 검프", "몰라", "혹성탈출",
    "아름다운 비행", "내 이름은 칸", "해리포터", "마더", "킹콩을 들다"};
    private String[] actor = {"써니", "완득이", "괴물", "라디오 스타", "비열한 거리", "왕의 남자", "아일랜드",
            "웰컴 투 동막골", "헬보이", "몰라", "여인의 향기", "쥬라기 공원", "포레스트 검프", "몰라", "혹성탈출",
            "아름다운 비행", "내 이름은 칸", "해리포터", "마더", "킹콩을 들다"};
    private String[] content = {"써니", "완득이", "괴물", "라디오 스타", "비열한 거리", "왕의 남자", "아일랜드",
            "웰컴 투 동막골", "헬보이", "몰라", "여인의 향기", "쥬라기 공원", "포레스트 검프", "몰라", "혹성탈출",
            "아름다운 비행", "내 이름은 칸", "해리포터", "마더", "킹콩을 들다"};
    private String img;

    public Movie(String[] name, String[] actor, String[] content, String img) {
        this.name = name;
        this.actor = actor;
        this.content = content;
        this.img = img;
    }

    public String[] getName() {
        return name;
    }

    public String[] getActor() {
        return actor;
    }

    public String[] getContent() {
        return content;
    }

    public String getImg() {
        return img;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public void setActor(String[] actor) {
        this.actor = actor;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
