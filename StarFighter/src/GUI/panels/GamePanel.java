package GUI.panels;

import domein.DomeinController;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

public class GamePanel extends CustomPanel implements Observer{
    //variabels
    private DomeinController domCntrl;
    private List<JLabel> menuOptions;
    private boolean menuVisible;
    
    //constructor
    public GamePanel(){
        //observer maken ==> linken met game
        setDomeinController();
        domCntrl.subScribeGameListener(this);
        initPanel();
    }
    
    //private methodes
    private void initPanel(){
        menuVisible = false;
        //init menu's
        
        //keylistener
        this.setFocusable(true);
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        toggleMenuVisible();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}           
        });
    }
    
    private void setDomeinController(){
        this.domCntrl = DomeinController.getInstance();
    }
    
    private void toggleMenuVisible(){
        if(menuVisible){
            menuVisible = false;
        }else{
            menuVisible = true;
        }
        this.repaint();
    }
    
    //public methodes
    
     //music methodes
    @Override
    public void startBackgroundMusic(){
        
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("i have been updated");
        System.out.println(o.getClass());
        
    }
}
