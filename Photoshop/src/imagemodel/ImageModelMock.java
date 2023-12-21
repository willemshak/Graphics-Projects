package imagemodel;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Mock of an ImageModel, for testing purposes.
 */
public class ImageModelMock implements IImageModel {
  private Appendable a;

  ImageModelMock(Appendable a) {
    this.a = a;
  }

  public ImageModelMock() {
    this.a = new StringBuilder();
  }

  @Override
  public void redGrayScale(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void greenGrayScale(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void blueGrayScale(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void valueGrayScale(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void intensityGrayScale(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void lumaGrayScale(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void horizontalFlip(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void verticalFlip(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void brighten(int n, String oldName, String newName) {
    try {
      a.append(n + " " + oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void darken(int n, String oldName, String newName) {
    try {
      a.append(n + " " + oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void save(String oldName, String newName) throws IOException {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void load(String path, String filename) {
    try {
      a.append(path + " " + filename);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean isLoaded(String fileName) {
    try {
      a.append(fileName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return fileName.equals("true");
  }

  @Override
  public void blur(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void sharpen(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void sepia(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void grayscale(String oldName, String newName) {
    try {
      a.append(oldName + " " + newName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int[] getHistogram(String fileName, String color) {
    try {
      a.append(fileName + " " + color);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return new int[1];
  }

  @Override
  public BufferedImage pixelsToBufferedImage(String fileName) {
    try {
      a.append(fileName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return new BufferedImage(0, 0, BufferedImage.TYPE_INT_ARGB);
  }

  @Override
  public void downscale(String oldName, String newName, String scaleType) {
    try {
      a.append(oldName + newName + scaleType);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return this.a.toString();
  }
}
