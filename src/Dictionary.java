import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Dictionary {
    private static final String INPUT_FILE = "dict_processed.txt";

    public static void main(String[] args) {
        try {
            BufferedReader brand_new = new BufferedReader(new FileReader(INPUT_FILE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner Lab = new Scanner(System.in);
        String word = Lab.nextLine();
    }
}
