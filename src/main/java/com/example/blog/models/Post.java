package com.example.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private  String anons, fulltext1,title;
    private int views;


    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFulltext1() {
        return fulltext1;
    }

    public void setFulltext1(String fulltext) {
        this.fulltext1 = fulltext;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }
    public Post(String anons, String fulltext1, String title) {
        this.anons = anons;
        this.fulltext1 = fulltext1;
        this.title = title;
    }
    public  Post (){

    }


}