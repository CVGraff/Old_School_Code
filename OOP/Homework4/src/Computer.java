public class Computer {
    
    public Computer() {
        randomMove = 0;
    }
    
    // Generate a random computer move
    public int move() {
	randomMove = (int)(Math.random() * 3);
        return randomMove;
    }
    
    private int randomMove;
    
}