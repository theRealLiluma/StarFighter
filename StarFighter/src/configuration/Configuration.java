package configuration;

import java.util.List;

public interface Configuration {
    public void initConfiguration();
    public void saveConfigFile();
    public List<Resolution> getResolutions();
    public Resolution getResolution();
    public void toLowerResolution();
    public void toHigherResolution();
}
