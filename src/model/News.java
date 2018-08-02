package model;

import java.util.HashMap;

public class News {
private String title;
private  String context;
private HashMap<String,String> timeLineNews;// 时间:新闻
    public News(String title, String context,HashMap<String,String> timeLineNews) {
        this.title = title;
        this.context = context;
        this.timeLineNews = timeLineNews;
    }

    public HashMap<String, String> getTimeLineNews() {
        return timeLineNews;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }
}
