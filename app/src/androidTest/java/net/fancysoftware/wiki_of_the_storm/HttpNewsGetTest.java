package net.fancysoftware.wiki_of_the_storm;

import android.test.InstrumentationTestCase;

import java.util.ArrayList;

/**
 * Created by Paul on 30/03/2015.
 */
public class HttpNewsGetTest extends InstrumentationTestCase {

    ArrayList<HttpGetNews.Article> listArticles;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        listArticles = HttpGetNews.Article.listArticles;
    }

    public void testRecupUrlArticles(){
        assertFalse(listArticles.get(0).url == "");
        assertTrue(listArticles.get(0).url == "/heroes/fr/blog/18443712/la-tombe-de-la-reine-araignée-aperçu-du-champ-de-bataille-26-03-2015");
    }

    public void testRecuTitleArticles(){
        assertFalse(listArticles.get(0).url == "");
        assertTrue(listArticles.get(1).url == "Lumière sur Sylvanas");
    }
}
