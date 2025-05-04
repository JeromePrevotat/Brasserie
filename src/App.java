import brasserie.Brasserie;
import brasserie.model.Beer;
import brasserie.model.Recipe;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String[] args) {
        final String PWD = System.getProperty("user.dir");
        final String SEP = System.getProperty("file.separator");
        final String RECIPES_PATH = PWD + SEP + "src" + SEP + "brasserie" + SEP + "recipes.csv";

        List<Recipe> recipeList = new ArrayList<>();
        
        try {
            Brasserie brasserie = new Brasserie("Brasserie R5", 5);
            recipeList = Recipe.readRecipeFromFile(RECIPES_PATH);
            brasserie.setRecipeList(recipeList);
            // Lancement du brassage Biere du Démon qui doit durer 15sec de manière asynchrone
            CompletableFuture<Beer> test = CompletableFuture.supplyAsync(() -> brasserie.createBrewingDaemon(brasserie.getRecipeList().get(0)));
            // Wait for 5sec to confirm async
            try {
                Thread.sleep(5000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            // Affichage des recettes
            // for (Recipe r : recipeList){
            //     System.out.println(r);
            // }
            // Attente de la fin du brassage
            CompletableFuture.allOf(test).join();
            // Affichage du résultat du brassage
            System.out.println("BEER: " + test.get().toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        

        
    }
}
