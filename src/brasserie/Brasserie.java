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

    public Beer brew(Recette recette) {
        return new Beer(
                recette.getCouleur(),
                recette.getNom(),
                recette.getType(),
                recette.getDegree(),
                recette.getPrix(),
                recette.getIngredients()
        );
    }
}