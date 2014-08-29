package GUI.panels;

import GUI.GuiController;
import GUI.soundPlayer.References;
import GUI.soundPlayer.SoundPlayer;
import domein.DomeinController;
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
public class StartPanel extends CustomPanel{
    //variables
    private BufferedImage backgroundImage;
    private final String BACKGROUNDMUSIC = "intro.wav";
    //link naar domein
    private DomeinController domCntrl;
    
    //constructor
    public StartPanel(){
        initPanel();
        setDomeinController();
    }
    
    private void setDomeinController(){
        this.domCntrl = DomeinController.getInstance();
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
        this.setLayout(new BorderLayout());
        
        //buttonPanel
        JPanel buttonPanel = new JPanel();
        //buttonpanel transparent maken
        buttonPanel.setOpaque(false);
        
        //buttons toevoegen en font setten
        JButton startGame = new JButton("start game");
        startGame.setFocusable(false);
        startGame.setFont(FontInitializer.getInstance().getFont());
        startGame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //laden van een nieuw game.
                domCntrl.startGame();
                GuiController.getInstance().toGame();
            }  
        });
        buttonPanel.add(startGame);
        
        JButton loadGame = new JButton("load game");
        loadGame.setFocusable(false);
        loadGame.setFont(FontInitializer.getInstance().getFont());
        loadGame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //inladen van vorig spel of meerdere save files ==> moet nog bekeken worden
                domCntrl.loadGame();
                GuiController.getInstance().toGame();
            }
        });
        buttonPanel.add(loadGame);
        
        JButton options = new JButton("options");
        options.setFocusable(false);
        options.setFont(FontInitializer.getInstance().getFont());
        options.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                GuiController.getInstance().toOptions();
            }
        });
        buttonPanel.add(options);
        
        JButton exit = new JButton("exit game");
        exit.setFocusable(false);
        exit.setFont(FontInitializer.getInstance().getFont());
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        buttonPanel.add(exit);
        
        //panels toevoegen mainPanel
        this.add(buttonPanel, BorderLayout.PAGE_END);
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
        super.paintComponent(g);
        g.drawImage(ImageResizer.getInstance().resizeImage(backgroundImage, GuiController.getInstance().getWidth(), GuiController.getInstance().getHeight()), 0, 0, null);
    }
}
