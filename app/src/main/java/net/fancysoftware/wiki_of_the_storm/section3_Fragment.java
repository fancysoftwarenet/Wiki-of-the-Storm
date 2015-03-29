package net.fancysoftware.wiki_of_the_storm;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mathieu on 09/03/2015.
 */
public class section3_Fragment extends android.support.v4.app.Fragment{
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        rootview = inflater.inflate(R.layout.section2_layout, container, false);

        LinearLayout listePersonnage = (LinearLayout)rootview.findViewById(R.id.liste_personnages);
        List<Personnage> personnages = Personnage.PersonnageStatic.personnages;

        ArrayList<String> listeFavoris = new ArrayList<String>();

        FavorisManager fm = new FavorisManager();
        String favoris = fm.ReadFavoris(rootview.getContext()).trim().replace('\u0000', ' ').trim();
        String[] favorisArray = favoris.split("|");
        for (int i = 0; i < favorisArray.length; i++){
            if(favorisArray[i].matches("\\d")){
                listeFavoris.add(favorisArray[i]);
            }
        }

        for (final Personnage personnage : personnages){
            if (listeFavoris.contains(personnage.getID() + "")) {
                final LinearLayout layoutPersonnage = new LinearLayout(rootview.getContext());
                layoutPersonnage.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250);
                params.setMargins(10, 10, 10, 0);
                layoutPersonnage.setLayoutParams(params);
                layoutPersonnage.setBackgroundColor(Color.parseColor("#090011"));
                layoutPersonnage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        layoutPersonnage.setBackgroundColor(Color.parseColor("#230041"));
                        ((MainActivity) getActivity()).goToPersonnageFragment(personnage);
                    }

                });

                TextView personnageName = new TextView(rootview.getContext());
                personnageName.setText(personnage.getNom());
                personnageName.setTextColor(Color.WHITE);
                personnageName.setShadowLayer(7, 3, 3, Color.parseColor("#65d2fb"));
                personnageName.setTextSize(1, 22);
                layoutPersonnage.addView(personnageName);

                listePersonnage.addView(layoutPersonnage);
            }
        }

        return rootview;
    }
}

