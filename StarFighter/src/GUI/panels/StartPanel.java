package GUI.panels;

import GUI.GuiController;
import GUI.panels.customComponents.CustomButton;
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
        initPanel();
    }
    
    //private methodes
    private void initPanel(){
        //loadBackground image
        try{
            backgroundImage = ImageIO.read(StartPanel.class.getResourceAsStream("/assets/images/startScreen/startScreen1.jpg"));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
        //buildLayout startScreen
        CustomButton testButton = new CustomButton("button1");
        this.add(testButton);
        
        CustomButton testButton2 = new CustomButton("button2");
        this.add(testButton2);
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
