package domein;

import domein.races.PlayerRace;
import domein.races.Races;

public class Player {
    private PlayerRace race;
    
    public Player(Races race){
        this.race = race.initRace();
    }
}
