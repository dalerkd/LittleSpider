package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * 处理文件,生成News对象
 * */
public class NewsFactory {
    private File newsDir;

    public NewsFactory(String dir) throws Exception {
        newsDir = new File(dir);//打开目录
        if (!newsDir.exists()) {
            throw new Exception("目录不存在");
        }
        if (!newsDir.isDirectory()) {
            throw new Exception("路径不是一个目录");
        }

    }

    //获取
    public ArrayList<News> fetch() {
        ArrayList<News> newsList = new ArrayList<News>();
        File[] files = newsDir.listFiles();
        if (files != null) {
            for (File file : files) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    String title = reader.readLine();
                    reader.readLine();
                    String context = reader.readLine();
                    reader.readLine();

                    /*
                     * 开始循环读取,空行或文件结束
                     * */
                    String timeLinenewsTime;
                    String timeLinenewsTitle;
                    HashMap<String, String> otherLine = new HashMap<String, String>();
                    for (; ; ) {
                        timeLinenewsTime = reader.readLine();
                        if (timeLinenewsTime == null) {
                            break;
                        }
                        timeLinenewsTitle = reader.readLine();
                        if (timeLinenewsTitle == null) {
                            break;
                        }
                        otherLine.put(timeLinenewsTime, timeLinenewsTitle);
                    }
                    News news = new News(title, context, otherLine);
                    newsList.add(news);


                } catch (java.io.IOException e) {
                    System.out.println("新闻获取出错" + file.getPath());
                }
            }


        }
        return newsList;
    }

}
