package brasserie;

import brasserie.model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

public class Brasserie{
    private String nom;
    private int nbCuves;
    private List<Recipe> recipeList;
    private HashMap<Cuve, Recipe> cuves;

    public Brasserie(String nom, int nbCuves) {
        this.nom = nom;
        this.nbCuves = nbCuves;
        this.recipeList = new ArrayList<>();
        this.cuves = new HashMap<>();
    }

    // GETTER
    public String getNom() {
        return this.nom;
    }

    public int getNbCuves(){
        return this.nbCuves;
    }
    
    public HashMap<Cuve, Recipe> getCuves(){
        return this.cuves;
    }

    public List<Recipe> getRecipeList(){
        return this.recipeList;
    }

    // SETTER
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbCuves(int nbCuves){
        ErrorHandler.handleNbCuves(nbCuves);
        this.nbCuves = nbCuves;
    }

    public void setCuves(HashMap<Cuve, Recipe> cuves){
        ErrorHandler.handleNullCuves(cuves);
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

    private void createBrewingDaemon(int cuve, Recipe r){
        int i = 0;
        // while (i < this.cuves - 1){
        //     i++;
        // }
        Timer daemon = new Timer(true);
        Thread t = new Thread();
        daemon.schedule(null, 0);
    }
}