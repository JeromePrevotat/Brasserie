package brasserie;

import brasserie.model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Brasserie{
    private String nom;
    private int nbCuves;
    private List<Recipe> recipeList;
    private HashMap<Cuve, Recipe> cuves;

    public Brasserie(String nom, int nbCuves) {
        this.nom = nom;
        this.nbCuves = nbCuves;
        this.recipeList = new ArrayList<>();
        this.cuves = new HashMap<>(nbCuves);
        initCuves();
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
    private void initCuves(){
        int i = 0;
        while (i < this.nbCuves){
            this.cuves.put(new Cuve(), null);
            i++;
        }
    }

    public boolean freeCuve(){
        for (Cuve c : this.cuves.keySet()){
            if (this.cuves.get(c) == null) return true;
        }
        return false;
    }

    private Beer createBrewingDaemon(Recipe r){
        if (freeCuve()){
            for (Cuve c : this.cuves.keySet()){
                if (this.cuves.get(c) == null){
                    c.setBrewingRecipe(r);;
                    CompletableFuture<Beer> futureBeer = CompletableFuture.supplyAsync(() -> c.brewing());
                    try{
                        Beer b = futureBeer.get();
                        c.resetCuve();
                        return b;
                    } catch (InterruptedException | ExecutionException e){
                    System.err.println(e.getMessage());
                    }
                }
            }
        }
        return null;
    }

}