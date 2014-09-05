package domein.races;

public class Terran implements PlayerRace{
    //variabels
    private final String NAME;
    private String description;
    
    //constructor
    public Terran(String description){
        NAME = this.getClass().getSimpleName();
        setDescription(description);
    }
    
    //setter en getter methodes
    private void setDescription(String description){
        this.description = description;
    }
    
    public String getName(){
        return NAME;
    }
    
    public String getDescription(){
        return description;
    }
}
