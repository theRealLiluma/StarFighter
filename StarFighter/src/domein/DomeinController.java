package domein;

import java.util.List;
import java.util.Observer;

public class DomeinController {
    //variables
    private static DomeinController instance;
    private Game game;
    
    //constructors
    private DomeinController(){
        game = new Game();
    }
    
    //domeinaccess methods
    public List<List<String>> getRaces(){
        return game.getRaces();
    }
    
    public void startGame(){
        game.startNewGame();
    }
    
    public void loadGame(){
        game.loadGame();
    }
    
    public void subScribeGameListener(Observer ob){
        game.subScribeGameListener(ob);
    }
    
    public static DomeinController getInstance(){
        if(instance == null)
            instance = new DomeinController();
        
        return instance;
    }
}
