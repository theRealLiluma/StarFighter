package GUI;

import GUI.soundPlayer.SoundPlayer;
import domein.DomeinController;
import java.awt.Toolkit;
import javax.swing.JFrame;
import utility.FontInitializer;

/**
 *
 * @author nathan
 */
public class OuterFrame extends JFrame{
    //variables
    
    //constructor
    public OuterFrame(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("assets/images/thumbs/Thumbs.png")));
        this.setTitle("Star Fighter");
        //setten van cursor
        this.setCursor(CursorSelector.getInstance().getRequestedCursor("default"));
        //setten van font
        this.setFont(FontInitializer.getInstance().getFont());
        
        GuiController.getInstance().setFrame(this);
    }
    
    //public methodes
    public void toStartPanel(){
        GuiController.getInstance().toStartPanel(SoundPlayer.getInstance().isPlaying(), true);
    }
    
    //private settermethodes
}
