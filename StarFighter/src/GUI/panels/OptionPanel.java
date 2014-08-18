package GUI.panels;

import GUI.GuiController;
import GUI.soundPlayer.SoundPlayer;
import configuration.ConfigurationHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
        
        //center panel ==> panel met alle options op
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        //eerste getal aantal rijen, tweede getal aantal kolommen.
        centerPanel.setLayout(new GridLayout(1, 2));
        //label voor resolutions
        JLabel resolutionsLabel = new JLabel("resolutions");
        resolutionsLabel.setForeground(Color.WHITE);
        resolutionsLabel.setFont(FontInitializer.getInstance().getFont());
        
        //resolutions comboBox
        JComboBox resolutions = new JComboBox(ConfigurationHandler.getInstance().getResolutions());
        
        centerPanel.add(resolutionsLabel);
        centerPanel.add(resolutions);
        
        //panel voor exit button
        JPanel exitPanel = new JPanel();
        exitPanel.setOpaque(false);
        
        JButton toMainMenu = new JButton("To main menu");
        toMainMenu.setFocusable(false);
        toMainMenu.setFont(FontInitializer.getInstance().getFont());
        toMainMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                GuiController.getInstance().toStartPanel(SoundPlayer.getInstance().isPlaying(), false);
            }
        });
        
        exitPanel.add(toMainMenu);
        
        //toevoegen van panels aan frame
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(exitPanel, BorderLayout.PAGE_END);
    }
    
    //paint methode
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImageResizer.getInstance().resizeImage(backgroundImage, GuiController.getInstance().getWidth(), GuiController.getInstance().getHeight()), 0, 0, null);
    }
}
