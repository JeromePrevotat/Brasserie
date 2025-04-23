import brasserie.Brasserie;
import brasserie.model.Beer;
import brasserie.model.Couleur;
import brasserie.model.Recette;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Brasserie brasserie = new Brasserie("Brasserie R5");

        try {
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
            Beer biereDuDemon = brasserie.brew(recetteBiereDuDemon);
            System.out.println("\n" + biereDuDemon + "\n");
        } catch (IllegalArgumentException e) {
            // System.err.println(e.getMessage());
            System.err.println("CRASH");
        }

        
        

        Recette test = new Recette(
                Couleur.BLONDE,
                "test",
                "Bière Forte",
                12,
                3.10,
                null
        );
        Beer t = brasserie.brew(test);
        System.out.println("\n" + t + "\n");        
    }
}
