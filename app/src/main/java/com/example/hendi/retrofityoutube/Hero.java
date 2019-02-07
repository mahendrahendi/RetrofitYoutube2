package com.example.hendi.retrofityoutube;

public class Hero {
    private String name;
    private String realname;
    private String title;
    private String page;





    public Hero(String name, String realname, String results, String title, String page) {
        this.name = name;
        this.realname = realname;
        this.title = title;
        this.page = page;

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
