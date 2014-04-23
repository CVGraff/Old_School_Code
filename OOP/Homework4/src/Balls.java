public class Balls {
    public Balls() {
        balls = 0;
    }

    public int getBalls() {
        return balls;
    }
    
    public void increaseBalls() {
        balls++;
    }
    
    public void resetBalls() {
        balls = 0;
    }
    
    private int balls;
    
}