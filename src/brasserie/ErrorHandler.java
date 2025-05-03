package brasserie;
import brasserie.model.Color;
import brasserie.model.Recipe;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.List;

public class ErrorHandler {
    public static boolean handleIngredients(List<String> ingredients) throws IllegalArgumentException{
        if (ingredients == null) throw new IllegalArgumentException("Error: Argument <ingredients> cannot be null");
        return false;
    }

    public static boolean handleEmptyString(String s, String argName) throws IllegalArgumentException{
        if (s.equals("")) throw new IllegalArgumentException("Error: The Argument <" + argName + "> cannot be an Empty String");
        return false;
    }

    public static boolean handleFileNotFound(File f) throws FileNotFoundException{
        if (!(f.exists())) throw new FileNotFoundException("Error: No such File or Directory");
        return false;
    }

    public static boolean handleFileReadRight(File f) throws AccessDeniedException{
        if (!(f.canRead())) throw new AccessDeniedException("Error: You don't have Read Permission for this File");
        return false;
    }

    public static boolean handleFileWriteRight(File f) throws AccessDeniedException{
        if (!(f.canWrite())) throw new AccessDeniedException("Error: You don't have Read Permission for this File");
        return false;
    }

    public static boolean handleCouleurEnum(String s) throws IllegalArgumentException{
        for (Color c : Color.values()) {
            if (c.name().equals(s)) return false;
        }
        throw new IllegalArgumentException("Error: Argument <color> does not match any known Color");
    }

    public static boolean handleDegree(double d) throws IllegalArgumentException{
        if (d < 0) throw new IllegalArgumentException("Error: Argument <degree> cannot be Lesser than Zero");
        return false;
    }
    
    public static boolean handlePrix(double p) throws IllegalArgumentException{
        if (p < 0) throw new IllegalArgumentException("Error: Argument <prix> cannot be Lesser than Zero");
        return false;
    }

    public static boolean handleCSVArgParsing(String[] args) throws IllegalArgumentException{
        if (args.length < 6) throw new IllegalArgumentException("Error: Recette Expected 6 Arguments but " + args.length + " found");
        return false;
    }

    public static boolean handleCSVArgType(String[] args) throws NumberFormatException{
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
        return false;     
    }

    public static boolean handleNullString(String s) throws NullPointerException{
        if (s == null) throw new NullPointerException("Error: Argument type of <String> cannot be null");
        return false;
    }

    public static boolean handleNullRecipe(Recipe r) throws NullPointerException{
        if (r == null) throw new NullPointerException("Error: Argument type of <Recipe> cannot be null");
        return false;
    }

    public static boolean handleNbCuves(int nbCuves){
        if (nbCuves <= 0) throw new IllegalArgumentException("Error: Argument <cuves> must be Greater then Zero");
        return true;
    }



}
