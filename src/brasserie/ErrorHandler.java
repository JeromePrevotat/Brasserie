package brasserie;
import brasserie.model.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.List;

public class ErrorHandler {
    public static void handleIngredients(List<String> ingredients) throws IllegalArgumentException{
        if (ingredients == null) throw new IllegalArgumentException("Error: Argument <ingredients> cannot be null");
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

    public static void handleCouleurEnum(String s) throws IllegalArgumentException{
        for (Color c : Color.values()) {
            if (c.name().equals(s)) return;
        }
        throw new IllegalArgumentException("Error: Argument <color> does not match any known Color");
    }

    public static void handleDegree(double d) throws IllegalArgumentException{
        if (d < 0) throw new IllegalArgumentException("Error: Argument <degree> cannot be Lesser than Zero");
    }
    
    public static void handlePrix(double p) throws IllegalArgumentException{
        if (p < 0) throw new IllegalArgumentException("Error: Argument <prix> cannot be Lesser than Zero");
    }

    public static void handleCSVArgParsing(String[] args) throws IllegalArgumentException{
        if (args.length < 6) throw new IllegalArgumentException("Error: Recette Expected 6 Arguments but " + args.length + " found");
    }

    public static void handleCSVArgType(String[] args) throws NumberFormatException{
        try{
            Double.valueOf(args[3]);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Error: Argument <degree> cannot be properly converted to a Floating Number value");
        }

        try{
            Double.valueOf(args[4]);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Error: Argument <prix> cannot be properly converted to a Floating Number value");
        }        
    }
}
