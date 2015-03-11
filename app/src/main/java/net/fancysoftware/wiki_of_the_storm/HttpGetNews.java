package net.fancysoftware.wiki_of_the_storm;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Paul on 11/03/2015.
 */
public class HttpGetNews extends AsyncTask<Void, Void, ArrayList<HttpGetNews.Article>> {
    private String url;
    private String htmlBli;

    public HttpGetNews(String url) {
        this.url = url;
    }

    @Override
    protected ArrayList<Article> doInBackground(Void... params) {
        htmlBli = getHtml();
        /*Log.d("HTML OUTPUT", htmlBli.split("<article class=\"media-wrapper\">")[1]);
        Log.d("HTML OUTPUT", htmlBli.split("<article class=\"media-wrapper\">")[2]);
        Log.d("HTML OUTPUT", htmlBli.split("<article class=\"media-wrapper\">")[3].split("</article>")[0]);
        Log.d("HTML OUTPUT", htmlBli.split("<article class=\"media-wrapper\">")[5].split("</article>")[0]);*/
        String htmlArticle;
        String title;
        String urlArticle;
        String dateArticle;
        String description;

        ArrayList<Article> articles = new ArrayList<Article>();
        ArrayList<String> arrayTitle = new ArrayList<String>();

        for (int i = 1; i < htmlBli.split("<article class=\"media-wrapper\">").length; i++){
            htmlArticle = htmlBli.split("<article class=\"media-wrapper\">")[i].split("</article>")[0];
            //Log.d("HTML OUTPUT", htmlArticle);

            title = htmlArticle.split("<h2 class=\"news-list__item__title\">")[1].split("</h2>")[0].split("\">")[1].split("</a>")[0].trim();
            //Log.d("HTML OUTPUT TITLE", title);

            urlArticle = htmlArticle.split("<a class=\"news-list__item__thumbnail\" href=\"")[1].split("\">")[0];
            //Log.d("HTML OUTPUT URL", urlArticle);

            dateArticle = htmlArticle.split("<span class=\"publish-date\" title=\"")[1].split("\">")[0];
            dateArticle = dateArticle.replace(' ', '\n');
            //Log.d("HTML OUTPUT DATE", dateArticle);

            /*description = htmlArticle.split("<p class=\"news-list__item__description\">")[1].split("</p>")[0];
            Log.d("HTML OUTPUT DESCRIB", description);*/

            if (!arrayTitle.contains(title)){
                Article article = new Article(title, dateArticle, urlArticle);

                articles.add(article);
                arrayTitle.add(title);
            }
        }

        return articles;
    }

    private String getHtml(){
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(this.url);
        HttpResponse response;
        try{
            response = client.execute(request);
        }catch (IOException e){
            return null;
        }

        String html = "";
        InputStream in;
        try{
            in= response.getEntity().getContent();
        }catch (IOException e){
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder str = new StringBuilder();
        String line = null;
        try{
            while((line = reader.readLine()) != null)
            {
                str.append(line);
            }
        }catch (IOException e){

        }
        try{
            in.close();
        }catch (IOException e){

        }
        html = str.toString();
        return html;
    }

    public static class Article{
        String title;
        String url;
        String date;

        public Article(String titile, String date, String url) {
            this.title = titile;
            this.date = date;
            this.url = url;
        }
    }
}
