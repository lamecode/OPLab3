package dictionary;

public class Dictionary {
    private int capacity = 16;
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
        put(key, value, table);
    }

    private void put(String key, String value, Node[] table) {
        Node node = new Node(hash(key), key, value, null);
        if (this.table == null) {
            this.table = table = new Node[capacity];
        }

        if (table[node.hash] == null) {
            table[node.hash] = node;
        } else {
            Node last = table[node.hash];
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }

        if (needToResize(table)) {
            rearrangeTable();
        }
    }

    public String get(String key) {
        if (table[hash(key)] == null) return null;
        Node scannedNode = table[hash(key)];
        while (!scannedNode.key.equals(key)) {
            if (scannedNode.next == null) {
                return null;
            }
            scannedNode = scannedNode.next;
        }
        return scannedNode.value;
    }

    private int hash(String key) {
        int hash = key.hashCode() & (capacity - 1);
        return hash;
    }

    private boolean needToResize(Node[] table) {
        int size = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                size++;
            }
        }
        if (size > table.length * 0.8) {
            return true;
        }
        return false;
    }

    private void rearrangeTable() {
        capacity = table.length * 2;
        Node[] enlargedTable = new Node[capacity];
        System.out.println("Table (" + table.length + ") -> enlargedTable (" + enlargedTable.length + ")"); // for debugging purposes
        for (int i = 0; i < table.length; i++) {
            Node transferredNode = table[i];
            if (transferredNode != null) {
                put(transferredNode.key, transferredNode.value, enlargedTable);
                while (transferredNode.next != null) {
                    transferredNode = transferredNode.next;
                    put(transferredNode.key, transferredNode.value, enlargedTable);
                }
            }
        }
        table = enlargedTable;
    }

}
