package imagemodel;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;

import pixel.PNGPixel;
import pixel.Pixel;
import pixel.RGBPixel;


/**
 * Class representing an ImageModel. The Hashmap holds images with a name, and its 2D array of
 * pixels. Operations can be done on these images. When an operation is done, the altered
 * version of the image is put into the hashmap.
 */
public class ImageModel implements IImageModel {
  private HashMap<String, Pixel[][]> images;

  /**
   * Constructor for an ImageModel FOR TESTING PURPOSES.
   *
   * @param pixels   pixels of an image.
   * @param fileName file name of an image.
   * @throws IllegalArgumentException when arguments are null.
   */
  // for testing
  public ImageModel(Pixel[][] pixels, String fileName) throws IllegalArgumentException {
    if (pixels == null || fileName == null) {
      throw new IllegalArgumentException("pixels and/or filename is null");
    }
    this.images = new HashMap<String, Pixel[][]>();
    this.images.put(fileName, pixels);
  }

  /**
   * Returns the map FOR TESTING PURPOSES.
   *
   * @return the model's hashmap.
   */
  public HashMap<String, Pixel[][]> getMapForTesting() {
    return this.images;
  }

  /**
   * Two arg constructor for an ImageModel. Automatically loads a file into the hashmap.
   *
   * @param path     The path of the image.
   * @param fileName The key for the image's 2D pixel array.
   * @throws IllegalArgumentException when arguments are null.
   */
  public ImageModel(String path, String fileName) throws IllegalArgumentException {
    if (path == null || fileName == null) {
      throw new IllegalArgumentException("path and/or file name is null.");
    }
    this.images = new HashMap<String, Pixel[][]>();
    load(path, fileName);
  }


  /**
   * No arg constructor for an ImageMode. Instantiates the hashmap.
   */
  public ImageModel() {
    this.images = new HashMap<String, Pixel[][]>();
  }

  /**
   * Converts an image's color values into its red component.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void redGrayScale(String oldName, String newName) {
    Pixel[][] temp = this.images.get(oldName);
    for (Pixel[] p : temp) {
      for (Pixel p2 : p) {
        p2.convert("red");
      }
    }

    images.put(newName, temp);
  }

  /**
   * Converts an image's color values into its green component.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void greenGrayScale(String oldName, String newName) {
    Pixel[][] temp = this.images.get(oldName);
    for (Pixel[] p : temp) {
      for (Pixel p2 : p) {
        p2.convert("green");
      }
    }
    images.put(newName, temp);
  }

  /**
   * Converts an image's color values into its blue component.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void blueGrayScale(String oldName, String newName) {
    Pixel[][] temp = this.images.get(oldName);
    for (Pixel[] p : temp) {
      for (Pixel p2 : p) {
        p2.convert("blue");
      }
    }
    images.put(newName, temp);
  }

  /**
   * Converts an image's color values into its Value.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void valueGrayScale(String oldName, String newName) {
    Pixel[][] temp = this.images.get(oldName);
    for (Pixel[] p : temp) {
      for (Pixel p2 : p) {
        p2.convert("value");
      }
    }
    images.put(newName, temp);
  }

  /**
   * Converts an image's color values into its Intensity.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void intensityGrayScale(String oldName, String newName) {
    Pixel[][] temp = this.images.get(oldName);
    for (Pixel[] p : temp) {
      for (Pixel p2 : p) {
        p2.convert("intensity");
      }
    }
    images.put(newName, temp);
  }

  /**
   * Converts an image's color values into its Luma.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void lumaGrayScale(String oldName, String newName) {
    Pixel[][] temp = this.images.get(oldName);
    for (Pixel[] p : temp) {
      for (Pixel p2 : p) {
        p2.convert("luma");
      }
    }
    images.put(newName, temp);
  }

  /**
   * Flips an image horicolorIndexontally.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void horizontalFlip(String oldName, String newName) {
    Pixel[][] temp = new Pixel[this.images.get(oldName).length][this.images.get(oldName)[0].length];
    for (int i = 0; i < this.images.get(oldName).length; i++) {
      int n = 0;
      for (int j = this.images.get(oldName)[0].length - 1; j >= 0; j--) {
        temp[i][n] = this.images.get(oldName)[i][j];
        n++;
      }
    }
    this.images.put(newName, temp);
  }

  /**
   * Flips an image vertically.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void verticalFlip(String oldName, String newName) {
    Pixel[][] temp = new Pixel[this.images.get(oldName).length][this.images.get(oldName)[0].length];
    int n = 0;
    for (int i = this.images.get(oldName).length - 1; i >= 0; i--) {
      temp[n] = this.images.get(oldName)[i];
      n++;
    }
    this.images.put(newName, temp);
  }

  /**
   * Brightens an image by some integer.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void brighten(int n, String oldName, String newName) {
    Pixel[][] temp = this.images.get(oldName);
    for (Pixel[] p : temp) {
      for (Pixel a : p) {
        a.brighten(n);
      }
    }
    this.images.put(newName, temp);
  }

  /**
   * Darkens an image by some integer.
   *
   * @param oldName The image to convert.
   * @param newName The new key where the converted image is mapped to.
   */
  public void darken(int n, String oldName, String newName) {
    Pixel[][] temp = this.images.get(oldName);
    for (Pixel[] p : temp) {
      for (Pixel a : p) {
        a.darken(n);
      }
    }
    this.images.put(newName, temp);
  }

