package configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConfigurationItems {
    private HashMap<String, List> configs;
    
    public ConfigurationItems(){
        configs = new HashMap<String, List>();
    }
    
    public boolean addKey(String key){
        if(!configs.containsKey(key)){
            configs.put(key, new ArrayList());
            return true;
        }
        return false;
    }
    
    public void putValue(String key, String values){
        switch(key){
            case "resolutions": 
                addResolution(key,values);
                break;
            default: 
                break;
        }
    }
    
    private void addResolution(String key, String values){
        //splits in de twee integers ==> width en height;
        String[] sizes = values.split("X");
        int width = Integer.parseInt(sizes[0]);
        int height = Integer.parseInt(sizes[1]);
        Resolution res = new Resolution (width, height);
        
        List resolutions = configs.get(key);
        resolutions.add(res);
    }
}
