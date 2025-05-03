package brasserie.model;
import brasserie.ErrorHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Recipe {

    private Color couleur;
    private String nom;
    private String type = "";
    private double degree;
    private double prix;
    private List<String> ingredients;

    public Recipe(Color couleur, String nom, String type, double degree, double prix, List<String> ingredients){
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
    public Color getCouleur() {
        return this.couleur;
    }

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

    // SETTERS
    public void setCouleur(Color couleur) {
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
    public static List<Recipe> readRecipeFromFile(String fPath) throws Exception {
        List<Recipe> recipeList = new ArrayList<>();
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
                ingredients.clear();
                int i = 5;
                // Get Ingredients as List
                while (i < args.length){
                    ingredients.add(args[i]);
                    i++;
                }
                // Handles Errror
                ErrorHandler.handleCSVArgParsing(args);
                ErrorHandler.handleCSVArgType(args);
                // Create New Recipe
                recipeList.add(new Recipe(Couleur.valueOf(args[0]), args[1], args[2], Double.parseDouble(args[3]), Double.parseDouble(args[4]), ingredients));
            }
        }
        return recipeList;
    }

    public static boolean writeRecipeFromFile(Recipe r, String fPath) throws Exception {
        try {
            ErrorHandler.handleNullString(fPath);
            ErrorHandler.handleNullRecipe(r);
            File f = new File(fPath);
            ErrorHandler.handleFileNotFound(f);
            ErrorHandler.handleFileWriteRight(f);
        } catch (FileNotFoundException | NullPointerException | AccessDeniedException e) {
            System.err.println(e.getMessage());
        }
        try (FileWriter fw = new FileWriter(fPath,true)){
            StringBuilder sb = new StringBuilder();
            sb.append(r.couleur).append(",")
                    .append(r.nom).append(",")
                    .append(r.type).append(",")
                    .append(r.degree).append(",")
                    .append(r.prix).append(",")
                    .append(r.ingredients.toString()
                        .replace(" ", "")
                        .replace("[", "")
                        .replace("]", ""))
                    .append("\n");
            fw.write(sb.toString());
        }
        return true;
    }

    @Override
    public String toString(){
        String s;
        s = "Recette de " + this.nom + "\nCouleur: " + this.couleur + " " + this.type + "\nDegré: " + this.degree + "\nPrix: " + this.prix + "\nComposition: " + this.ingredients.toString() + "\n";
        return s;
    }
}
