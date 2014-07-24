import GUI.OuterFrame;
import domein.DomeinController;

/**
 *
 * @author nathan
 */
public class Init {
    public static void main(String args[]){
        OuterFrame frame = new OuterFrame(new DomeinController());
        frame.toStartPanel();
    }
}
