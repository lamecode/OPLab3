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



/*
    @Override
    public String toString() { //view only the keys
        String toStr = "{\n";
        for (int i = 0; i < CAPACITY; i++) {
            String list = "(" + table[i].key;
            Node last = table[i];
            while (last.next != null) {
                last = last.next;
                list += " |-> " + last.key;
            }
            list += ")";
            toStr += list + "\n";
        }
        toStr += "}";
        return toStr;
    }
*/
}