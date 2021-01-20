package com.ydprojects.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDownloadUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ImageDownloadUtil.class);

    public static void downloadImage(String imageUrl, String imageName, String dirName){
        BufferedImage image =null;
        try {
            URL url = new URL(imageUrl);
            image = ImageIO.read(url);
            new File("src/test/resources/images/"+dirName+"").mkdirs();
            ImageIO.write(image, "jpg",new File("src/test/resources/images/"+dirName+"/"+imageName+".jpg"));

        } catch (IOException e) {
            LOG.trace("{}",e);
        }
    }
}
