package GUI;

import GUI.panels.CustomPanel;
import GUI.panels.OptionPanel;
import GUI.panels.StartPanel;
import java.awt.Dimension;
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
    
    private void clearFrame(boolean stopSound){
        if(visiblePanel != null){
            if(stopSound)
                visiblePanel.endBackgroundMusic();
            
            frame.remove(visiblePanel);
            //System.out.println("removing: " + visiblePanel.toString());
        }
        frame.repaint();
    }
    
    //public methodes
    public void setFrame(OuterFrame frame){
        this.frame = frame;
        initFrame();
    }
    
    //startPanel toevoegen en renderen
    public void toStartPanel(boolean musicPlaying, boolean stopCurrentPlayingMusic){
        clearFrame(stopCurrentPlayingMusic);
        visiblePanel = panels.get("start");
        frame.add(visiblePanel);
        if(!musicPlaying){
            visiblePanel.startBackgroundMusic();
        }
        
        frame.pack();
    }
    
    //optionpanel renderen
    public void toOptions(){
        clearFrame(false);
        visiblePanel = panels.get("options");
        frame.add(visiblePanel);
        frame.pack();
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
