package brasserie.model;

import brasserie.ErrorHandler;
import java.util.List;

public class Beer {
    private Couleur couleur;
    private String nom;
    private String type;
    private double degree;
    private double prix;
    private List<String> ingredients;

    public Beer(Couleur couleur, String nom, String type, double degree, double prix, List<String> ingredients) {
        this.couleur = couleur;
        this.nom = nom;
        this.type = type;
        this.degree = degree;
        this.prix = prix;
        ErrorHandler.handleIngredients(ingredients);
        this.ingredients = ingredients;
    }

    // GETTERS
    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public double getDegree() {
        return degree;
    }

    public double getPrix() {
        return prix;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    // SETTERS
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    // METHODS
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.getNom()).append(" (").append(this.getCouleur()).append(")\n")
          .append("Type: ").append(this.getType())
          .append(" (").append(this.getDegree()).append("°)\n")
          .append("Composition: ").append(this.getIngredients().toString())
          .append("\nPrix Unite: ").append(this.prix);

        return sb.toString();
    }
}