  /**
   * Loads an image from a specified location and maps its pixels to a given name.
   *
   * @param path     The image to load.
   * @param filename The new key where the image is mapped to.
   */
  @Override
  public void load(String path, String filename) {
    int index = path.indexOf('.');
    String fileType = path.substring(index);

    switch (fileType) {
      case ".ppm":
        loadPPM(path, filename);
        break;
      case ".jpg":
      case ".jpeg":
      case ".bmp":
        loadJPG(path, filename);
        break;
      case ".png":
        loadPNG(path, filename);
        break;
      default:
        System.out.println("Unsupported file type: " + fileType);
        break;
    }
  }

  private void loadJPG(String path, String filename) {
    RGBPixel[][] pixels = null;
    Scanner sc = null;
    BufferedImage image = null;

    try {
      image = ImageIO.read(new FileInputStream(path));
    } catch (IOException e) {
      System.out.println("File " + path + " not found!");
      return;
    }

    if (image != null) {
      pixels = new RGBPixel[image.getHeight()][image.getWidth()];
      for (int i = 0; i < image.getWidth(); i++) {
        for (int j = 0; j < image.getHeight(); j++) {
          Color c = new Color(image.getRGB(i, j));
          pixels[j][i] = new RGBPixel(j, i, c.getRed(), c.getGreen(), c.getBlue());
        }
      }
    }

    this.images.put(filename, pixels);
  }

  private void loadPNG(String path, String filename) {
    Pixel[][] pixels = null;
    Scanner sc = null;
    BufferedImage image = null;

    try {
      image = ImageIO.read(new FileInputStream(path));
    } catch (IOException e) {
      System.out.println("File " + path + " not found!");
      return;
    }

    if (image != null) {
      pixels = new PNGPixel[image.getHeight()][image.getWidth()];
      for (int i = 0; i < image.getWidth(); i++) {
        for (int j = 0; j < image.getHeight(); j++) {
          Color c = new Color(image.getRGB(i, j), true);
          pixels[j][i] = new PNGPixel(j, i, c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
        }
      }
    }

    this.images.put(filename, pixels);
  }

  private void loadPPM(String path, String filename) {
    RGBPixel[][] pixels;
    Scanner sc = null;
    try {
      sc = new Scanner(new FileInputStream(path));
    } catch (FileNotFoundException e) {
      System.out.println("File " + path + " not found!");
      return;
    }


    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxVal = sc.nextInt();
    pixels = new RGBPixel[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        pixels[i][j] = new RGBPixel(i, j, r, g, b);
      }
    }

    this.images.put(filename, pixels);
  }

  /**
   * Saves an image at a specified destination.
   *
   * @param oldName The image to save.
   * @param newName The destination where the image should be saved.
   */
  @Override
  public void save(String oldName, String newName) throws IOException {
    String type = null;
    try {
      type = newName.substring(newName.indexOf('.'));
    } catch (StringIndexOutOfBoundsException e) {
      System.out.println("Path does not contain file type at the end ex. '.png', '.jpg', '.ppm'");
      return;
    }
    switch (type.toLowerCase()) {
      case ".ppm":
        savePPM(oldName, newName);
        break;
      case ".jpg":
      case ".jpeg":
      case ".bmp":
        saveRGB(type.substring(1), oldName, newName);
        break;
      case ".png":
        savePNG(oldName, newName);
        break;
      default:
        System.out.println("Unsupported file type: " + type);
    }
  }

