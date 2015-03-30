package net.fancysoftware.wiki_of_the_storm;

import android.test.InstrumentationTestCase;

/**
 * Created by Paul on 30/03/2015.
 */
public class FavorisManagerTest extends InstrumentationTestCase{
    FavorisManager fm;
    Personnage personnage;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        fm = new FavorisManager();
        personnage = Personnage.PersonnageStatic.personnages.get(1);
    }

    public void testAddFavoris(){
        fm.WriteFavoris(null, personnage);

        assertTrue(fm.isFavoris(null, Integer.toString(personnage.getID())));
        assertFalse(fm.isFavoris(null, "7"));
    }

    public void testRemoveFavoris(){
        fm.WriteFavoris(null, personnage);
        assertTrue(fm.isFavoris(null, Integer.toString(personnage.getID())));
        fm.DeleteFavoris(null, Integer.toString(personnage.getID()));
        assertFalse(fm.isFavoris(null, Integer.toString(personnage.getID())));
    }
}
