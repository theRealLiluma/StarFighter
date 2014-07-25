package GUI;

import domein.DomeinController;
import java.awt.Toolkit;
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
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("assets/images/thumbs/Thumbs.png")));
        this.setTitle("Star Fighter");
        setController(domCntrl);
        this.setCursor(CursorSelector.getInstance().getRequestedCursor("default"));
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
