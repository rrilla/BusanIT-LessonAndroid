package com.example.recyclerviewapp2;

public class Movie {
    private int resId;
    private String title;
    private String genre;
    private String director;

    public Movie(){}
    public Movie(int resId,String title, String genre, String director) {
        this.resId=resId;
        this.title = title;
        this.genre = genre;
        this.director = director;
    }

    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
}

