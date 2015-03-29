package net.fancysoftware.wiki_of_the_storm;

import android.app.Fragment;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;


/**
 * Created by Mathieu on 09/03/2015.
 */
public class section2_Fragment extends android.support.v4.app.Fragment{
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        rootview = inflater.inflate(R.layout.section2_layout, container, false);

        LinearLayout listePersonnage = (LinearLayout)rootview.findViewById(R.id.liste_personnages);
        //TextView textView = (TextView)rootview.findViewById(R.id.textViewSection2);

        /*InputStream is = rootview.getResources().openRawResource(R.raw.database);
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder total = new StringBuilder();
        String line = "";
        try {
            line = r.readLine();
            //textView.setText(line);
        }catch (IOException e){
            //textView.setText("Error !");
        }*/

        /*Gson gson = new Gson();
        Type listType = new TypeToken<List<Personnage>>(){}.getType();
        List<Personnage> personnages = (List<Personnage>) gson.fromJson(line, listType);*/
        List<Personnage> personnages = Personnage.PersonnageStatic.personnages;

        //textView.setText("SIZE: " + personnages.size() + "\nExemple: "+personnages.get(0).getNom()+"");

        for (final Personnage personnage : personnages){
            /*Log.d("INFOPERSO", "PERSONNAGE : " + personnage.getNom());
            Log.d("INFOPERSO", "SKILLS : " + personnage.getBasiques().size());*/

            final LinearLayout layoutPersonnage = new LinearLayout(rootview.getContext());
            layoutPersonnage.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250);
            params.setMargins(10, 10, 10, 0);
            layoutPersonnage.setLayoutParams(params);
            //layoutPersonnage.setBackgroundColor(getResources().getColor(R.color.background_date_news));
            layoutPersonnage.setBackgroundColor(Color.parseColor("#090011"));
            layoutPersonnage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutPersonnage.setBackgroundColor(Color.parseColor("#230041"));
                    ((MainActivity)getActivity()).goToPersonnageFragment(personnage);
                    //android.support.v4.app.Fragment objFragment = null;
                    //objFragment = new FragmentPersonnages();
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

        //LinearLayout linearLayoutPersonnages = (LinearLayout)rootview.findViewById(R.id.layout_personnages);

        return rootview;
    }
}

