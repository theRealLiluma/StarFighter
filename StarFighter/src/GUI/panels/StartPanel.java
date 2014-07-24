package GUI.panels;

import GUI.GuiController;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
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
        BufferedImage background;
        File file = null;
        try {
            //file = new File("src/assets/images/startScreen/startScreen1.jpg");
            background = ImageIO.read(StartPanel.class.getResourceAsStream("/assets/images/startScreen/startScreen1.jpg"));
            //ImageIO.read(file);
            //resizeBackground image
            backgroundImage = ImageResizer.getInstance().resizeImage(background, GuiController.getInstance().getWidth(), GuiController.getInstance().getHeight());
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
    
    //paint methode
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
