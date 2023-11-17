/*
 * MIT License
 *
 * Copyright (c) 2023 Overrun Organization
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A data validator that validates the images.
 *
 * @author squid233
 * @since 15.1.01.1
 */
public class DataValidator {
    private static void validate(String path) throws IOException {
        final BufferedImage image = ImageIO.read(new File(path));
        final int width = image.getWidth();
        final int height = image.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                final int argb = image.getRGB(x, y);
                if (argb != 0xffffffff && argb != 0xff000000) {
                    System.out.println(path.substring(path.lastIndexOf('/') + 1) + ": " + "Invalid data 0x" + Integer.toHexString(argb) + " at x: " + x + ", y: " + y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        validate("src/main/resources/assets/_overrun/fonts/unifont.png");
        validate("src/main/resources/assets/_overrun/fonts/unifont_jp.png");
        validate("src/main/resources/assets/_overrun/fonts/unifont_plane1.png");
    }
}
