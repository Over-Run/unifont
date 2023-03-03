package org.overrun.unifont;

/**
 * The constants of Unifont.
 *
 * @author squid233
 * @since 0.1.0
 */
public final class UnifontConst {
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
     * Normalizes the given UV offset.
     *
     * @param uv the offset of the image.
     * @return the normalized UV.
     */
    public static float uv(int uv) {
        return (float) uv * INV_IMAGE_SIZE;
    }
}
