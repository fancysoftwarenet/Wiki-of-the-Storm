package net.fancysoftware.wiki_of_the_storm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 13/03/2015.
 */
public class Personnage {
    private int id;
    private String nom;
    private String origine;
    private String histoire;
    private String type;

    public int getID(){ return this.id; }
    public String getOrigine(){ return this.origine; }
    public String getNom(){
        return this.nom;
    }
    public String getHistoire(){
        return this.histoire;
    }
    public String getType(){ return this.type; }

    public ArrayList<Basique> getBasiques() {
        return basique;
    }
    public ArrayList<Heroique> getHeroiques() {
        return heroique;
    }

    private ArrayList<Basique> basique;
    private ArrayList<Heroique> heroique;

    private ArrayList<Trait> traits;

    public ArrayList<Trait> getTraits() { return traits; }

    private ArrayList<Talent> talents;

    public ArrayList<Talent> getTalents() { return talents; }


    public static class PersonnageStatic{
        public static Personnage personnage;

        public static List<Personnage> personnages;
    }
}

class Skill {
    private String nom;
    private String description;

    public String getNom() { return nom; }
    public String getDescription() { return description; }
}

class Basique extends Skill{

}

class Heroique extends Skill{

}

class Talent {
    private int niveau;
    private String nom;
    private String description;

    public int getNiveau() { return niveau; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
}

class Trait {
    private String nom;
    private String description;

    public String getNom() { return nom; }
    public String getDescription() { return description; }
}