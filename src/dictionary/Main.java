package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String INPUT_FILE = "dict_processed.txt";

    public static void main(String[] args) {
        Dictionary dictionary = createDictionaryHashMap();
        String userInput = getUserInput();
        dictionary.define(userInput);
    }

    private static Dictionary createDictionaryHashMap() {
        Dictionary dictionary = new Dictionary();

        try {
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.put(line.substring(0, line.indexOf(";")), line.substring(line.indexOf(";") + 2));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    private static String getUserInput() {
        System.out.println("Enter word to define...");
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            userInput = scanner.nextLine();
        } else {
            System.out.println("Invalid input");
        }
        scanner.close();
        return userInput.toUpperCase();
    }


}