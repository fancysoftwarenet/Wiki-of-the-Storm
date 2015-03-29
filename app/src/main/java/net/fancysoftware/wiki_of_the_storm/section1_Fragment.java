package net.fancysoftware.wiki_of_the_storm;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Mathieu on 09/03/2015.
 */
public class section1_Fragment extends android.support.v4.app.Fragment{
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        rootview = inflater.inflate(R.layout.section1_layout, container, false);

        ArrayList<HttpGetNews.Article> listArticles = HttpGetNews.Article.listArticles;

        for (final HttpGetNews.Article article : listArticles){
            LinearLayout linearLayout = (LinearLayout)rootview.findViewById(R.id.liste_news);

            /*LinearLayout news = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
            news.setLayoutParams(params);
            news.setBackgroundColor(getResources().getColor(R.color.primary_material_light));*/
            LinearLayout layoutNews = new LinearLayout(rootview.getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
            params.setMargins(0, 0, 0, 30);
            layoutNews.setLayoutParams(params);
            layoutNews.setBackgroundColor(getResources().getColor(R.color.background_news));
            layoutNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse("http://eu.battle.net" + article.url) );
                    startActivity(intent);
                }

            });

            LinearLayout dateNews = new LinearLayout(rootview.getContext());
            dateNews.setGravity(17);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(180, ViewGroup.LayoutParams.MATCH_PARENT);
            dateNews.setLayoutParams(params1);
            dateNews.setBackgroundColor(getResources().getColor(R.color.background_date_news));
            layoutNews.addView(dateNews);

            TextView dateNewsText = new TextView(rootview.getContext());
            dateNewsText.setText(article.date.split("\n")[0] + "\n" + article.date.split("\n")[1] + "\n" + article.date.split("\n")[2]);
            dateNewsText.setTextColor(Color.WHITE);
            dateNewsText.setGravity(Gravity.CENTER);
            dateNews.addView(dateNewsText);

            LinearLayout wrapperTitle = new LinearLayout(rootview.getContext());
            wrapperTitle.setPadding(18, 10, 18, 0);
            layoutNews.addView(wrapperTitle);

            TextView news = new TextView(rootview.getContext());
            news.setText(article.title);
            news.setTypeface(Typeface.create("WikioftheStorm", Typeface.BOLD));
            news.setTextSize(16f);
            //news.setTextColor(Color.argb(255, 100, 100, 100));
            news.setTextColor(Color.WHITE);
            wrapperTitle.addView(news);

            linearLayout.addView(layoutNews);
        }

        return rootview;
    }
}