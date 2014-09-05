package domein;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Game extends Observable{
    //variabels
    private Player player;
    private RepositoryHandler repHandler;
    
    //constructor
    public Game(){
        repHandler = new RepositoryHandler();
    }
    
    //private methodes
    
    //public methodes
    public List<List<String>> getRaces(){
        return repHandler.getRaces();
    }
    
    public void startNewGame(){
        setChanged();
        notifyObservers(this);
    }
    
    public void loadGame(){
        setChanged();
        notifyObservers(this);
    }
    
    //observer methodes
    public void subScribeGameListener(Observer ob){
        this.addObserver(ob);
    }
}
