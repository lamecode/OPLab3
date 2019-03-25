package dictionary;

import java.util.HashMap;

public class Dictionary extends HashMap<String, String> {

    public void define(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (get(words[i]) != null) {
                System.out.println(get(words[i]) + "\n");
            } else {
                System.out.println(words[i] + ": Not found\n");
            }
        }
    }

}
