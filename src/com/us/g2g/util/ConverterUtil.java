package com.us.g2g.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Encoder;

public class ConverterUtil {

	public static String imageToString(ByteArrayOutputStream bos) {
		String imageString = "";
		
           try {
               byte[] imageBytes = bos.toByteArray();
               BASE64Encoder encoder = new BASE64Encoder();
               imageString = encoder.encode(imageBytes);
               bos.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
		
        return imageString;
	}

}
