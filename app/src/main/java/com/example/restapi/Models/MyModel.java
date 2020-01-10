package com.example.restapi.Models;

public class MyModel {

    private String fbname;
    private String content;
    private int likes;
    private int comments;

    public MyModel(){}

    public String getFbname() {
        return fbname;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }
}
