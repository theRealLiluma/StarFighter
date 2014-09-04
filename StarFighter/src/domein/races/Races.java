package domein.races;

public enum Races {
    TERRAN("terran"),
    ENDERIUM("enderium");

    private final String raceName;
    private final String TERRANNAME = "terran";
    private final String ENDERIUMNAME = "enderium";

    private Races(String raceName)
    {
        this.raceName = raceName;
    }

    public String getMessage()
    {
        return raceName;
    }
    
    public PlayerRace initRace(){
        switch(this.raceName){
            case TERRANNAME : return new Terran();
             
            case ENDERIUMNAME: return new Enderium();
                
            default: return new Terran();
        }
    }
}