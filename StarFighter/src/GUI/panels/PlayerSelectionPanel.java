package GUI.panels;

import domein.DomeinController;
import java.awt.Color;
import java.util.List;

public class PlayerSelectionPanel extends CustomPanel{
    //variables
    private DomeinController domCntrl;
    private List<String> races;
    
    //constructor
    public PlayerSelectionPanel(){
        //observer maken ==> linken met game
        setDomeinController();
        initPanel();
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
}
