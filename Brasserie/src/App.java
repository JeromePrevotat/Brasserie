import brasserie.Blonde;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> biereDuDemonIngredients = new ArrayList<>();
        biereDuDemonIngredients.add("Eau");
        biereDuDemonIngredients.add("Malte d'orge");
        biereDuDemonIngredients.add("Maïs");
        biereDuDemonIngredients.add("Riz");
        biereDuDemonIngredients.add("Extraits de Houblon");
        biereDuDemonIngredients.add("Houblon");
        Blonde biereDuDemon = new Blonde("Bière du Démon", "Bière Forte", 12, 3.10, biereDuDemonIngredients);
        System.out.println("\n"+biereDuDemon+"\n");


        List<String> grimBlondeIngredients = new ArrayList<>();
        grimBlondeIngredients.add("Eau");
        grimBlondeIngredients.add("Malte d'orge");
        grimBlondeIngredients.add("Sirop de Glucose");
        grimBlondeIngredients.add("Malte de blé");
        grimBlondeIngredients.add("Caramel aromatique");
        grimBlondeIngredients.add("Extraits de Houblon");
        Blonde grimBlonde = new Blonde("Grimbergen Blonde", "Bière d'abbaye", 6.7, 0.76, grimBlondeIngredients);
        System.out.println("\n"+grimBlonde+"\n");

        List<String> deliriumChristmasIngredients = new ArrayList<>();
        deliriumChristmasIngredients.add("Eau");
        deliriumChristmasIngredients.add("Malte d'orge");
        deliriumChristmasIngredients.add("Houblon");
        deliriumChristmasIngredients.add("Levure");
        Blonde deliriumChristmas = new Blonde("Delirium Christmas", "Bière Triple Forte", 10, 3.15, deliriumChristmasIngredients);
        System.out.println("\n"+deliriumChristmas+"\n");
    }
}
