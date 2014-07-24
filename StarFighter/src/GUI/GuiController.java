/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JFrame;

/**
 *
 * @author nathan
 */
public class GuiController {
    //variables
    private static GuiController instance;
    private OuterFrame frame;
    
    //constructors
    private GuiController(){
        //init de mogelijke frames
        
    }
    
    //private methodes
    private void initFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(786, 432);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    //public methodes
    public void setFrame(OuterFrame frame){
        this.frame = frame;
        initFrame();
    }
    
    //startPanel toevoegen en renderen
    public void toStartPanel(){
        
    }
    
    //public static methode 
    //ophalen van GuiController object ==> singleton object
    public static GuiController getInstance(){
        if(instance == null)
            instance = new GuiController();
        
        return instance;
    }
}
