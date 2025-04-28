package brasserie;

import brasserie.model.*;
import java.util.ArrayList;
import java.util.List;

public class Brasserie {
    private String nom;
    private int cuves;
    private static List<Recette> RecipeList = new ArrayList<>();

    public Brasserie(String nom, int cuves) {
        this.nom = nom;
        this.cuves = cuves;
    }

    // GETTER
    public String getNom() {
        return this.nom;
    }

    public int getCuves(){
        return this.cuves;
    }

    // SETTER
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCuves(int cuves){
        this.cuves = cuves;
    }

    public Beer brew(Recette recette) {
        return new Beer(
                recette.getCouleur(),
                recette.getNom(),
                recette.getType(),
                recette.getDegree(),
                recette.getPrix(),
                recette.getIngredients()
        );
    }
}