package utility;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            InputStream fontStream = new BufferedInputStream(new FileInputStream(FONTLOCATION));
            //File fontFile = new File(FONTLOCATION);
            //create the font to use. Specify the size!
            //font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            /*GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(font);
        }catch (FontFormatException ffe){
            ffe.printStackTrace();
        */}catch (FileNotFoundException fnfe){
            System.err.println("can't open file");
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            System.err.println("error reading file");
            ioe.printStackTrace();
        }
    }
    
    public Font getFont(){
        return font;
    }
    
    public static FontInitializer getInstance(){
        if(instance == null)
            instance = new FontInitializer();
        
        return instance;
    }
}
