public class TictactoeScore extends GameScore {
    
    @Override
    public void score(int tries) {
        totalScore = totalScore - (tries * 100);
    }
    
}