public class Hangman {

    public Hangman() {
        alphabet = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        wordList = new FiniteDictionary();
    }

    public Hangman(FiniteDictionary words) {
        alphabet = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        wordList = new FiniteDictionary();
        blankedOut = new StringBuffer();
        wordList = words;
        count = 1;
        currentWord = "";
    }

    public int chooseLetter(String letter) {
        letter = letter.substring(0, 1); // modifies 'letter' so that it contains only the first char 
        return alphabet.indexOf(letter); // returns -1 if char not found, otherwise returns the index of the letter in the alphabet
    }

    public void modifyAlphabet(int index) {
        if (index < 0 || index > 25); // skips updating if index is out of bounds
        else {
            alphabet.setCharAt(index, '.'); // removes guessed letter from alphabet         
        }
    }

    // dumps wordList to a string
    public String wordListToString() {
        return wordList.toString();
    }

    public void setCurrentWord() {
        currentWord = wordList.getRandomWord();  // updates currentWord
        // make blankedOut have same spaces as current word to guess
        for (int i = 0; i < currentWord.length(); i++) {
            blankedOut.insert(i, "_");
        }
    }

    public boolean evaluateGuess(String guessLetter) {
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.substring(i, i + 1).equalsIgnoreCase(guessLetter)) { //is letter in the word?
                blankedOut.replace(i, i + 1, guessLetter);  // update the game with the added letter                              
            }
        }
        int j = alphabet.indexOf(guessLetter);  // get index of used letter
        if (j > -1 && j < 26) {
            alphabet.replace(j, j + 1, ".");  // replace the guessed letter with a period
        }
        count++;
        if (j == -1) {  // this lets us evaluate whether the letter has already been guessed
            count--;
            return true;
        }
        return false;
    }

    public int getCount() {
        return count;
    }

    public StringBuffer getBlankedOut() {
        return blankedOut;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public String getAlphabet() {
        return alphabet.toString();
    }

    public String getTitle() {
        return title;
    }
    private static final String title = "Word Guess Game";
    private StringBuffer alphabet;
    private FiniteDictionary wordList;
    private StringBuffer blankedOut;
    private int count;
    String currentWord;
}
