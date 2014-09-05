package GUI;

import GUI.panels.CustomPanel;
import GUI.panels.GamePanel;
import GUI.panels.OptionPanel;
import GUI.panels.PlayerSelectionPanel;
import GUI.panels.StartPanel;
import configuration.ConfigurationHandler;
import configuration.Resolution;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JFrame;

public class GuiController {
    //variables
    private static GuiController instance;
    private OuterFrame frame;
    private final HashMap<String, CustomPanel> panels;
    private CustomPanel visiblePanel;
    private Dimension currentDimension;
    
    //constructors
    private GuiController(){
        //init hashMap
        panels = new HashMap<String, CustomPanel>();
        Resolution res = ConfigurationHandler.getInstance().getResolution();
        currentDimension = new Dimension(res.getWidth(), res.getHeight());
    }
    
    //private methodes
    private void initFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(currentDimension);
        frame.setMinimumSize(currentDimension);
        currentDimension = new Dimension(currentDimension.width, currentDimension.height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        initPanels();
        frame.setVisible(true);
    }
    
    private void initPanels(){
        //init de mogelijke frames
        panels.put("start", new StartPanel());
        panels.put("options", new OptionPanel());
        panels.put("game", new GamePanel());
        panels.put("newGame", new PlayerSelectionPanel());
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
    
    //gamePanel renderen
    public void toGame(){
        clearFrame(true);
        visiblePanel = panels.get("game");
        frame.add(visiblePanel);
        frame.pack();
        visiblePanel.requestFocusForKeyInput();
    }
    
    //player aanmaken
    public void toNewGame(){
        clearFrame(true);
        visiblePanel = panels.get("newGame");
        frame.add(visiblePanel);
        frame.pack();
        visiblePanel.requestFocusForKeyInput();
    }
    
    //framesize updaten
    public void updateClientSize(){
        Resolution res = ConfigurationHandler.getInstance().getResolution();
        currentDimension = new Dimension(res.getWidth(), res.getHeight());
        frame.setSize(currentDimension);
        frame.setMinimumSize(currentDimension);
        frame.setLocationRelativeTo(null);
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
