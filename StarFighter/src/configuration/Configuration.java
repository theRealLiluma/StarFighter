package configuration;

/**
 *
 * @author nathan
 */
public interface Configuration {
    public void initConfiguration();
    public boolean addeptConfigValue(String key, String value);
    public boolean saveConfigFile();
}
