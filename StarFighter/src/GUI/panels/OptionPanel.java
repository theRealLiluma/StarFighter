package GUI.panels;

import GUI.GuiController;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import utility.ImageResizer;

/**
 *
 * @author nathan
 */
public class OptionPanel extends CustomPanel{
    private BufferedImage backgroundImage;
    
    public OptionPanel(){
        initPanel();
    }
    
    private void initPanel(){
        //loadBackground image
        try{
            backgroundImage = ImageIO.read(StartPanel.class.getResourceAsStream("/assets/images/startScreen/startScreen1.jpg"));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        //buildLayout startScreen
    }
    
    //paint methode
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImageResizer.getInstance().resizeImage(backgroundImage, GuiController.getInstance().getWidth(), GuiController.getInstance().getHeight()), 0, 0, null);
    }
}
