package GUI.panels;

import configuration.ConfigurationHandler;
import java.awt.Color;
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
    private final String RESOLUTIONS = "Resolutions: ";
    
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
        resolutionLabel.setForeground(Color.WHITE);
        resolutionLabel.setText(RESOLUTIONS);
        
        /* chosenResolution */
        chosenResolution = new JLabel();
        chosenResolution.setFont(font);
        chosenResolution.setForeground(Color.WHITE);
        chosenResolution.setText(ConfigurationHandler.getInstance().getResolutionText());
        
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
