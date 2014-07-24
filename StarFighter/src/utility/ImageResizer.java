package utility;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author nathan
 */
public class ImageResizer {
    //variables
    private static ImageResizer instance;
    
    //constructor
    private ImageResizer(){
        
    }
    
    //public methodes
    public BufferedImage resizeImage(BufferedImage image, int targetWidth, int targetHeight){
        int imageWidth  = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleX = (double)targetWidth/imageWidth;
        double scaleY = (double)targetHeight/imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

        return bilinearScaleOp.filter(image, new BufferedImage(targetWidth, targetHeight, image.getType()));
    }
    
    public static ImageResizer getInstance(){
        if(instance == null)
            instance = new ImageResizer();
        
        return instance;
    }
}
