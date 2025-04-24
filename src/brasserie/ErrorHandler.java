package brasserie;
import java.util.List;

public class ErrorHandler {
    public static void handleIngredients(List<String> ingredients) throws IllegalArgumentException{
        if (ingredients == null) throw new IllegalArgumentException("Error: Argument <ingredients> cannot be null\n");
    }

    public static void handleEmptyString(String s, String argName) throws IllegalArgumentException{
        if (s.equals("")) throw new IllegalArgumentException("Error: The Argument <" + argName + "> cannot be an Empty String");
    }
}
