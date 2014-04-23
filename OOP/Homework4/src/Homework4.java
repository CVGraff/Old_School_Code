// Arcade of 3 games using design patterns
// Look at the game history and game stats
// To see what are the design patterns
import java.util.*;

public class Homework4 {
    public static int hangmanCount = 0;
    public static int baseballCount = 0;
    public static int tictactoeCount = 0;
    
    // Creates array for scores
    static ArrayList<Double> hangmanList = new ArrayList<Double>();
    static ArrayList<Double> baseballList = new ArrayList<Double>();
    static ArrayList<Double> tictactoeList = new ArrayList<Double>();
    
    // Creates array for history
    static ArrayList<String> gameHistory = new ArrayList<String>();
    
    public static void main(String[] args) {
        boolean game = true;
        
        while (game) {
            // Main menu
            System.out.println("Welcome to Kenton Standard's Arcade");
            System.out.println("------------ Main menu ------------");
            System.out.println("1: Hangman");
            System.out.println("2: Baseball");
            System.out.println("3: Tic-Tac-Toe");
            System.out.println("4: Exit");
            System.out.println("-----------------------------------");
            System.out.print("What would you like to do? ");

            // User input
            Scanner scanNumber = new Scanner(System.in);
            String gameChoice = scanNumber.nextLine();

            // User's choice
            switch(gameChoice) {
                case "1":
                    System.out.println("Hangman selected!\n");
                    new Homework1();
                    break;
                case "2":
                    System.out.println("Baseball selected!\n");
                    new Homework2();
                    break;
                case "3":
                    System.out.println("Tic-Tac-Toe selected!\n");
                    new Homework3();
                    break;
                case "4":
                    // Reads from the array of hangman scores
                    for (double scr : hangmanList) {
                        Homework1.hangmanAverage += scr;
                    }
                    // Average of the scores
                    Homework1.hangmanAverage = Homework1.hangmanAverage / hangmanList.size();
                    
                    // Reads from the array of baseball scores
                    for (double scr : baseballList) {
                        Homework2.baseballAverage += scr;
                    }
                    // Average of the scores
                    Homework2.baseballAverage = Homework2.baseballAverage / baseballList.size();
                    
                    // Reads from the array of tictactoe scores
                    for (double scr : tictactoeList) {
                        Homework3.tictactoeAverage += scr;
                    }
                    // Average of the scores
                    Homework3.tictactoeAverage = Homework3.tictactoeAverage / tictactoeList.size();
                    
                    System.out.println("Thanks for playing! Please play again soon.");
                    System.out.println("----------- Game History -----------");
                    // Based on the Factory method pattern
                    for (int i = 0; i < gameHistory.size(); i++) {
                        System.out.print(i+1 + " ");
                        System.out.println(gameHistory.get(i));
                    }
                    System.out.println();
                    System.out.println("------------ Game Stats ------------");
                    // Based on the Strategy method pattern
                    if (hangmanCount > 0)
                        System.out.println("About Hangman:    " + hangmanCount + " plays, " + Homework1.hangmanAverage + " average score");
                    if (baseballCount > 0)
                        System.out.println("About Baseball:   " + baseballCount + " plays, " + Homework2.baseballAverage + " average score");
                    if (tictactoeCount > 0)
                        System.out.println("About TicTacToe:  " + tictactoeCount + " plays, " + Homework3.tictactoeAverage + " average score");
                    game = false;
                    break;
                default:
                    System.out.println("Invalid Input!\n");
                    break;
            }
        }
    }
}