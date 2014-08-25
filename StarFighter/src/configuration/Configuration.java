package configuration;

import java.util.List;

/**
 *
 * @author nathan
 */
public interface Configuration {
    public void initConfiguration();
    public boolean addeptConfigValue(String key, String value);
    public boolean saveConfigFile();
    public List<Resolution> getResolutions();
    public Resolution getResolution();
    public void toLowerResolution();
    public void toHigherResolution();
}
