import brasserie.Brasserie;
import brasserie.model.Beer;
import brasserie.model.Couleur;
import brasserie.model.Recette;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final String PWD = System.getProperty("user.dir");
        final String SEP = System.getProperty("file.separator");
        final String RECIPES_PATH = PWD + SEP + "src" + SEP + "brasserie" + SEP + "recipes.csv";

        Brasserie brasserie = new Brasserie("Brasserie R5", 5);

        try {
            // Create New Recipe
            Recette recetteBiereDuDemon = new Recette(
                    Couleur.BLONDE,
                    "Bière du Démon",
                    "Bière Forte",
                    12,
                    3.10,
                    List.of(
                            "Eau",
                            "Malte d'orge",
                            "Maïs",
                            "Riz",
                            "Extraits de Houblon",
                            "Houblon"
                    )
            );

            // Brew the Beer from the Recipe
            Beer biereDuDemon = brasserie.brew(recetteBiereDuDemon);

            // Serve the Beer
            System.out.println("\n" + biereDuDemon + "\n");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Recette.readRecipeFromFile(RECIPES_PATH);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
