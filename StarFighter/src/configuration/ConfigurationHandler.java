package configuration;

import java.util.List;

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
            resolution = String.format("%d * %d", r.getWidth(), r.getHeight());
            resolutionsList[i] = resolution;
        }
        
        return resolutionsList;
    }
    
    public void initConfig(){
        
    }
    
    public Resolution getResolution(){
        return config.getResolution();
    }
    
    public String getResolutionText(){
        Resolution res = getResolution();
        String returnValue = String.format("%d  --  %d", res.getWidth(), res.getHeight());
        return returnValue;
    }
    
    public static ConfigurationHandler getInstance(){
        if(instance == null)
            instance = new ConfigurationHandler();
        
        return instance;
    }
}
