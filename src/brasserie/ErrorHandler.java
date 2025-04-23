package brasserie;
import java.util.List;

public class ErrorHandler {
    public static void handleIngredients(List<String> ingredients) throws IllegalArgumentException{
        System.out.println("HANDLER");
        if (ingredients == null){
            System.err.println("IF");
            throw new IllegalArgumentException("Error: Argument <ingredients> cannot be null\n");
        }
    }

}
