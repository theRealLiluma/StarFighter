package GUI.panels;

import GUI.GuiController;
import GUI.soundPlayer.References;
import GUI.soundPlayer.SoundPlayer;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import utility.ImageResizer;

/**
 *
 * @author nathan
 */
public class StartPanel extends CustomPanel{
    //variables
    private BufferedImage backgroundImage;
    private final String BACKGROUNDMUSIC = "intro.wav";
    
    //constructor
    public StartPanel(){
        //loadBackground image
        try{
            backgroundImage = ImageIO.read(StartPanel.class.getResourceAsStream("/assets/images/startScreen/startScreen1.jpg"));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    //music methodes
    @Override
    public void startBackgroundMusic(){
        SoundPlayer musicInstance = SoundPlayer.getInstance();
        musicInstance.initSound(References.getMUSICLOCATION() + BACKGROUNDMUSIC);
        musicInstance.startPlaying();
    }
    
    //paint methode
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(ImageResizer.getInstance().resizeImage(backgroundImage, GuiController.getInstance().getWidth(), GuiController.getInstance().getHeight()), 0, 0, null);
    }
}
