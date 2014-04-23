public class BaseballHistory extends History {
    
    public BaseballHistory(String type, double score) {
        super(type);
        baseballScore = score;
    }
    
    @Override
    public String description() {
        return getType() + " " + baseballScore;
    }
    
    private double baseballScore;
    
}