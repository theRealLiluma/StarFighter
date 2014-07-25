package GUI;

import GUI.panels.CustomPanel;
import GUI.panels.StartPanel;
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
    private HashMap<String, CustomPanel> panels;
    private CustomPanel visiblePanel;
    
    //constructors
    private GuiController(){
        //init hashMap
        panels = new HashMap<String, CustomPanel>();
    }
    
    //private methodes
    private void initFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(786, 432);
        frame.setLocationRelativeTo(null);
        initPanels();
        frame.setVisible(true);
    }
    
    private void initPanels(){
        //init de mogelijke frames
        panels.put("start", new StartPanel());
    }
    
    private void clearFrame(){
        if(visiblePanel != null){
            visiblePanel.endBackgroundMusic();
            frame.remove(visiblePanel);
        }
    }
    
    //public methodes
    public void setFrame(OuterFrame frame){
        this.frame = frame;
        initFrame();
    }
    
    //startPanel toevoegen en renderen
    public void toStartPanel(){
        clearFrame();
        CustomPanel panel = panels.get("start");
        frame.add(panel);
        panel.startBackgroundMusic();
        visiblePanel = panel;
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
