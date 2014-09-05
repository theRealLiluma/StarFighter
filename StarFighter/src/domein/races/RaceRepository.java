package domein.races;

import java.util.ArrayList;
import java.util.List;

public class RaceRepository {
    //variabels
    private List<PlayerRace> races;
    
    //constructor
    public RaceRepository(){
        initRepository();
    }
    
    //public methods
    public List<List<String>> getRaces(){
        List<List<String>> racesGUIList = new ArrayList();
        for(int i = 0; i < races.size(); i++){
            PlayerRace race = races.get(i);
            List<String> content = new ArrayList<String>();
            content.add(race.getName());
            content.add(race.getDescription());
            racesGUIList.add(content);
        }
        return racesGUIList;
    }
    
    //private methods
    private void initRepository(){
        //lijst aanmaken 
        races = new ArrayList<PlayerRace>();
        
        //races toevoegen
        PlayerRace race = new Terran("The most simplest of the organisms\nAverage stats overall, it's the jack of all trades");
        races.add(race);
        race = new Enderium("The most intelectual developed organism\nIt specialize in the study of the mind, and how to make the most of it\nIt can defend itself in melee fight, but don't expect miracles");
        races.add(race);
    }
}
