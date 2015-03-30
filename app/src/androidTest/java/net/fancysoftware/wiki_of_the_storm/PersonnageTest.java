package net.fancysoftware.wiki_of_the_storm;

import android.test.InstrumentationTestCase;

/**
 * Created by Paul on 30/03/2015.
 */
public class PersonnageTest extends InstrumentationTestCase {
    Personnage premierPersonnage;
    Personnage troisiemePersonnage;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        premierPersonnage = Personnage.PersonnageStatic.personnages.get(2);
        troisiemePersonnage = Personnage.PersonnageStatic.personnages.get(2);
    }

    public void testNomPerso1() throws Exception {
        String nomPerso3 = "Arthas";
        String nomPerso1 = "Abathur";

        assertEquals(nomPerso3, troisiemePersonnage.getNom());
        assertEquals(nomPerso1, premierPersonnage.getNom());
    }
}
