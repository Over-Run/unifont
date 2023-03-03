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

package org.overrun.unifont;

/**
 * The utilities of Unifont.
 *
 * @author squid233
 * @since 0.1.0
 */
public final class UnifontUtil {
    /**
     * The path of Plane 0 image.
     */
    public static final String PLANE0 = "assets/_overrun/fonts/unifont.png";
    /**
     * The path of Plane 0 image for Japanese glyphs.
     */
    public static final String PLANE0_JP = "assets/_overrun/fonts/unifont_jp.png";
    /**
     * The path of Plane 1 image.
     */
    public static final String PLANE1 = "assets/_overrun/fonts/unifont_plane1.png";
    /**
     * The width and height of the image.
     */
    public static final int IMAGE_SIZE = 4096;
    private static final float INV_IMAGE_SIZE = 1.0f / IMAGE_SIZE;

    /**
     * Gets the x advance for the given codepoint.
     *
     * @param codePoint the codepoint.
     * @return the x advance.
     */
    public static int xAdvance(int codePoint) {
        if (codePoint >= ' ' && codePoint <= '~') return 8;
        if (codePoint == 0x200C) return 0;
        return 16;
    }

    /**
     * Gets the y advance.
     *
     * @return the y advance.
     */
    public static int yAdvance() {
        return 16;
    }

    /**
     * Gets the x offset of the given codepoint.
     *
     * @param codePoint the codepoint.
     * @return the x offset.
     */
    public static int xOffset(int codePoint) {
        return (codePoint % 0x10000 % 0x100) * 16;
    }

    /**
     * Gets the y offset of the given codepoint.
     *
     * @param codePoint the codepoint.
     * @return the y offset.
     */
    public static int yOffset(int codePoint) {
        return (codePoint % 0x10000) / 0x100 * 16;
    }

    /**
     * Normalizes the given UV offset.
     *
     * @param offset the offset of the image.
     * @return the normalized UV.
     */
    public static float uv(int offset) {
        return (float) offset * INV_IMAGE_SIZE;
    }
}
