package GUI;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author nathan
 */
public class CursorSelector {
    private final HashMap<String, Cursor> cursors;
    private static CursorSelector instance;
    
    private CursorSelector(){
        //selection point for the cursor:
        Point selectSpot = new Point(0,0);  
        cursors = new HashMap<String, Cursor>();
        
        //nieuwe image voor de custom cursor
        Image cursorImage;
        
        //default cursor:
        cursorImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("assets/images/cursor/swordCursor.png"));
        cursors.put("default", Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, selectSpot, "defaultCursor"));
    }
    
    public Cursor getRequestedCursor(String keyValue){
        if(!cursors.containsKey(keyValue))
            return cursors.get("default");
        
        return cursors.get(keyValue);
    }
    
    public static CursorSelector getInstance(){
        if(instance == null)
            instance = new CursorSelector();
        
        return instance;
    }
}
