public class GameHistory {
    
    public GameHistory(String type, double score) {
        this.type = type;
        gameScore = score;
    }
    
    public History displayHistory() {
        if (type.equals("Hangman")) {
            return new HangmanHistory("Hangman", gameScore);
        } else if (type.equals("Baseball")) {
            return new BaseballHistory("Baseball", gameScore);
        } else if (type.equals("Tictactoe")) {
            return new TictactoeHistory("TicTacToe", gameScore);
        } else {
            return null;
        }
    }
    
    private String type;
    private double gameScore;
    
}