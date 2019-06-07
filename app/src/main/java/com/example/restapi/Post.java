package com.example.restapi;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userid;
    private int id;
    private String title;

    @SerializedName("body")
    private String text;

    public Post(int userid, int id, String title, String text) {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}
