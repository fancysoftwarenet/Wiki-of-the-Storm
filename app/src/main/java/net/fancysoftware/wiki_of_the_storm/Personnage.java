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

    public String getNom(){
        return this.nom;
    }

    public ArrayList<Basique> getBasiques() {
        return basique;
    }

    private ArrayList<Basique> basique;
    private ArrayList<Heroique> heroique;
}

class Skill {
    private String nom;
    private String description;

    public String getNom() { return nom; }
}

class Basique extends Skill{

}

class Heroique extends Skill{

}