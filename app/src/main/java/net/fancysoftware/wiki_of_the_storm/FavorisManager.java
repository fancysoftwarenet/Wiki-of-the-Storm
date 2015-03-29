package net.fancysoftware.wiki_of_the_storm;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Paul on 29/03/2015.
 */
public class FavorisManager {
    public void WriteFavoris(Context context, Personnage data){
        FileOutputStream fOut = null;
        OutputStreamWriter osw = null;

        try{
            fOut = context.openFileOutput("settings.dat",Context.MODE_APPEND);
            osw = new OutputStreamWriter(fOut);
            osw.write(data.getID() + "|");
            osw.flush();
            // Toast pour afficher l'ajout du favoris
            Toast.makeText(context, "Favoris ajouté", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(context, "Erreur lors de l'ajout",Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                osw.close();
                fOut.close();
            } catch (IOException e) {
                Toast.makeText(context, "Erreur lors de l'ajout",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void ResetFavoris(Context context){
        FileOutputStream fOut = null;
        OutputStreamWriter osw = null;

        try{
            fOut = context.openFileOutput("settings.dat",Context.MODE_PRIVATE);
            osw = new OutputStreamWriter(fOut);
            osw.write("");
            osw.flush();
            // Toast pour afficher l'ajout du favoris
            Toast.makeText(context, "Favoris remis a zéro", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(context, "Erreur lors de l'ajout",Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                osw.close();
                fOut.close();
            } catch (IOException e) {
                Toast.makeText(context, "Erreur lors de l'ajout",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String ReadFavoris(Context context){
        FileInputStream fIn = null;
        InputStreamReader isr = null;

        char[] inputBuffer = new char[255];
        String data = null;

        try{
            fIn = context.openFileInput("settings.dat");
            isr = new InputStreamReader(fIn);
            isr.read(inputBuffer);
            data = new String(inputBuffer);
            // Affiche le contenu des favoris dans un Toast
            //Toast.makeText(context, " "+data,Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            //Toast.makeText(context, "Settings not read",Toast.LENGTH_SHORT).show();
        }
        return data;
    }
}
