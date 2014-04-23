// Defines the score method for each game
public abstract class GameScore {
    public double totalScore;
    
    public GameScore() {
        totalScore = 1000;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }
    
    abstract void score(int tries);
}