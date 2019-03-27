public class Dictionary extends HAshTable {

    public void AddDefinition(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (get(words[i]) != null) {
                System.out.println(words[i] + ": " + get(words[i]) + "\n");
            } else {
                System.out.println(words[i] + ": Not found\n");
            }
        }
    }
}