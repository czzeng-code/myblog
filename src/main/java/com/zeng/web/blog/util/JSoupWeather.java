package com.zeng.web.blog.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Zeng
 * @ClassName JSoupWeather
 * @Description TOOD
 * @Date 2019/11/7
 * @Version 1.0
 **/
public class JSoupWeather {
    public static void main(String[] args) throws Exception{
       /* //声明文档变量
        Document document;
        //通过JSoup连接目标页面
        document = Jsoup.connect("http://www.weather.com.cn/weather/101190101.shtml").get();
        //选取所有class为col-xs-8的元素集合·
        Elements divs = document.getElementsByClass("sky skyid lv2");
        //对divs遍历
        divs.forEach(div-> {
            //取出class为wrap的节点
            Element wrapDiv = div.child(0);
            System.out.println(wrapDiv.html());


        });*/

        Document document;
        //通过JSoup连接目标页面
        document = Jsoup.connect("https://movie.douban.com/chart").get();
        //选取所有class为col-xs-8的元素集合·
        Elements divs = document.getElementsByClass("item");
        //对divs遍历
        divs.forEach(div-> {
            //取出class为wrap的节点
            Element wrapDiv = div.child(0);
            System.out.println(wrapDiv.child(0).attr("title"));
            System.out.println(wrapDiv.child(0).child(0).attr("src"));
            System.out.println(div.child(1).child(0).getElementsByClass("pl").text());
            System.out.println();


        });

    }
}
