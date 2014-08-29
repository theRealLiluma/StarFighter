package GUI.panels;

import domein.DomeinController;
import java.util.Observable;
import java.util.Observer;

public class GamePanel extends CustomPanel implements Observer{
    //variabels
    private DomeinController domCntrl;
    
    //constructor
    public GamePanel(){
        //observer maken ==> linken met game
        setDomeinController();
        domCntrl.subScribeGameListener(this);
    }
    
    //private methodes
    private void initPanel(){
        
    }
    
    private void setDomeinController(){
        this.domCntrl = DomeinController.getInstance();
    }
    
    //public methodes
    
     //music methodes
    @Override
    public void startBackgroundMusic(){
        
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("i have been updated");
        System.out.println(o.getClass());
        
    }
}
