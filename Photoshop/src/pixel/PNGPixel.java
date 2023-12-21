package pixel;

/**
 * Class representing a pixel with an alpha value as well as RGB.
 */
public class PNGPixel extends AbstractPixel {
  /**
   * Constructor for a PNG Pixel.
   *
   * @param x     x position of the pixel
   * @param y     y position of the pixel
   * @param red   red value of the pixel
   * @param green green value of the pixel
   * @param blue  blue value of the pixel
   * @param alpha alpha value of the pixel
   */
  public PNGPixel(int x, int y, int red, int green, int blue, int alpha) {
    super(x, y);

    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255
            || alpha < 0 || alpha > 255) {
      throw new IllegalArgumentException("Color vals not valid");
    }

    this.colors = new int[4];
    this.colors[0] = red;
    this.colors[1] = green;
    this.colors[2] = blue;
    this.colors[3] = alpha;
  }
}
