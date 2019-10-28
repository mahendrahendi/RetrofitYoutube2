package com.example.hendi.retrofityoutube;

public class Hero {
    private String name;
    private String realname;
    private String title;
    private String page;
    private String vote_average;
    private String overview;

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Hero(String name, String realname, String results, String title, String page) {
        this.name = name;
        this.realname = realname;
        this.title = title;
        this.page = page;

    }

    public Hero() {

    }

    public String getPage() {
        return page;

    }



    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", realname='" + realname + '\'' +
                ", title='" + title + '\'' +
                ", page='" + page + '\'' +
                '}';
    }
}
