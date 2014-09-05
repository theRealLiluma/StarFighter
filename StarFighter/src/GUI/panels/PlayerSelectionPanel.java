package GUI.panels;

import domein.DomeinController;
import java.awt.Color;
import java.util.List;

public class PlayerSelectionPanel extends CustomPanel{
    //variables
    private DomeinController domCntrl;
    private List<List<String>> races;
    
    //constructor
    public PlayerSelectionPanel(){
        //observer maken ==> linken met game
        setDomeinController();
        initPanel();
    }
    
    //private methodes
    private void initPanel(){
        races = domCntrl.getRaces();
        
        System.out.println("races: ");
        for(int i = 0; i < races.size(); i++){
            List<String> content = races.get(i);
            for(int j = 0; j < content.size(); j++){
                System.out.println(content.get(j));
            }
            System.out.println();
            System.out.println();
        }
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
