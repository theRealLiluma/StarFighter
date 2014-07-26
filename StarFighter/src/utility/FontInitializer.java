package utility;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;


/**
 *
 * @author nathan
 */
public class FontInitializer {
    private Font font;
    private final String FONTLOCATION = "/assets/fonts/spaceage.ttf";
    private static FontInitializer instance;
    
    private FontInitializer(){
        try {
            InputStream fontStream = getClass().getResourceAsStream(FONTLOCATION);
            //File fontFile = new File(FONTLOCATION);
            //create the font to use. Specify the size!
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(font);
        }catch (Exception fnfe){
            System.err.println("can't open file");
            fnfe.printStackTrace();
        }
    }
    
    public Font getFont(){
        return font.deriveFont(18f);
    }
    
    public static FontInitializer getInstance(){
        if(instance == null)
            instance = new FontInitializer();
        
        return instance;
    }
}
