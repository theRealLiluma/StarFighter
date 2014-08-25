package configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConfigurationItems {
    private HashMap<String, List> configs;
    private final String RESOLUTIONS = "resolutions";
    private final String SETTINGS = "settings";
    private final String RESOLUTION = "resolution";
    
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
            case RESOLUTIONS: 
                addResolution(key,values);
                break;
            case SETTINGS:
                addSetting(key, values);
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
    
    private void addSetting(String key, String values){
        String[] settingList = values.split(":");
        String settingKey = settingList[0];
        String settingValue = settingList[1];
        Setting set;
        Resolution res;
        
        /* verwerken van value aan de hand van settingkey */
        switch(settingKey){
            case RESOLUTION:
                String[] sizes = settingValue.split("X");
                int width = Integer.parseInt(sizes[0]);
                int height = Integer.parseInt(sizes[1]);
                res = new Resolution (width, height);
                set = new Setting<Resolution>(settingKey, res);
                /* setting toevoegen aan list */
                List settings = configs.get(key);
                settings.add(set);
                break;
                
            default:
                break;
        }
    }
    
    public Setting getSetting(String settingkey){
        List<Setting> settings = configs.get(SETTINGS);
        Setting set = null;
        for(int i = 0; i < settings.size(); i++){
            set = settings.get(i);
            if(set.getKey().equals(settingkey))
                break;
        }
        return set;
    }
    
    public List<Resolution> getResolutions(){
        return configs.get(RESOLUTION);
    }
    
    public Resolution getLowerResolution(Resolution current){
        List<Resolution> resolutions = configs.get(RESOLUTIONS);
        //laagste element ophalen
        Resolution res = resolutions.get(0);
        if(res.getWidth() == current.getWidth() && res.getHeight() == current.getHeight()){
            return resolutions.get(resolutions.size() - 1);
        }else{
            for(int i = resolutions.size() -1; i >= 0; i--){
                res = resolutions.get(i);
                if(res.getWidth() < current.getWidth() && res.getHeight() < current.getHeight())
                    return res;
            }
        }
        return null;
    }
    
    public Resolution getHigherResolution(Resolution current){
        List<Resolution> resolutions = configs.get(RESOLUTIONS);   
        Resolution res = resolutions.get(resolutions.size() -1);
        
        if(res.getWidth() == current.getWidth() && res.getHeight() == current.getHeight()){
            return resolutions.get(0);
        }else{
            for(int i = 1; i < resolutions.size(); i++){
                res = resolutions.get(i);
                if(res.getWidth() > current.getWidth() && res.getHeight() > current.getHeight())
                    return res;
            }
        }
        return null;
    }
}
