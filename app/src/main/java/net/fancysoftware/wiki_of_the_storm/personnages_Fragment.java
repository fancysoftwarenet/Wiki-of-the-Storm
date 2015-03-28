package net.fancysoftware.wiki_of_the_storm;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


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
        String nom = "Personnage";
        String histoire = "Histoire";
        String type = "Type";
        if (bundle != null) {
            nom = bundle.getString("nom");
            histoire = bundle.getString("histoire");
            type = bundle.getString("type");
        }

        TextView nomPerso = (TextView)rootview.findViewById(R.id.nom_perso);
        nomPerso.setText(nom);

        TextView typePerso = (TextView)rootview.findViewById(R.id.type_perso);
        typePerso.setText(type);

        TextView histoirePerso = (TextView)rootview.findViewById(R.id.histoire_perso);
        histoirePerso.setText(histoire);

        return rootview;
    }
}
