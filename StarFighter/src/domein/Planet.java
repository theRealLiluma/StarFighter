package domein;

import java.util.List;

public class Planet {
    private String name;
    private List<Planet> linkedPlanets;
    
    public Planet(String name){
        setName(name);
    }
    
    private void setName(String name){
        this.name = name;
    }
}
