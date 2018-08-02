package com.littlejava;

import model.News;
import model.NewsFactory;
import view.NewsListViewer;

import java.util.ArrayList;

/*
 * 抓取 http://www.readhub.me
 *
 * */
public class Main {

    public static void main(String[] args) {
        try {
            String resource_path = Main.class.getClassLoader().getResource("news").getPath();
            NewsFactory fact = new NewsFactory(resource_path);
            ArrayList<News> al =  fact.fetch();
            NewsListViewer vie = new NewsListViewer(al);
            vie.Display();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            System.out.println("遇到一些错误");
        }

    }
}
