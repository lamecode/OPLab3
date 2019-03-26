package dictionary;

public class Dictionary {
    private static final int CAPACITY = 64;
    private Node[] table;

    private class Node {

        final int hash;
        final String key;
        String value;
        Node next;

        Node(int hash, String key, String value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public void define(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (get(words[i]) != null) {
                System.out.println(words[i] + ": " + get(words[i]) + "\n");
            } else {
                System.out.println(words[i] + ": Not found\n");
            }
        }
    }

    public void put(String key, String value) {
        int keyHash = key.hashCode();
        Node p = new Node(keyHash, key, value, null);
        if (table == null) {
            table = new Node[CAPACITY];
        }
        int index = keyHash & (CAPACITY - 1);
        if (table[index] == null) {
            table[index] = p;
        } else {
            Node last = table[index];
            while (last.next != null) {
                last = last.next;
            }
            last.next = p;
        }
    }

    public String get(String key) {
        int keyHash = key.hashCode();
        int index = keyHash & (CAPACITY - 1);
        if (table[index].key.equals(key)) {
            return table[index].value;
        } else {
            Node scannedNode = table[index].next;
            while (!scannedNode.key.equals(key)) {
                if (scannedNode.next == null) {
                    return null;
                }
                scannedNode = scannedNode.next;
            }
            return scannedNode.value;
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
