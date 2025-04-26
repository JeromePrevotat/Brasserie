package brasserie;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.List;

public class ErrorHandler {
    public static void handleIngredients(List<String> ingredients) throws IllegalArgumentException{
        if (ingredients == null) throw new IllegalArgumentException("Error: Argument <ingredients> cannot be null\n");
    }

    public static void handleEmptyString(String s, String argName) throws IllegalArgumentException{
        if (s.equals("")) throw new IllegalArgumentException("Error: The Argument <" + argName + "> cannot be an Empty String");
    }

    public static void handleFileNotFound(File f) throws FileNotFoundException{
        if (!(f.exists())) throw new FileNotFoundException("Error: No such File or Directory");
    }

    public static void handleFileReadRight(File f) throws AccessDeniedException{
        if (!(f.canRead())) throw new AccessDeniedException("Error: You don't have Read Permission for this File");
    }
}
