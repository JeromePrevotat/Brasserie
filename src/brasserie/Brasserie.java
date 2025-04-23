package brasserie;

import brasserie.model.*;

import java.util.List;

public class Brasserie {
    private String nom;

    public Brasserie(String nom) {
        this.nom = nom;
    }

    // GETTER
    public String getNom() {
        return this.nom;
    }

    // SETTER
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode dédiée à la création de bière
    private Beer brew(String couleur, String nom, String type, double degree, double prix, List<String> ingredients) {
        return switch (couleur) {
            case "Ambree" -> new Ambree(nom, type, degree, prix, ingredients);
            case "Blanche" -> new Blanche(nom, type, degree, prix, ingredients);
            case "Blonde" -> new Blonde(nom, type, degree, prix, ingredients);
            case "Brune" -> new Brune(nom, type, degree, prix, ingredients);
            case "Noire" -> new Noire(nom, type, degree, prix, ingredients);
            case "Rousse" -> new Rousse(nom, type, degree, prix, ingredients);
            default -> throw new IllegalArgumentException("Couleur de bière inconnue : " + couleur);
        };
    }
}