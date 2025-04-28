import brasserie.Brasserie;
import brasserie.model.Recette;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final String PWD = System.getProperty("user.dir");
        final String SEP = System.getProperty("file.separator");
        final String RECIPES_PATH = PWD + SEP + "src" + SEP + "brasserie" + SEP + "recipes.csv";

        List<Recette> recipeList = new ArrayList<>();

        Brasserie brasserie = new Brasserie("Brasserie R5", 5);

        try {
           recipeList = Recette.readRecipeFromFile(RECIPES_PATH);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        for (Recette r : recipeList){
            System.out.println(r);
        }
    }
}
