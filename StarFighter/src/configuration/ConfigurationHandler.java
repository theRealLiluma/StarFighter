package configuration;

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
    
    public void initConfig(){
        
    }
    
    public static ConfigurationHandler getInstance(){
        if(instance == null)
            instance = new ConfigurationHandler();
        
        return instance;
    }
}
