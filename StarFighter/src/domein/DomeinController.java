package domein;

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
    public void startGame(){
        System.out.println("starting game");
        game.startNewGame();
    }
    
    public void loadGame(){
        System.out.println("loading game");
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
