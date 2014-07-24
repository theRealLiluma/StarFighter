package GUI;

import domein.DomeinController;
import javax.swing.JFrame;

/**
 *
 * @author nathan
 */
public class OuterFrame extends JFrame{
    //variables
    private DomeinController domCntrl;
    
    //constructor
    public OuterFrame(DomeinController domCntrl){
        setController(domCntrl);
        GuiController.getInstance().setFrame(this);
    }
    
    //public methodes
    public void toStartPanel(){
        GuiController.getInstance().toStartPanel();
    }
    
    //private settermethodes
    private void setController(DomeinController domCntrl){
        this.domCntrl = domCntrl;
    }
}
