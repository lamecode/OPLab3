package dictionary;

import java.util.HashMap;

public class Dictionary extends HashMap<String, String> {

    public void define(String word) {
        System.out.println(get(word));

    }

}
