import java.util.*;

public class FiniteDictionary {

    // intitializes a new empty array list of size MAX_CAPACITY and defaults lastIndexUsed
    public FiniteDictionary() {
        this.dictionary = new ArrayList(MAX_CAPACITY);
        this.lastIndexUsed = -1;
    }

    public String getRandomWord() {
        Random indexer = new Random();
        int temp = indexer.nextInt(MAX_CAPACITY);

        // ensures no word repeats in game
        while (temp == lastIndexUsed) {
            temp = indexer.nextInt(MAX_CAPACITY);
        }
        lastIndexUsed = temp; // updates lastIndexUsed
        if (dictionary.get(temp) != null) {
            return dictionary.get(temp);
        } else {
            return null;
        }
    }

    // dumps dictionary contents
    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (dictionary.get(i) != null) {
                temp = temp + dictionary.get(i) + " ";
            }
        }
        return temp;
    }

    // allows filling of the dictionary
    public void populate(int index, String input) {
        if (index < MAX_CAPACITY) // make sure bounds are followed
        {
            dictionary.add(index, input);
        }
    }

    public static int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }
    
    private ArrayList<String> dictionary;
    private int lastIndexUsed;
    private static final int MAX_CAPACITY = 30;
}
