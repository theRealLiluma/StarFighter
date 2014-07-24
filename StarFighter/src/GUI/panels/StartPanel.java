package GUI.panels;

import GUI.GuiController;
import java.awt.Graphics;
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
        try {
            background = ImageIO.read(new File("src/assets/images/startScreen/startScreen1.jpg"));
            //resizeBackground image
            backgroundImage = ImageResizer.getInstance().resizeImage(background, GuiController.getInstance().getWidth(), GuiController.getInstance().getHeight());
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "error loading image");
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
