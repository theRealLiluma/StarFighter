package configuration;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author nathan
 */
public class ConfigurationLoaderWindows implements Configuration{
    private File configFile;
    private String locationFolder;
    private final String FOLDERNAME = "starfighter";
    private final String FILENAME = "starfighterconfig";
    private final String DEFAULTFILE = "assets/config/defaultConfig.conf";
    
    public ConfigurationLoaderWindows(){
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
    }
    
    private void loadConfigFile(){
        //controleren of er een configfile aanwezig is
        Path configFilePath = Paths.get(locationFolder + "/" + FOLDERNAME + "/" + FILENAME);
        if(Files.exists(configFilePath)){
            //bestaand bestand inlezen
            configFile = new File(configFilePath.toString());
        }else {
            //default bestand kopieren en inlezen
            InputStream is = this.getClass().getResourceAsStream(DEFAULTFILE);

        }
    }
    
    @Override
    public void initConfiguration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addeptConfigValue(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveConfigFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
