package brasserie.model;

import java.util.List;

public class Brune extends Beer {
    public final String couleur = "Brune";

    public Brune(String nom, String type, double degree, double prix, List<String> ingredients){
        super(nom, type, degree, prix, ingredients);
    }

    // GETTER
    public String getCouleur(){
        return this.couleur;
    }

    // SETTER
  
    // METHODS
    @Override
    public String toString(){
        return (this.getNom() + "\n" + this.couleur +" Type: " + this.getType() + " Degree: " + this.getDegree() + "°" +
        "\nComposition: " + this.getIngredients().toString() + "\nPrix Unite: " + this.prix);
    }


}
