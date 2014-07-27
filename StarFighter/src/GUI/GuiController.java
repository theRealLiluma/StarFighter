package GUI;

import GUI.panels.CustomPanel;
import GUI.panels.OptionPanel;
import GUI.panels.StartPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author nathan
 */
public class GuiController {
    //variables
    private static GuiController instance;
    private OuterFrame frame;
    private final HashMap<String, CustomPanel> panels;
    private CustomPanel visiblePanel;
    private final Dimension MINDIMENSION = new Dimension(786,432);
    
    //constructors
    private GuiController(){
        //init hashMap
        panels = new HashMap<String, CustomPanel>();
    }
    
    //private methodes
    private void initFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MINDIMENSION);
        frame.setMinimumSize(MINDIMENSION);
        frame.setLocationRelativeTo(null);
        initPanels();
        frame.setVisible(true);
    }
    
    private void initPanels(){
        //init de mogelijke frames
        panels.put("start", new StartPanel());
        panels.put("options", new OptionPanel());
    }
    
    private void clearFrame(){
        if(visiblePanel != null){
            visiblePanel.endBackgroundMusic();
            frame.remove(visiblePanel);
        }
        //frame.repaint();
    }
    
    private void clearFrameForOptionsPanel(){
        if(visiblePanel != null){
            frame.remove(visiblePanel);
        }
        frame.repaint();
    }
    
    //public methodes
    public void setFrame(OuterFrame frame){
        this.frame = frame;
        initFrame();
    }
    
    //startPanel toevoegen en renderen
    public void toStartPanel(){
        clearFrame();
        visiblePanel = panels.get("start");
        frame.add(visiblePanel);
        visiblePanel.startBackgroundMusic();
        frame.pack();
        //repaintFrame();
    }
    
    //optionpanel renderen
    public void toOptions(){
        clearFrameForOptionsPanel();
        visiblePanel = panels.get("options");
        frame.add(visiblePanel);
        frame.pack();
        //repaintFrame();
    }
    
    private void repaintFrame(){
        frame.repaint();
    }
    
    //get width of frame
    public int getWidth(){
        return frame.getWidth();
    }
    
    //get height of frame
    public int getHeight(){
        return frame.getHeight();
    }
    
    //public static methode 
    //ophalen van GuiController object ==> singleton object
    public static GuiController getInstance(){
        if(instance == null)
            instance = new GuiController();
        
        return instance;
    }
}
