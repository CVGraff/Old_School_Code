public class HangmanHistory extends History {
    
    public HangmanHistory(String type, double score) {
        super(type);
        hangmanScore = score;
    }
    
    @Override
    public String description() {
        return getType() + " " + hangmanScore;
    }
    
    private double hangmanScore;
    
}