package brasserie.model;

import brasserie.ErrorHandler;

import java.util.List;

public abstract class Beer {
    public String nom;
    public String type;
    public double degree;
    public double prix;
    List<String> ingredients;

    public Beer(String nom, String type, double degree, double prix, List<String>ingredients){
        this.nom = nom;
        this.type = type;
        this.degree = degree;
        this.prix = prix;
        ErrorHandler.handleIngredients(ingredients);
        this.ingredients = ingredients;
    }

    // GETTER
    public String getNom(){
        return this.nom;
    }
    
    public String getType(){
        return this.type;
    }

    public Double getDegree(){
        return this.degree;
    }

    public double getPrix(){
        return this.prix;
    }
    
    public List<String> getIngredients(){
        return this.ingredients;
    }

    // SETTER
    public void setNom(String nom){
        this.nom = nom;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setDegree(double degree){
        this.degree = degree;
    }

    public void setPrix(double prix){
        this.prix = prix;
    }

    public void setIngredients(List<String> ingredients){
        this.ingredients = ingredients;
    }

}
