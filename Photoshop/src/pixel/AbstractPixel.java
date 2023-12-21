package pixel;

/**
 * Abstract class representing a Pixel, all pixels have a position x,y. Inherits methods from the
 * Pixel interface.
 */
abstract class AbstractPixel implements Pixel {
  protected int x;
  protected int y;
  protected int[] colors;

  AbstractPixel(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int value() {
    int max = 0;
    for (int i : colors) {
      if (i > max) {
        max = i;
      }
    }

    return max;
  }

  @Override
  public int intensity() {
    int avg = 0;

    for (int i : colors) {
      avg += i;
    }

    return (int) (avg / 3.0);
  }

  @Override
  public double luma() {
    return (colors[0] * 0.2126) + (colors[1] * 0.7152) + (colors[2] * 0.0722);
  }

  private void setAll(int n) {
    this.colors[0] = n;
    this.colors[1] = n;
    this.colors[2] = n;
  }

  @Override
  public void convert(String s) {
    switch (s) {
      case "red":
        setAll(this.colors[0]);
        break;
      case "green":
        setAll(this.colors[1]);
        break;
      case "blue":
        setAll(this.colors[2]);
        break;
      case "value":
        int val = value();
        setAll(val);
        break;
      case "intensity":
        int intensity = intensity();
        setAll(intensity);
        break;
      case "luma":
        int luma = (int) luma();
        setAll(luma);
        break;
      default:
        System.out.println("unknown command");
        break;
    }
  }

  @Override
  public void brighten(int n) {
    if (n >= 0) {
      this.colors[0] = this.colors[0] + n;
      this.colors[1] = this.colors[1] + n;
      this.colors[2] = this.colors[2] + n;
      for (int i = 0; i < this.colors.length; i++) {
        if (colors[i] > 255) {
          colors[i] = 255;
        }
      }
    } else {
      throw new IllegalArgumentException("given n does not brighten image.");
    }
  }

  @Override
  public void darken(int n) {
    if (n >= 0) {
      this.colors[0] = this.colors[0] - n;
      this.colors[1] = this.colors[1] - n;
      this.colors[2] = this.colors[2] - n;
      for (int i = 0; i < this.colors.length; i++) {
        if (colors[i] < 0) {
          colors[i] = 0;
        }
      }
    } else {
      throw new IllegalArgumentException("given n does not darken image");
    }
  }


  @Override
  public String getColors() {
    return "\n" + this.colors[0] + "\n" + this.colors[1] + "\n" + this.colors[2] + "\n";
  }

  @Override
  public int[] getColorArr() {
    return this.colors;
  }

  @Override
  public String toString() {
    return "x: " + this.x + " y: " + this.y +
            " Red: " + this.colors[0] + " Green: " + this.colors[1] + " Blue: " + this.colors[2];
  }
}