  /**
   * Returns a BufferedImage based on the image name.
   *
   * @param fileName the name of the image to create a bufferedImage from.
   * @return A bufferedImage.
   */
  public BufferedImage pixelsToBufferedImage(String fileName) {
    Pixel[][] pixels = this.images.get(fileName);
    BufferedImage image =
            new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_INT_ARGB);

    for (int i = 0; i < pixels[0].length; i++) {
      for (int j = 0; j < pixels.length; j++) {
        Pixel temp = pixels[j][i];
        int[] colors = temp.getColorArr();
        Color c;
        if (colors.length < 4) {
          c = new Color(colors[0], colors[1], colors[2], 255);
        } else {
          c = new Color(colors[0], colors[1], colors[2], colors[3]);
        }
        image.setRGB(i, j, c.getRGB());
      }
    }

    return image;
  }

  private void savePNG(String oldName, String newName) {
    BufferedImage save = pixelsToBufferedImage(oldName);

    try {
      ImageIO.write(save, "png", new File(newName));
    } catch (IOException e) {
      System.out.println("Could not save file: " + newName);
    }
  }

  private void saveRGB(String type, String oldName, String newName) {
    Pixel[][] image = this.images.get(oldName);
    BufferedImage save =
            new BufferedImage(image[0].length, image.length, BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i < image[0].length; i++) {
      for (int j = 0; j < image.length; j++) {
        Pixel temp = image[j][i];
        int[] colors = temp.getColorArr();
        Color c = new Color(colors[0], colors[1], colors[2]);
        save.setRGB(i, j, c.getRGB());
      }
    }

    try {
      ImageIO.write(save, type, new File(newName));
    } catch (IOException e) {
      System.out.println("Could not save file: " + newName);
    }
  }

  private void savePPM(String oldName, String newName) throws IOException {
    Pixel[][] pixels = this.images.get(oldName);
    int height = pixels.length;
    int width = pixels[0].length;
    File file = new File(newName);

    FileWriter writer = new FileWriter(file);
    writer.write("P3\n");
    writer.write(width + " " + height + "\n");
    writer.write("255"); //fix this
    for (Pixel[] p : pixels) {
      for (Pixel p2 : p) {
        writer.write(p2.getColors());
      }
    }

    writer.close();
  }

  /**
   * Returns whether an image exists in the model's map.
   *
   * @param fileName the name of the image that you're checking if it exists.
   */
  public boolean isLoaded(String fileName) {
    try {
      return images.containsKey(fileName);
    } catch (NullPointerException n) {
      return false;
    }
  }

  /**
   * Blurs an image.
   *
   * @param oldName The image to save.
   * @param newName The key where the new image is mapped to.
   */
  public void blur(String oldName, String newName) {
    double[][] matrix = new double[][]{{0.0625, 0.125, 0.0625},
      {0.125, 0.25, 0.125},
      {0.0625, 0.125, 0.0625}};

    Pixel[][] temp = applyMatrix(matrix, oldName);
    this.images.put(newName, temp);
  }

  /**
   * Sharpens an image.
   *
   * @param oldName The image to save.
   * @param newName The key where the new image is mapped to.
   */
  public void sharpen(String oldName, String newName) {
    double[][] matrix = new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
      {-0.125, 0.25, 0.25, 0.25, -0.125},
      {-0.125, 0.25, 1, 0.25, -0.125},
      {-0.125, 0.25, 0.25, 0.25, -0.125},
      {-0.125, -0.125, -0.125, -0.125, -0.125}};
    Pixel[][] temp = applyMatrix(matrix, oldName);
    this.images.put(newName, temp);
  }

  /**
   * Applies a sepia filter to an image.
   *
   * @param oldName The image to save.
   * @param newName The key where the new image is mapped to.
   */
  public void sepia(String oldName, String newName) {
    double[][] matrix = new double[][]{{0.393, 0.769, 0.189},
      {0.349, 0.686, 0.168},
      {0.272, 0.534, 0.131}};
    Pixel[][] temp = applyTransformation(matrix, oldName);
    this.images.put(newName, temp);
  }

  /**
   * Turns an image grayscale.
   *
   * @param oldName The image to save.
   * @param newName The key where the new image is mapped to.
   */
  public void grayscale(String oldName, String newName) {
    double[][] matrix = new double[][]{{0.2126, 0.7152, 0.0722},
      {0.2126, 0.7152, 0.0722},
      {0.2126, 0.7152, 0.0722}};
    Pixel[][] temp = applyTransformation(matrix, oldName);
    this.images.put(newName, temp);
  }

  private Pixel[][] applyTransformation(double[][] transformation, String fileName) {
    Pixel[][] image = this.images.get(fileName);
    boolean alpha = image[0][0].getColorArr().length > 3;
    Pixel[][] builderImage = new Pixel[image.length][image[0].length];
    for (int pixelRow = 0; pixelRow < image.length; pixelRow++) {
      for (int pixelCol = 0; pixelCol < image[0].length; pixelCol++) {

        Pixel temp = image[pixelRow][pixelCol];
        int[] colors = new int[]{0, 0, 0};
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            colors[i] += temp.getColorArr()[j] * transformation[i][j];
          }
        }

        for (int x = 0; x < 3; x++) {
          if (colors[x] > 255) {
            colors[x] = 255;
          } else if (colors[x] < 0) {
            colors[x] = 0;
          }
        }

        if (alpha) {
          builderImage[pixelRow][pixelCol] =
                  new PNGPixel(pixelRow, pixelCol, colors[0], colors[1], colors[2],
                          image[pixelRow][pixelCol].getColorArr()[3]);
        } else {
          builderImage[pixelRow][pixelCol] =
                  new RGBPixel(pixelRow, pixelCol, colors[0], colors[1], colors[2]);
        }
      }
    }

    return builderImage;
  }

  private Pixel[][] applyMatrix(double[][] filter, String fileName) {
    Pixel[][] image = this.images.get(fileName);
    boolean alpha = image[0][0].getColorArr().length > 3;
    Pixel[][] builderImage = new Pixel[image.length][image[0].length];
    for (int pixelRow = 0; pixelRow < image.length; pixelRow++) {
      for (int pixelCol = 0; pixelCol < image[0].length; pixelCol++) {

        // the array of pixels that will have the transform applied to it
        Pixel[][] temp = new Pixel[filter.length][filter[0].length];

        //loads the matrix of pixels which will be transformed by the filter
        int tempRow = 0;
        for (int x = -temp.length / 2; x <= temp.length / 2; x++) {
          int tempCol = 0;
          for (int y = -temp[0].length / 2; y <= temp[0].length / 2; y++) {
            int translationRow = x;
            int translationCol = y;
            if (pixelRow + x < 0 || pixelRow + x > image.length - 2) {
              translationRow = 0;
            }
            if (pixelCol + y < 0 || pixelCol + y > image[0].length - 2) {
              translationCol = 0;
            }
            temp[tempRow][tempCol] = image[pixelRow + translationRow][pixelCol + translationCol];
            tempCol++;
          }
          tempRow++;
        }

        // creates the new pixel with the transformation
        int[] colors = new int[]{0, 0, 0, 0};
        for (int colorIndex = 0; colorIndex < 3; colorIndex++) {
          for (int b = 0; b < temp.length; b++) {
            for (int a = 0; a < temp[0].length; a++) {
              colors[colorIndex] += temp[b][a].getColorArr()[colorIndex] * filter[b][a];
            }
          }
        }

        for (int i = 0; i < colors.length; i++) {
          if (colors[i] > 255) {
            colors[i] = 255;
          } else if (colors[i] < 0) {
            colors[i] = 0;
          }
        }

        if (alpha) {
          builderImage[pixelRow][pixelCol] =
                  new PNGPixel(pixelRow, pixelCol, colors[0], colors[1], colors[2],
                          image[pixelRow][pixelCol].getColorArr()[3]);
        } else {
          builderImage[pixelRow][pixelCol] =
                  new RGBPixel(pixelRow, pixelCol, colors[0], colors[1], colors[2]);
        }
      }
    }

    return builderImage;
  }

  /**
   * Gets a histogram of a certain color channel, represented as an array of integers.
   *
   * @param fileName the name of the image to get the histogram from.
   * @param color    the color channel that the histogram represents.
   * @return array of integers representing a histogram with one color channel.
   */
  public int[] getHistogram(String fileName, String color) {
    int[] vals = null;
    switch (color) {
      case "red":
        vals = binVals(fileName, 0);
        break;
      case "green":
        vals = binVals(fileName, 1);
        break;
      case "blue":
        vals = binVals(fileName, 2);
        break;
      case "intensity": {
        vals = binVals(fileName, 3);
        break;
      }
      default:
        break;
    }
    return vals;
  }

  // bins the color values of an image into 0-255 based on a color channel.
  private int[] binVals(String fileName, int index) {
    Pixel[][] image = this.images.get(fileName);
    int[] arr = new int[256];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = 0;
    }

    int colorVal = 0;
    if (index < 3) {
      for (int i = 0; i < image.length; i++) {
        for (int j = 0; j < image[0].length; j++) {
          colorVal = image[i][j].getColorArr()[index];
          arr[colorVal] += 1;
        }
      }
    } else {
      for (int i = 0; i < image.length; i++) {
        for (int j = 0; j < image[0].length; j++) {
          int[] colors = image[i][j].getColorArr();
          colorVal = (colors[0] + colors[1] + colors[2]) / 3;
          arr[colorVal] += 1;
        }
      }
    }
    return arr;
  }

  /**
   * Downscales an image based on the given size.
   * @param oldName name of the image to downscale.
   * @param newName the name of the new downscaled image.
   * @param scaleType the type of downscale 'small' 'medium' or 'large'.
   */
  public void downscale(String oldName, String newName, String scaleType) {
    switch (scaleType) {
      case "large":
        downscaleHelper(oldName, newName, 0.95);
        break;
      case "medium":
        downscaleHelper(oldName, newName, 0.9);
        break;
      case "small":
        downscaleHelper(oldName, newName, 0.8);
        break;
      default:
        System.out.println("Must be 'large' 'medium' or 'small'");
        break;

    }

  }

  private void downscaleHelper(String oldName, String newName, double scale) {
    Pixel[][] origImage = this.images.get(oldName);
    Pixel[][] downscaledImage = new RGBPixel[(int) (origImage.length * scale)]
            [(int) (origImage[0].length * scale)];

    for (int i = 0; i < downscaledImage.length; i++) {
      for (int j = 0; j < downscaledImage[0].length; j++) {
        downscaledImage[i][j] = pollPixel(i, j, origImage, scale);
      }
    }

    this.images.put(newName, downscaledImage);
  }

  private Pixel pollPixel(int y, int x, Pixel[][] origImage, double scale) {
    Pixel[][] matrix = new Pixel[3][3];
    int originy = (int) (y * scale);
    int originx = (int) (x * scale);

    int n1 = 0;
    for (int i = -1; i <= 1; i++) {
      int n2 = 0;
      for (int j = -1; j <= 1; j++) {
        try {
          matrix[n1][n2] = origImage[originy + i][originx + j];
        } catch (ArrayIndexOutOfBoundsException e) {
          matrix[n1][n2] = null;
        }
      }
      n1++;
    }

    int numberOfPixels = 0;
    int totalRed = 0;
    int totalGreen = 0;
    int totalBlue = 0;
    for (int n = 0; n < 3; n++) {
      for (int m = 0; m < 3; m++) {
        if (matrix[n][m] != null) {
          numberOfPixels++;
          Pixel temp = matrix[n][m];
          int[] colors = temp.getColorArr();

          totalRed += colors[0];
          totalGreen += colors[1];
          totalBlue += colors[2];
        }
      }
    }

    int avgRed = (int) ((double) totalRed / (double) numberOfPixels);
    int avgGreen = (int) ((double) totalGreen / (double) numberOfPixels);
    int avgBlue = (int) ((double) totalBlue / (double) numberOfPixels);

    return new RGBPixel(x, y, avgRed, avgGreen, avgBlue);
  }
}
