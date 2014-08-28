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
    
    public void editResolution(E value){
        setValue(value);
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(key);
        builder.append(":");
        builder.append(value.toString());
        //builder.append("\n");
        return builder.toString();
    }
}
