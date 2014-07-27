package GUI.panels;

import GUI.GuiController;
import GUI.soundPlayer.SoundPlayer;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import utility.FontInitializer;
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
        this.setLayout(new BorderLayout());
        
        //panel voor exit button
        JPanel exitPanel = new JPanel();
        exitPanel.setOpaque(false);
        
        JButton toMainMenu = new JButton("To main menu");
        toMainMenu.setFont(FontInitializer.getInstance().getFont());
        toMainMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                GuiController.getInstance().toStartPanel(SoundPlayer.getInstance().isPlaying());
            }
        });
        
        exitPanel.add(toMainMenu);
        
        this.add(exitPanel, BorderLayout.PAGE_END);
    }
    
    //paint methode
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImageResizer.getInstance().resizeImage(backgroundImage, GuiController.getInstance().getWidth(), GuiController.getInstance().getHeight()), 0, 0, null);
    }
}
