import GUI.OuterFrame;
import configuration.ConfigurationHandler;
import domein.DomeinController;

/**
 *
 * @author nathan
 */
public class Init {
    public static void main(String args[]){
        //controleren van aanwezigheid configuration file en init of laden van config file
        ConfigurationHandler.getInstance().initConfig();
        
        //laden van frame en panels.
        OuterFrame frame = new OuterFrame();
        frame.toStartPanel();
    }
}
