package domein;

import java.util.Observable;
import java.util.Observer;

public class Game extends Observable{
    //variabels
    private Player player;
    
    //constructor
    public Game(){
        
    }
    
    //private methodes
    
    //public methodes
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
