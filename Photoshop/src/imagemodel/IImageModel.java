package imagemodel;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Interface for an IImageModel, has many operations to do on a model. Whenever an operation is
 * executed, it creates a new image in the model. The 2D array of Pixels represents an image.
 */
public interface IImageModel {

  /**
   * Converts an image's color values into its red component.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void redGrayScale(String oldName, String newName);

  /**
   * Converts an image's color values into its green component.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void greenGrayScale(String oldName, String newName);

  /**
   * Converts an image's color values into its blue component.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void blueGrayScale(String oldName, String newName);

  /**
   * Converts an image's color values into its Value.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void valueGrayScale(String oldName, String newName);

  /**
   * Converts an image's color values into its Intensity.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void intensityGrayScale(String oldName, String newName);

  /**
   * Converts an image's color values into its Luma.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void lumaGrayScale(String oldName, String newName);

  /**
   * Flips an image horizontally.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void horizontalFlip(String oldName, String newName);

  /**
   * Flips an image vertically.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void verticalFlip(String oldName, String newName);

  /**
   * Brightens an image by some integer.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void brighten(int n, String oldName, String newName);

  /**
   * Darkens an image by some integer.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  void darken(int n, String oldName, String newName);

  /**
   * Saves an image at a specified destination.
   *
   * @param oldName The image to save.
   * @param newName The destination where the image should be saved.
   */
  void save(String oldName, String newName) throws IOException;


  /**
   * Loads an image from a specified location and maps its pixels to a given name.
   *
   * @param path The image to load.
   * @param filename The new key where the image is mapped to.
   */
  void load(String path, String filename);

  /**
   * Returns whether an image exists in the model's map.
   *
   * @param fileName the name of the image that you're checking if it exists.
   */
  boolean isLoaded(String fileName);

  /**
   * Blurs an image.
   *
   * @param oldName The image to save.
   * @param newName The key where the new image is mapped to.
   */
  void blur(String oldName, String newName);

  /**
   * Sharpens an image.
   *
   * @param oldName The image to save.
   * @param newName The key where the new image is mapped to.
   */
  void sharpen(String oldName, String newName);

  /**
   * Applies a sepia filter to an image.
   *
   * @param oldName The image to save.
   * @param newName The key where the new image is mapped to.
   */
  void sepia(String oldName, String newName);

  /**
   * Turns an image grayscale.
   *
   * @param oldName The image to save.
   * @param newName The key where the new image is mapped to.
   */
  void grayscale(String oldName, String newName);

  /**
   * Gets a histogram of an image.
   *
   * @param fileName the name of the image to get the histogram from.
   * @param color the color channel that the histogram represents.
   * @return an array representing a histogram of an image for a certain color channel.
   */
  int[] getHistogram(String fileName, String color);

  /**
   * Returns a BufferedImage based on the image name.
   * @param fileName the name of the image to create a bufferedImage from.
   * @return A bufferedImage.
   */
  BufferedImage pixelsToBufferedImage(String fileName);

  /**
   * Downscales an image based on the given size.
   * @param oldName name of the image to downscale.
   * @param newName the name of the new downscaled image.
   * @param scaleType the type of downscale 'small' 'medium' or 'large'.
   */
  void downscale(String oldName, String newName, String scaleType);
}
