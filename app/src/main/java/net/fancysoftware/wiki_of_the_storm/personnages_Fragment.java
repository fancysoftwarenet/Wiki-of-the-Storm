package net.fancysoftware.wiki_of_the_storm;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by Mathieu on 09/03/2015.
 */
public class personnages_Fragment extends android.support.v4.app.Fragment{
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        rootview = inflater.inflate(R.layout.personnages_layout, container, false);

        Bundle bundle = this.getArguments();
        String nom = Personnage.PersonnageStatic.personnage.getNom();
        String origine = Personnage.PersonnageStatic.personnage.getOrigine();
        String type = Personnage.PersonnageStatic.personnage.getType();
        String histoire = Personnage.PersonnageStatic.personnage.getHistoire();
        ArrayList<Basique> basiques = Personnage.PersonnageStatic.personnage.getBasiques();
        ArrayList<Heroique> heroiques = Personnage.PersonnageStatic.personnage.getHeroiques();

        TextView nomPerso = (TextView)rootview.findViewById(R.id.nom_perso);
        nomPerso.setText(nom);

        TextView originePerso = (TextView)rootview.findViewById(R.id.origine_perso);
        originePerso.setText(getResources().getString(R.string.origine) + ": " + origine);

        TextView typePerso = (TextView)rootview.findViewById(R.id.type_perso);
        typePerso.setText(getResources().getString(R.string.type) + ": " + type);

        TextView histoirePerso = (TextView)rootview.findViewById(R.id.histoire_perso);
        histoirePerso.setText(histoire);

        for (int i = 0; i < basiques.size(); i++){
            LinearLayout linearLayoutBasqiue = (LinearLayout)rootview.findViewById(R.id.skillsbasiques);

            TextView basiquePerso = new TextView(rootview.getContext());
            basiquePerso.setText("   - " + basiques.get(i).getNom());
            basiquePerso.setTextColor(Color.parseColor("#8eb1bc"));

            linearLayoutBasqiue.addView(basiquePerso);
        }

        for (int i = 0; i < heroiques.size(); i++){
            LinearLayout linearLayoutHeroique = (LinearLayout)rootview.findViewById(R.id.skillsheroiques);

            TextView heroiquePerso = new TextView(rootview.getContext());
            heroiquePerso.setText("   - " + heroiques.get(i).getNom());
            heroiquePerso.setTextColor(Color.parseColor("#8eb1bc"));

            linearLayoutHeroique.addView(heroiquePerso);
        }

        return rootview;
    }
}