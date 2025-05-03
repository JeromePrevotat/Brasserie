package brasserie;

import brasserie.model.Beer;
import brasserie.model.Recipe;
import java.time.Instant;

public class Cuve implements Runnable {
    private Recipe brewingRecipe;
    private long start;
    private Beer beer;

    public Cuve(){
        this.brewingRecipe = null;
        this.beer = null;
    }

    // GETTER
    public Recipe getBrewingRecipe() {
        return this.brewingRecipe;
    }

    public Beer getBeer() {
        return this.beer;
    }

    public long getStart() {
        return this.start;
    }

    // SETTER
    public void setBrewingRecipe(Recipe brewingRecipe) {
        this.brewingRecipe = brewingRecipe;
    }

    public void setBeer(Beer b){
        this.beer = b;
    }

    public void setStart(long s){
        this.start = s;
    }


    // METHODS
    public Beer brewing(){
        this.start = Instant.now().getEpochSecond();
        while (Instant.now().getEpochSecond() < (this.start + (this.brewingRecipe.getBrewingTime() * 1000))){
            // BREWING
        }
        return brew(this.brewingRecipe);
    }

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

    public void resetCuve(){
        this.beer = null;
        this.brewingRecipe = null;
        this.start = 0;
    }

}
