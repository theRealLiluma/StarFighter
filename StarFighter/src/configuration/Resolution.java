package configuration;

public class Resolution {
    private int width;
    private int height;
    
    public Resolution(int width, int height){
        setWidth(width);
        setHeight(height);
    }
    
    private void setWidth(int width){
        if(width > 0){
            this.width = width;
        }
        else{
            this.width = 0;
        }
    }
    
    private void setHeight(int height){
        if(height > 0){
            this.height = height;
        }
        else{
            this.height = 0;
        }
    }
}
