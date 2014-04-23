import java.util.Scanner;
//code used from Kenton Standard, Apparently used from Micah Gustin.
public class Homework1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FiniteDictionary myWords = new FiniteDictionary();
        // define dictionary
        myWords.populate(0, "statue");
        myWords.populate(1, "flamingo");
        myWords.populate(2, "meteor");
        myWords.populate(3, "children");
        myWords.populate(4, "whittle");
        myWords.populate(5, "thoughtful");
        myWords.populate(6, "embarrassed");
        myWords.populate(7, "knowingly");
        myWords.populate(8, "heroic");
        myWords.populate(9, "describe");
        myWords.populate(10, "ostrich");
        myWords.populate(11, "America");
        myWords.populate(12, "evening");
        myWords.populate(13, "loyalty");
        myWords.populate(14, "volume");
        myWords.populate(15, "leprechaun");
        myWords.populate(16, "lollipop");
        myWords.populate(17, "belittle");
        myWords.populate(18, "following");
        myWords.populate(19, "glowworm");
        myWords.populate(20, "hillbilly");
        myWords.populate(21, "neighborhood");
        myWords.populate(22, "requirement");
        myWords.populate(23, "aquarium");
        myWords.populate(24, "statement");
        myWords.populate(25, "juniper");
        myWords.populate(26, "iterate");
        myWords.populate(27, "umbrella");
        myWords.populate(28, "countless");
        myWords.populate(29, "harbor");

        // initialize game
        Hangman game1 = new Hangman(myWords);

        // print welcome        
        System.out.println();
        System.out.println("*****************************************");
        System.out.print("*     ");
        System.out.println("Welcome to the " + game1.getTitle() + "    *");
        System.out.println("*" + "           (c) Micah Gustin            *");
        System.out.println("*****************************************");

        char control;
        String guessLetter = "";
        boolean alreadyGuessed;
        // loop goes until the user does not want to play 
        do {
            game1.setCurrentWord(); // resets to new guessing word
            System.out.println(".for.testing........(computer got: " + game1.getCurrentWord() + ")");
            System.out.println(); //spacer
            // loop goes until word is guessed
            do {
                System.out.print("Guess this word: " + game1.getBlankedOut().toString());
                System.out.println("                 Unused Letters: " + game1.getAlphabet().toString());
                System.out.print("[" + game1.getCount() + "] " + "Guess a letter: ");
                guessLetter = scanner.next();
                System.out.println(); // spacer
                if (guessLetter.substring(0, 1) == null) {
                    guessLetter = "1";  // if pointer is null set value to 1, to prompt user to re type data
                } else {
                    guessLetter = guessLetter.substring(0, 1);  // formats string to first char only
                }
                if (guessLetter.charAt(0) < 65 || guessLetter.charAt(0) > 122 || (guessLetter.charAt(0) > 90 && guessLetter.charAt(0) < 97)) {
                    do {
                        System.out.print("Not a valid letter, please choose again: ");
                        guessLetter = scanner.next();
                        System.out.println();
                    } while (guessLetter.charAt(0) < 65 || guessLetter.charAt(0) > 122 || (guessLetter.charAt(0) > 90 && guessLetter.charAt(0) < 97));
                }
                alreadyGuessed = game1.evaluateGuess(guessLetter);
                if (alreadyGuessed == true) {
                    System.out.println("'" + guessLetter + "'" + "has already been guessed");
                    System.out.println();
                }
            } while (!game1.getCurrentWord().equalsIgnoreCase(game1.getBlankedOut().toString()));

            System.out.println(game1.getCurrentWord() + ": you got it with " + (game1.getCount() - 1) + " guesses");
            System.out.println(); // spacer
            System.out.print("Do you want to play another game? [Y/N]: ");
            control = scanner.next().charAt(0); // gets first char typed
            System.out.println(); // spacer
            // checks for valid input
            while (control != 'y' && control != 'Y' && control != 'n' && control != 'N') {
                System.out.println(); // spacer
                System.out.println(); // spacer
                System.out.print("Invalid input, please enter a 'y' or a 'n': ");
                control = scanner.next().charAt(0);
            }
            if (control == 'y' || control == 'Y') {
                game1 = new Hangman(myWords);
            }
        } while (control == 'y' || control == 'Y');
    }
}
