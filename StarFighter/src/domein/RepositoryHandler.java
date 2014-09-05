package domein;

import domein.races.RaceRepository;
import java.util.List;

public class RepositoryHandler {
    private RaceRepository raceRep;
    
    public RepositoryHandler(){
        raceRep = new RaceRepository();
    }
    
    public List<List<String>> getRaces(){
        return raceRep.getRaces();
    }
}
