package GUI.panels.customComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 *
 * @author nathan
 */
public class CustomButton extends JComponent implements MouseListener{
    //private variables
    private final Dimension DIMENSION = new Dimension(100,25);
    private boolean mouseEntered = false;
    private boolean mousePressed = false;
    private String label;
    
    public CustomButton(String label){
        super();
        this.setBackground(Color.RED);
        setSize(DIMENSION);
        enableInputMethods(true);
        addMouseListener(this);
        setLabel(label);
    }
    
    private void setLabel(String label){
        this.label = label;
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(getWidth(), getHeight());
    }
    @Override
    public Dimension getMinimumSize(){
        return getPreferredSize();
    }
    @Override
    public Dimension getMaximumSize(){
        return getPreferredSize();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        //renderen van de button
        //opties voor muis op de knop of niet.
        if(!mouseEntered){
            g.setColor(Color.YELLOW);
        }else{
            g.setColor(Color.cyan);
        }
        g.fillRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        
        //renderen van bord if button clicked
        if(mousePressed){
            g.setColor(Color.red);
            g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("testing");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        mousePressed = true;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        mousePressed = false;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        mouseEntered = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent me) {
        mouseEntered = false;
        repaint();
    }
    
}
