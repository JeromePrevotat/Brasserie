package brasserie.model;

import brasserie.ErrorHandler;
import java.util.List;

public class Beer {
    private Color couleur;
    private String nom;
    private String type;
    private double degree;
    private double prix;
    private List<String> ingredients;

    public Beer(Color couleur, String nom, String type, double degree, double prix, List<String> ingredients) {
        this.couleur = couleur;
        ErrorHandler.handleEmptyString(nom, "nom");
        this.nom = nom;
        this.type = type;
        this.degree = degree;
        this.prix = prix;
        ErrorHandler.handleIngredients(ingredients);
        this.ingredients = ingredients;
    }

    // GETTERS
    public String getNom() {
        return this.nom;
    }

    public String getType() {
        return this.type;
    }

    public double getDegree() {
        return this.degree;
    }

    public double getPrix() {
        return this.prix;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public Color getCouleur() {
        return this.couleur;
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

    public void setCouleur(Color couleur) {
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