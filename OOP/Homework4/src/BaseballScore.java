public class BaseballScore extends GameScore {
    
    @Override
    public void score(int tries) {
        totalScore = totalScore - (tries * 5);
    }
    
}