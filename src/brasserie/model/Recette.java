package brasserie.model;
import brasserie.ErrorHandler;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Recette {

    private Couleur couleur;
    private String nom;
    private String type;
    private double degree;
    private double prix;
    private List<String> ingredients;

    public Recette(Couleur couleur, String nom, String type, double degree, double prix, List<String> ingredients){
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
    public Couleur getCouleur() {
        return couleur;
    }

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

    // SETTERS
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

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

    // METHODS
    public static Recette readRecipeFromFile(String fPath) throws Exception {
        File f = new File(fPath);
        String[] args;
        ErrorHandler.handleFileNotFound(f);
        ErrorHandler.handleFileReadRight(f);

        try (Scanner fileReader = new Scanner(f)) {
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                args = line.split(",");
                System.out.println(Arrays.toString(args));
            }
        }
        return null;
    }
}
