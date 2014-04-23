// Tic-Tac-Toe with computer
import java.util.*;

// Many parts of this code was adopted from this source
// Source: http://www.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe.html
public class Homework3 {
    public static double tictactoeAverage = 0;
    
    private Board board;               // the game board
    private GameState currentState;    // the current state of the game (of enum GameState)
    private Seed currentPlayer;        // the current player (of enum Seed)
    
    Computer comp = new Computer();
  
    private static Scanner in = new Scanner(System.in);  // input Scanner
  
    /* Constructor to setup the game */
    public Homework3() {
       board = new Board();  // allocate game-board
  
       // Initialize the game-board and current status
       initGame();
       board.paint();
       GameScore tttScore = new TictactoeScore();
       // Play the game once. Players CROSS and NOUGHT move alternately.
       do {
          playerMove(currentPlayer); // update the content, currentRow and currentCol
          if (currentPlayer == Seed.CROSS) {
              board.paint(); // ask the board to paint itself after computer's input
          }
          updateGame(currentPlayer); // update currentState
          
          // Print message if game-over
          if (currentState == GameState.CROSS_WON) {
             System.out.println("Computer won!");
             tttScore.score(10);
          } else if (currentState == GameState.NOUGHT_WON) {
             System.out.println("You win!");
             tttScore.score(0);
          } else if (currentState == GameState.DRAW) {
             System.out.println("It's a draw!");
             tttScore.score(5);
          }
          // Switch player
          currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
          
          if (currentState == GameState.CROSS_WON || currentState == GameState.NOUGHT_WON
                  || currentState == GameState.DRAW) {
              board.paint();
              System.out.println("Your score is " + tttScore.getTotalScore());
              Homework4.tictactoeList.add(tttScore.getTotalScore()); // Puts total score into an array
              Homework4.tictactoeCount++; // Increase count of how many times the player has played
              
              // Add current score into the game history arraylist
              GameHistory tictactoeHistory = new GameHistory("Tictactoe",tttScore.getTotalScore());
              History tttHistory = tictactoeHistory.displayHistory();
              Homework4.gameHistory.add(tttHistory.description());
              
              System.out.print("Do you want to play another game? [y/n]: ");
              Scanner userChoice = new Scanner(System.in);
              String choice = userChoice.nextLine();
              
              if ("n".equals(choice) || "N".equals(choice)) {
                  break;
              } else {
                  new Homework3();
              }
          }
       } while (currentState == GameState.PLAYING);  // repeat until game-over
    }
 
    /** Initialize the game-board contents and the current states */
    public void initGame() {
       board.init();  // clear the board contents
       currentPlayer = Seed.NOUGHT;       // NOUGHT plays first
       currentState = GameState.PLAYING; // ready to play
    }
 
    /** The player with "theSeed" makes one move, with input validation.
        Update cell's content, board's currentRow and currentCol. */
    public void playerMove(Seed theSeed) {
        boolean validInput = false;  // for validating input
        boolean loop = true;
        int row = -1;
        int col = -1;
        do {
            if (theSeed == Seed.NOUGHT) {
                System.out.println("Your turn");
                do {
                    System.out.print("Enter your move (row[0-2] column[0-2]): ");
                    String r = in.next();
                    String c = in.next();
                    try {
                        row = Integer.parseInt(r);
                        col = Integer.parseInt(c);
                        loop = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                    }
                } while (loop);
                if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
                   && board.cells[row][col].content == Seed.EMPTY) {
                    board.cells[row][col].content = theSeed;
                    board.currentRow = row;
                    board.currentCol = col;
                    validInput = true; // input okay, exit loop
                } else {
                    System.out.println("This move at (" + (row) + "," + (col)
                          + ") is not valid. Try again...");
                }
            } else {
                row = comp.move();
                col = comp.move();
                if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
                   && board.cells[row][col].content == Seed.EMPTY) {
                    board.cells[row][col].content = theSeed;
                    board.currentRow = row;
                    board.currentCol = col;
                    validInput = true; // input okay, exit loop
                }
            }
       } while (!validInput);   // repeat until input is valid
    }
 
    /** Update the currentState after the player with "theSeed" has moved */
    public void updateGame(Seed theSeed) {
        if (board.hasWon(theSeed)) {  // check for win
             currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
        } else if (board.isDraw()) {  // check for draw
             currentState = GameState.DRAW;
        }
        // Otherwise, no change to current state (still GameState.PLAYING)
    }
}