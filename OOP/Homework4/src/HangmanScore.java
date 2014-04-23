public class HangmanScore extends GameScore {
    
    @Override
    public void score(int tries) {
        totalScore = totalScore - (tries * 10);
    }
    
}