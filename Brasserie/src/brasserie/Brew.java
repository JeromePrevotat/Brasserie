package brasserie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Brew {
    String nomBiere = "";
    String type = "";
    double degree = 0;
    double prix = 0;
    List<String> ingredients = new ArrayList<>();

    Beer brewBeer(HashMap<String, Object> b);

    // GETTER
    public String getNomBiere();
    public String getType();
    public double getDegree();
    public double getPrix();
    public List<String> getIngredients();

    // SETTER
    public static void setNomBiere(String n){};
    public static void setType(String t){};
    public static void setDegree(double d){};
    public static void setPrix(double p){};
    public static void setIngredients(List<String> i){};
}
