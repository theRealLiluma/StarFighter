package configuration;

public class Setting<E>{
    /* variables */
    private String key;
    private E value;
    
    public Setting(String key, E value){
        setKey(key);
        setValue(value);
    }
    
    private void setKey(String key){
        this.key = key;
    }
    
    private void setValue(E value){
        this.value = value;
    }
    
    public E getValue(){
        return value;
    }
    
    public String getKey(){
        return key;
    }
}
