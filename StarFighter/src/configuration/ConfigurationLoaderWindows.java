package configuration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author nathan
 */
public class ConfigurationLoaderWindows implements Configuration{
    /* session variabels */
    private File configFile;
    private String locationFolder;
    private ConfigurationItems configurationItems;
    private Resolution selectedResolution;
    
    /* final variables */
    private final String FOLDERNAME = "starfighter";
    private final String FILENAME = "starfighterconfig";
    private final String DEFAULTFILE = "/assets/config/defaultConfig.conf";
    private final String RESOLUTION = "resolution";
    
    public ConfigurationLoaderWindows(){
        configurationItems = new ConfigurationItems();
        locationFolder = System.getenv("APPDATA");
        Path folderPath = Paths.get(locationFolder + "/" + FOLDERNAME);
        if(!Files.exists(folderPath)){
            //creating directory
            File dir = new File(locationFolder + "/" + FOLDERNAME);
            dir.mkdir();
            System.out.println("directory created");
        }
        //inladen van configurationFile
        loadConfigFile();
        initConfiguration();
    }
    
    private void loadConfigFile(){
        //controleren of er een configfile aanwezig is
        Path configFilePath = Paths.get(locationFolder + "/" + FOLDERNAME + "/" + FILENAME);
        if(!Files.exists(configFilePath)){
            //default bestand kopieren en inlezen
            try{
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(DEFAULTFILE)));
                FileWriter writer = new FileWriter(Paths.get(locationFolder + "/" + FOLDERNAME + "/" + FILENAME).toString());
                BufferedWriter out = new BufferedWriter(writer);
                String line = inputReader.readLine();
                while (line != null){
                    line = line + "\n";
                    out.write(line);
                    line = inputReader.readLine();
                }
                inputReader.close();
                out.close();
                //JOptionPane.showMessageDialog(null, inputReader.lines().count());
            }catch(IOException ioe){
                System.err.println("inputexception");
            }
        }
        
        //bestaand bestand inlezen
        configFile = new File(configFilePath.toString());
    }
    
    @Override
    public void initConfiguration() {
        //read the file
        if(configFile != null){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(configFile));
                boolean readingData = false;
                String key = "";
                String line = reader.readLine();
                
                while(line != null){
                    if(line.contains("}")){
                        readingData = false;
                    }
                    if(readingData){
                        if(key != null || !key.isEmpty()){
                            configurationItems.putValue(key, line);
                        }
                    }
                    if(line.contains("{")){
                        readingData = true;
                        key = line.subSequence(0, line.indexOf("{")).toString().trim();
                        configurationItems.addKey(key);
                    }
                    line = reader.readLine();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        //set the settings of the game
        setInitialSettings();
    }
    
    private void setInitialSettings(){
        try{
            Setting<Resolution> set = configurationItems.getSetting(RESOLUTION);
            selectedResolution = set.getValue();
            System.out.printf("i have found a resolution with width: %d and height: %d\n", selectedResolution.getWidth(), selectedResolution.getHeight());
        }catch(Exception e){
            System.err.println("something went wrong. :(\nI'm sorry... :p here have a cookie");
        }
    }

    @Override
    public boolean addeptConfigValue(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveConfigFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Resolution> getResolutions(){
        return configurationItems.getResolutions();
    }
    
    @Override
    public Resolution getResolution(){
        return selectedResolution;
    }

    @Override
    public void toLowerResolution() {
        selectedResolution = configurationItems.getLowerResolution(selectedResolution);
    }

    @Override
    public void toHigherResolution() {
        selectedResolution = configurationItems.getHigherResolution(selectedResolution);
    }
}
