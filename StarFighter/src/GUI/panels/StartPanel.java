package GUI.panels;

import GUI.GuiController;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import utility.ImageResizer;

/**
 *
 * @author nathan
 */
public class StartPanel extends JPanel{
    //variables
    private BufferedImage backgroundImage;
    
    //constructor
    public StartPanel(){
        //loadBackground image
        try{
            backgroundImage = ImageIO.read(StartPanel.class.getResourceAsStream("/assets/images/startScreen/startScreen1.jpg"));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    //paint methode
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(ImageResizer.getInstance().resizeImage(backgroundImage, GuiController.getInstance().getWidth(), GuiController.getInstance().getHeight()), 0, 0, null);
    }
}
