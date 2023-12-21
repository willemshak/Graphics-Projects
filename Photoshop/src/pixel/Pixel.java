package pixel;

/**
 * Interface for a Pixel in an image where you can pull different values,
 * brighten, darken, and convert all its values.
 */
public interface Pixel {

  /**
   * The value, or maximum color value of the pixel.
   *
   * @return maximum of the color values of the pixel.
   */
  int value();

  /**
   * The intensity, or average of the color values of the pixel.
   *
   * @return average of the color values of the pixel.
   */
  int intensity();

  /**
   * The luma of the color values of the pixel.
   * Calculated by 0.0216 * red + 0.7152 * green + 0.0722  * blue.
   *
   * @return The luma value of the pixel.
   */
  double luma();

  /**
   * Brightens the color values of the pixel by some integer.
   *
   * @param n The amount to brighten the pixel's color values by.
   */
  void brighten(int n);

  /**
   * Darkens the color values of the pixel by some integer.
   *
   * @param n The amount to darken the pixel's color values by.
   */
  void darken(int n);

  /**
   * Converts all the values of the pixel based on the String given to it (i.e. if its "value",
   * then all the values will be turned to "value".
   *
   * @param s The type of value to replace all the pixel's colors with.
   */
  void convert(String s);

  /**
   * Returns a string of the colors for creating the save file.
   *
   * @return String of the colors and values separated by new lines.
   */
  String getColors();

  int[] getColorArr();
}
