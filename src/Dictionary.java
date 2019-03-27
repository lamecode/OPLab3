import java.util.HashMap;

public class Dictionary extends HashMap<String, String> {
    public void AddDefinition(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (get(words[i]) == null) {
                System.out.println(words[i] + ": not found" + "\n");
            } else {
                System.out.println(get(words[i]) + "\n");
            }
        }
    }
}