package GUI.panels;

import GUI.soundPlayer.SoundPlayer;
import javax.swing.JPanel;

/**
 *
 * @author nathan
 */
public abstract class CustomPanel extends JPanel{
    public void startBackgroundMusic(){
        
    }
    
    public void endBackgroundMusic(){
        SoundPlayer musicInstance = SoundPlayer.getInstance();
        if(musicInstance.isInitialized()){
            musicInstance.resetPlayer();
        }
    }
    
    public void muteSound(){
        
    }
    
    public void requestFocusForKeyInput(){
        this.requestFocus();
    }
}
