public abstract class History {
    
    public History(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public abstract String description();
    
    private String type;
    
}