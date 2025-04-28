package brasserie.model;
import brasserie.ErrorHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Recette {

    private Couleur couleur;
    private String nom;
    private String type = "";
    private double degree;
    private double prix;
    private List<String> ingredients;

    public Recette(Couleur couleur, String nom, String type, double degree, double prix, List<String> ingredients){
        ErrorHandler.handleCouleurEnum(couleur.name());
        this.couleur = couleur;
        ErrorHandler.handleEmptyString(nom, "nom");
        this.nom = nom;
        this.type = type;
        ErrorHandler.handleDegree(degree);
        this.degree = degree;
        ErrorHandler.handleDegree(prix);
        this.prix = prix;
        ErrorHandler.handleIngredients(ingredients);
        this.ingredients = ingredients.stream()
                                .collect(Collectors.toList());
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
        ErrorHandler.handleCouleurEnum(couleur.name());
        this.couleur = couleur;
    }

    public void setNom(String nom) {
        ErrorHandler.handleEmptyString(nom, "nom");
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDegree(double degree) {
        ErrorHandler.handleDegree(degree);
        this.degree = degree;
    }

    public void setPrix(double prix) {
        ErrorHandler.handleDegree(prix);
        this.prix = prix;
    }

    public void setIngredients(List<String> ingredients) {
        ErrorHandler.handleIngredients(ingredients);
        this.ingredients = ingredients;
    }

    // METHODS
    public static List<Recette> readRecipeFromFile(String fPath) throws Exception {
        List<Recette> recipeList = new ArrayList<>();
        File f = new File(fPath);
        String[] args;
        List<String> ingredients = new ArrayList<>();

        ErrorHandler.handleFileNotFound(f);
        ErrorHandler.handleFileReadRight(f);

        try (Scanner fileReader = new Scanner(f)) {
            while (fileReader.hasNextLine()){
                // GNL
                String line = fileReader.nextLine();
                args = line.split(",");
                // Reset iterators
                System.out.println("ING: " + ingredients);
                ingredients.clear();
                System.out.println("CLEARED ING: " + ingredients);
                int i = 5;
                // Get Ingredients as List
                while (i < args.length){
                    ingredients.add(args[i]);
                    i++;
                }
                System.out.println("NEW ING: " + ingredients);
                // Handles Errror
                ErrorHandler.handleCSVArgParsing(args);
                ErrorHandler.handleCSVArgType(args);
                // Create New Recipe
                recipeList.add(new Recette(Couleur.valueOf(args[0]), args[1], args[2], Double.parseDouble(args[3]), Double.parseDouble(args[4]), ingredients));
                System.out.println("RLIST: " + recipeList.toString());
            }
        }
        return recipeList;
    }

    @Override
    public String toString(){
        String s;
        s = "Recette de " + this.nom + "\nCouleur: " + this.couleur + " " + this.type + "\nDegré: " + this.degree + "\nPrix: " + this.prix + "\nComposition: " + this.ingredients.toString() + "\n";
        return s;
    }
}
