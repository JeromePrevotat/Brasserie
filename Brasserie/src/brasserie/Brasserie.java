package brasserie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import brasserie.Brew;

public class Brasserie implements Brew{
    public String nom;

    public Brasserie(String nom){
        this.nom = nom;
    }

    // GETTER
    public String getNom(){
        return this.nom;
    }

    // SETTER
    public void setNom(String nom){
        this.nom = nom;
    }

    // METHODS
    @Override
    public Beer brewBeer(HashMap<String, Object> b){
       // recup les attributs
       b.forEach((key, value) -> {
        switch (key){
            case "nom":
                Brew.setNomBiere((value) -> {
                    Brew.nomBiere = (String) value;
                });

            case "type":
                type = (String)value;
            
            case "degree":
                degree = (double)value;
            
            case "prix":
                prix = (double)value;

            case "ingredients":
                ingredients = (List<String>)value;
        }
    });

    // Appelle le bon constructeur
    switch ((String)b.get("couleur")) {
        case "Ambree":
            return new Ambree(nomBiere, type, degree, prix, ingredients);
        case "Blanche":
            return new Blanche(nomBiere, type, degree, prix, ingredients);
        case "Blonde":
            return new Blonde(nomBiere, type, degree, prix, ingredients);
        case "Brune":
            return new Brune(nomBiere, type, degree, prix, ingredients);
        case "Noire":
            return new Noire(nomBiere, type, degree, prix, ingredients);
        case "Rousse":
            return new Rousse(nomBiere, type, degree, prix, ingredients);
        default:
            throw new AssertionError();
    }
}
