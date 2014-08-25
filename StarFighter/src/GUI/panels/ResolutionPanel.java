package GUI.panels;

import GUI.GuiController;
import configuration.ConfigurationHandler;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    private void updateResolution(){
        Font font = FontInitializer.getInstance().getFont();
        chosenResolution.setFont(font);
        chosenResolution.setForeground(Color.WHITE);
        chosenResolution.setText(ConfigurationHandler.getInstance().getResolutionText());
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
        lowerResolution.setFont(font); 
        lowerResolution.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ConfigurationHandler.getInstance().toLowerResolution();
                updateResolution();
                GuiController.getInstance().updateClientSize();
            }
        });
        
        /*higherResolutionButton */
        higherResolution = new JButton("-->");
        higherResolution.setFont(font);
        higherResolution.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ConfigurationHandler.getInstance().toHigherResolution();
                updateResolution();
                GuiController.getInstance().updateClientSize();
            }
        });
        
        
        //toevoegen aan panel
        this.add(resolutionLabel);
        this.add(lowerResolution);
        this.add(chosenResolution);
        this.add(higherResolution);
    }
}
