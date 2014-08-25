package GUI.panels;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utility.FontInitializer;

public class ResolutionPanel extends JPanel{
    private JLabel resolutionLabel;
    private JLabel chosenResolution;
    private JButton lowerResolution;
    private JButton higherResolution;
    
    public ResolutionPanel(){
        initFields();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
    }
    
    private void initFields(){
        /* Font */
        Font font = FontInitializer.getInstance().getFont();
        
        /* resolutionlabel */       
        resolutionLabel = new JLabel();
        resolutionLabel.setFont(font);
        
        /* chosenResolution */
        chosenResolution = new JLabel();
        chosenResolution.setFont(font);
        
        /* lowerResolutionButton */
        lowerResolution = new JButton("<--");
        
        /*higherResolutionButton */
        higherResolution = new JButton("-->");
        
        
        //toevoegen aan panel
        this.add(resolutionLabel);
        this.add(lowerResolution);
        this.add(chosenResolution);
        this.add(higherResolution);
    }
}
