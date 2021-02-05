package com.ydprojects.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageDownloadUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ImageDownloadUtil.class);

    public static boolean downloadImage(String imageUrl, String imageName, String dirName){
        boolean isDownloaded = false;
        BufferedImage image =null;
        String imageDownloadPath = "src/test/resources/images/"+dirName+"/"+imageName+".jpg";
        try {
            URL url = new URL(imageUrl);
            image = ImageIO.read(url);
            new File("src/test/resources/images/"+dirName+"").mkdirs();
            ImageIO.write(image, "jpg",new File(imageDownloadPath));

            File file = new File(imageDownloadPath);
            isDownloaded = file.exists();

        } catch (IOException e) {
            LOG.trace("{}",e);
        }

        return isDownloaded;
    }
}
