package view;

import model.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NewsListViewer {
    private ArrayList<News> newsArrayList;

    public NewsListViewer(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }

    public void Display()
    {
        for (News news : newsArrayList) {

            String title = news.getTitle();
            String context = news.getContext();
            HashMap<String,String>  timeLineNews = news.getTimeLineNews();

            System.out.println("#"+title);
            System.out.println(context);

            //Map map = new HashMap();
            if(timeLineNews==null){
                System.out.println("没有附属信息");
                continue;
            }
            Iterator iter = timeLineNews.entrySet().iterator();
            while (iter.hasNext()) {
                HashMap.Entry entry = (HashMap.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                System.out.println("Date:"+key);
                System.out.println("Context:"+val);

            }
            System.out.println();
        }
    }
}
