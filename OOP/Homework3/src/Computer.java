public class Computer {
    
    public Computer() {
        randomMove = 0;
    }
    
    // Generate a random computer move
    public int move() {
	randomMove = (int)(2 * Math.random());
        return randomMove;
    }
    
    private int randomMove;
    
}