package pixel;

/**
 * Class representing an RGB Pixel, such that it has three color values red, green, blue. Extends
 * an Abstract Pixel.
 */
public class RGBPixel extends AbstractPixel {

  /**
   * Constructor for an RGB Pixel that takes arguments for all its fields.
   *
   * @param i     The x position of the pixel
   * @param j     The y position of the pixel
   * @param red   The red value of the pixel (bounded by 0-255)
   * @param green The green value of the pixel (bounded by 0-255)
   * @param blue  The blue value of the pixel (bounded by 0-255)
   */
  public RGBPixel(int i, int j, int red, int green, int blue) {
    super(i, j);

    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Color vals not valid");
    }

    this.colors = new int[3];
    this.colors[0] = red;
    this.colors[1] = green;
    this.colors[2] = blue;
  }
}
