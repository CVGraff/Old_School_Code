public class Strikes {
    public Strikes() {
        strike = 0;
    }

    public int getStrikes() {
        return strike;
    }
    
    public void increaseStrikes() {
        strike++;
    }
    
    public void resetStrikes() {
        strike = 0;
    }
    
    private int strike;
    
}