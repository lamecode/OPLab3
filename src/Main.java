import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String INPUT_FILE = "dict_processed.txt";

    public static void main(String[] args) {
        Dictionary dictionary = creatingDictionary();
        String word = UserInput();
        dictionary.AddDefinition(word);
    }

    public static Dictionary creatingDictionary(){
        Dictionary dictionary = new Dictionary();
        try {
            BufferedReader brand_new = new BufferedReader(new FileReader(INPUT_FILE));
            String line;
            while ((line = brand_new.readLine()) != null) {
                dictionary.put(line.substring(0,line.indexOf(";")), line.substring(line.indexOf(";")+ 2));
            }
            brand_new.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public static String UserInput() {
        Scanner Lab = new Scanner(System.in);
        System.out.println("Enter your words");
        String word = "";
        if (Lab.hasNextLine()) {
            word = Lab.nextLine();
        } else {
            System.out.println("Invalid input");
        }

        return word.toUpperCase();
    }

}

