package brasserie;

import brasserie.model.*;
import java.util.ArrayList;
import java.util.List;

public class Brasserie {
    private String nom;
    private int cuves;
    private List<Recipe> recipeList = new ArrayList<>();

    public Brasserie(String nom, int cuves, List<Recipe>recipeList) {
        this.nom = nom;
        ErrorHandler.handleNbCuves(cuves);
        this.cuves = cuves;
        ErrorHandler.handleNullRecipeList(recipeList);
        this.recipeList = recipeList;
    }

    // GETTER
    public String getNom() {
        return this.nom;
    }

    public int getCuves(){
        return this.cuves;
    }

    public List<Recipe> getRecipeList(){
        return this.recipeList;
    }

    // SETTER
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCuves(int cuves){
        this.cuves = cuves;
    }

    public void getRecipeList(List<Recipe> recipeList){
        this.recipeList = recipeList;
    }


    // METHODS
    public Beer brew(Recipe recette) {
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