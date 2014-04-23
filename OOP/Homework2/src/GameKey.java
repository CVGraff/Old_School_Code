public class GameKey {
    public GameKey() {
        sameSpot = false;
        random = 0;
    }

    public int getRandom() {
        return random = (int)(9 * Math.random());
    }
    
    public boolean checkSameSpot(int i) {
        keyPosition = i;
        return sameSpot = true;
    }
    
    private int random;
    private int keyPosition;
    
    private boolean sameSpot;
    
}
