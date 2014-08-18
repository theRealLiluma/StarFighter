package configuration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathan
 */
public class ConfigurationHandler {
    private static ConfigurationHandler instance;
    private Configuration config;
    
    private ConfigurationHandler(){
        if(System.getProperty("os.name").contains("Windows")){
            config = new ConfigurationLoaderWindows();
        }
    }
    
    public String[] getResolutions(){
        List<Resolution> resolutions = config.getResolutions();
        String[] resolutionsList = new String[resolutions.size()];
        String resolution;
        
        for(int i = 0; i < resolutions.size(); i++){
            Resolution r = resolutions.get(i);
            resolution = String.format("%d\t%d", r.getWidth(), r.getHeight());
            resolutionsList[i] = resolution;
        }
        
        return resolutionsList;
    }
    
    public void initConfig(){
        
    }
    
    public static ConfigurationHandler getInstance(){
        if(instance == null)
            instance = new ConfigurationHandler();
        
        return instance;
    }
}
