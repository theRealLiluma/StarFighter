package GUI.panels.customComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author nathan
 */
public class CustomButton extends JComponent implements MouseListener{
    //private variables
    private Dimension dimension = new Dimension(100,25);
    private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();
    private boolean mouseEntered = false;
    private boolean mousePressed = false;
    
    public CustomButton(){
        super();
        this.setBackground(Color.RED);
        setSize(dimension);
        enableInputMethods(true);
        addMouseListener(this);
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
        g.setColor(Color.red);
        g.drawString("test", 10, 10);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "test");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "test");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "test");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        mouseEntered = false;
        //setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent me) {
        JOptionPane.showMessageDialog(null, "test");
    }
    
}
