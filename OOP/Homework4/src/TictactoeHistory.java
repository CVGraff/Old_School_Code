public class TictactoeHistory extends History {
    
    public TictactoeHistory(String type, double score) {
        super(type);
        tictactoeScore = score;
    }
    
    @Override
    public String description() {
        return getType() + " " + tictactoeScore;
    }
    
    private double tictactoeScore;
    
}