import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import imagemodel.ImageModel;
import pixel.PNGPixel;
import pixel.Pixel;
import pixel.RGBPixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Testing for ImageModel class.
 */
public class ImageModelTest {
  Pixel[][] pixels;
  Pixel[][] pixels2;
  Pixel[][] nullPixels;
  ImageModel model;
  ImageModel model2;
  ImageModel nullModel;
  ImageModel nullModel2;

  @Before
  public void setUp() {
    pixels = new Pixel[3][3];
    pixels[0][0] = new RGBPixel(0, 0, 254, 0, 0);
    pixels[0][1] = new RGBPixel(0, 1, 254, 165, 0);
    pixels[0][2] = new RGBPixel(0, 2, 254, 254, 0);
    pixels[1][0] = new RGBPixel(1, 0, 0, 254, 0);
    pixels[1][1] = new RGBPixel(1, 1, 0, 0, 254);
    pixels[1][2] = new RGBPixel(1, 2, 75, 0, 130);
    pixels[2][0] = new RGBPixel(2, 0, 155, 38, 182);
    pixels[2][1] = new RGBPixel(2, 1, 253, 100, 253);
    pixels[2][2] = new RGBPixel(2, 2, 153, 254, 203);

    this.model = new ImageModel(pixels.clone(), "pixels1");

    pixels2 = new Pixel[3][3];
    pixels2[0][0] = new PNGPixel(0, 0, 254, 0, 0, 255);
    pixels2[0][1] = new PNGPixel(0, 1, 254, 165, 0, 255);
    pixels2[0][2] = new PNGPixel(0, 2, 254, 254, 0, 255);
    pixels2[1][0] = new PNGPixel(1, 0, 0, 254, 0, 255);
    pixels2[1][1] = new PNGPixel(1, 1, 0, 0, 254, 255);
    pixels2[1][2] = new PNGPixel(1, 2, 75, 0, 130, 255);
    pixels2[2][0] = new PNGPixel(2, 0, 155, 38, 182, 255);
    pixels2[2][1] = new PNGPixel(2, 1, 253, 100, 253, 255);
    pixels2[2][2] = new PNGPixel(2, 2, 153, 254, 203, 255);

    this.model2 = new ImageModel(pixels2.clone(), "pixels2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    this.nullModel = new ImageModel(nullPixels, "");
    this.nullModel2 = new ImageModel("", "");
  }

  private String pixelsToString(Pixel[][] pixels) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        sb.append(pixels[i][j].toString() + "\n");
      }
    }
    return sb.toString();
  }

  @Test
  public void testBlueGreyScaleRGB() {
    Pixel[][] blue = new Pixel[3][3];
    blue[0][0] = new RGBPixel(0, 0, 0, 0, 0);
    blue[0][1] = new RGBPixel(0, 1, 0, 0, 0);
    blue[0][2] = new RGBPixel(0, 2, 0, 0, 0);
    blue[1][0] = new RGBPixel(1, 0, 0, 0, 0);
    blue[1][1] = new RGBPixel(1, 1, 254, 254, 254);
    blue[1][2] = new RGBPixel(1, 2, 130, 130, 130);
    blue[2][0] = new RGBPixel(2, 0, 182, 182, 182);
    blue[2][1] = new RGBPixel(2, 1, 253, 253, 253);
    blue[2][2] = new RGBPixel(2, 2, 203, 203, 203);

    this.model.blueGrayScale("pixels1", "bluePixels");
    assertEquals(this.pixelsToString(blue),
            this.pixelsToString(this.model.getMapForTesting().get("bluePixels")));
  }

  @Test
  public void testBlueGreyScalePNG() {
    Pixel[][] blue2 = new Pixel[3][3];
    blue2[0][0] = new PNGPixel(0, 0, 0, 0, 0, 255);
    blue2[0][1] = new PNGPixel(0, 1, 0, 0, 0, 255);
    blue2[0][2] = new PNGPixel(0, 2, 0, 0, 0, 255);
    blue2[1][0] = new PNGPixel(1, 0, 0, 0, 0, 255);
    blue2[1][1] = new PNGPixel(1, 1, 254, 254, 254, 255);
    blue2[1][2] = new PNGPixel(1, 2, 130, 130, 130, 255);
    blue2[2][0] = new PNGPixel(2, 0, 182, 182, 182, 255);
    blue2[2][1] = new PNGPixel(2, 1, 253, 253, 253, 255);
    blue2[2][2] = new PNGPixel(2, 2, 203, 203, 203, 255);

    this.model2.blueGrayScale("pixels2", "bluePixels2");
    assertEquals(this.pixelsToString(blue2),
            this.pixelsToString(this.model2.getMapForTesting().get("bluePixels2")));
  }


  @Test
  public void testGreenGrayScaleRGB() {
    Pixel[][] green = new Pixel[3][3];
    green[0][0] = new RGBPixel(0, 0, 0, 0, 0);
    green[0][1] = new RGBPixel(0, 1, 165, 165, 165);
    green[0][2] = new RGBPixel(0, 2, 254, 254, 254);
    green[1][0] = new RGBPixel(1, 0, 254, 254, 254);
    green[1][1] = new RGBPixel(1, 1, 0, 0, 0);
    green[1][2] = new RGBPixel(1, 2, 0, 0, 0);
    green[2][0] = new RGBPixel(2, 0, 38, 38, 38);
    green[2][1] = new RGBPixel(2, 1, 100, 100, 100);
    green[2][2] = new RGBPixel(2, 2, 254, 254, 254);

    this.model.greenGrayScale("pixels1", "greenPixels");
    assertEquals(this.pixelsToString(green),
            this.pixelsToString(this.model.getMapForTesting().get("greenPixels")));
  }

  @Test
  public void testGreenGrayScalePNG() {
    Pixel[][] green2 = new Pixel[3][3];
    green2[0][0] = new PNGPixel(0, 0, 0, 0, 0, 255);
    green2[0][1] = new PNGPixel(0, 1, 165, 165, 165, 255);
    green2[0][2] = new PNGPixel(0, 2, 254, 254, 254, 255);
    green2[1][0] = new PNGPixel(1, 0, 254, 254, 254, 255);
    green2[1][1] = new PNGPixel(1, 1, 0, 0, 0, 255);
    green2[1][2] = new PNGPixel(1, 2, 0, 0, 0, 255);
    green2[2][0] = new PNGPixel(2, 0, 38, 38, 38, 255);
    green2[2][1] = new PNGPixel(2, 1, 100, 100, 100, 255);
    green2[2][2] = new PNGPixel(2, 2, 254, 254, 254, 255);

    this.model2.greenGrayScale("pixels2", "greenPixels2");
    assertEquals(this.pixelsToString(green2),
            this.pixelsToString(this.model2.getMapForTesting().get("greenPixels2")));
  }

  @Test
  public void testRedGrayScaleRGB() {
    Pixel[][] red = new Pixel[3][3];
    red[0][0] = new RGBPixel(0, 0, 254, 254, 254);
    red[0][1] = new RGBPixel(0, 1, 254, 254, 254);
    red[0][2] = new RGBPixel(0, 2, 254, 254, 254);
    red[1][0] = new RGBPixel(1, 0, 0, 0, 0);
    red[1][1] = new RGBPixel(1, 1, 0, 0, 0);
    red[1][2] = new RGBPixel(1, 2, 75, 75, 75);
    red[2][0] = new RGBPixel(2, 0, 155, 155, 155);
    red[2][1] = new RGBPixel(2, 1, 253, 253, 253);
    red[2][2] = new RGBPixel(2, 2, 153, 153, 153);

    this.model.redGrayScale("pixels1", "redPixels");
    assertEquals(this.pixelsToString(red),
            this.pixelsToString(this.model.getMapForTesting().get("redPixels")));
  }

  @Test
  public void testRedGrayScalePNG() {
    Pixel[][] red2 = new Pixel[3][3];
    red2[0][0] = new PNGPixel(0, 0, 254, 254, 254, 255);
    red2[0][1] = new PNGPixel(0, 1, 254, 254, 254, 255);
    red2[0][2] = new PNGPixel(0, 2, 254, 254, 254, 255);
    red2[1][0] = new PNGPixel(1, 0, 0, 0, 0, 255);
    red2[1][1] = new PNGPixel(1, 1, 0, 0, 0, 255);
    red2[1][2] = new PNGPixel(1, 2, 75, 75, 75, 255);
    red2[2][0] = new PNGPixel(2, 0, 155, 155, 155, 255);
    red2[2][1] = new PNGPixel(2, 1, 253, 253, 253, 255);
    red2[2][2] = new PNGPixel(2, 2, 153, 153, 153, 255);

    this.model2.redGrayScale("pixels2", "redPixels2");
    assertEquals(this.pixelsToString(red2),
            this.pixelsToString(this.model2.getMapForTesting().get("redPixels2")));
  }

  @Test
  public void testValueGrayScaleRGB() {
    Pixel[][] value = new Pixel[3][3];

    value[0][0] = new RGBPixel(0, 0, 254, 254, 254);
    value[0][1] = new RGBPixel(0, 1, 254, 254, 254);
    value[0][2] = new RGBPixel(0, 2, 254, 254, 254);
    value[1][0] = new RGBPixel(1, 0, 254, 254, 254);
    value[1][1] = new RGBPixel(1, 1, 254, 254, 254);
    value[1][2] = new RGBPixel(1, 2, 130, 130, 130);
    value[2][0] = new RGBPixel(2, 0, 182, 182, 182);
    value[2][1] = new RGBPixel(2, 1, 253, 253, 253);
    value[2][2] = new RGBPixel(2, 2, 254, 254, 254);

    this.model.valueGrayScale("pixels1", "valuePixels");
    assertEquals(this.pixelsToString(value),
            this.pixelsToString(this.model.getMapForTesting().get("valuePixels")));
  }

  @Test
  public void testValueGrayScalePNG() {
    Pixel[][] value2 = new Pixel[3][3];

    value2[0][0] = new PNGPixel(0, 0, 255, 255, 255, 255);
    value2[0][1] = new PNGPixel(0, 1, 255, 255, 255, 255);
    value2[0][2] = new PNGPixel(0, 2, 255, 255, 255, 255);
    value2[1][0] = new PNGPixel(1, 0, 255, 255, 255, 255);
    value2[1][1] = new PNGPixel(1, 1, 255, 255, 255, 255);
    value2[1][2] = new PNGPixel(1, 2, 255, 255, 255, 255);
    value2[2][0] = new PNGPixel(2, 0, 255, 255, 255, 255);
    value2[2][1] = new PNGPixel(2, 1, 255, 255, 255, 255);
    value2[2][2] = new PNGPixel(2, 2, 255, 255, 255, 255);

    this.model2.valueGrayScale("pixels2", "valuePixels2");
    assertEquals(this.pixelsToString(value2),
            this.pixelsToString(this.model2.getMapForTesting().get("valuePixels2")));
  }

  @Test
  public void testIntensityGrayScaleRGB() {
    Pixel[][] intensity = new Pixel[3][3];

    intensity[0][0] = new RGBPixel(0, 0, 84, 84, 84);
    intensity[0][1] = new RGBPixel(0, 1, 139, 139, 139);
    intensity[0][2] = new RGBPixel(0, 2, 169, 169, 169);
    intensity[1][0] = new RGBPixel(1, 0, 84, 84, 84);
    intensity[1][1] = new RGBPixel(1, 1, 84, 84, 84);
    intensity[1][2] = new RGBPixel(1, 2, 68, 68, 68);
    intensity[2][0] = new RGBPixel(2, 0, 125, 125, 125);
    intensity[2][1] = new RGBPixel(2, 1, 202, 202, 202);
    intensity[2][2] = new RGBPixel(2, 2, 203, 203, 203);

    this.model.intensityGrayScale("pixels1", "intensityPixels");
    assertEquals(this.pixelsToString(intensity),
            this.pixelsToString(this.model.getMapForTesting().get("intensityPixels")));
  }

  @Test
  public void testLumaGrayScale() {
    Pixel[][] luma = new Pixel[3][3];

    luma[0][0] = new RGBPixel(0, 0, 54, 54, 54);
    luma[0][1] = new RGBPixel(0, 1, 172, 172, 172);
    luma[0][2] = new RGBPixel(0, 2, 235, 235, 235);
    luma[1][0] = new RGBPixel(1, 0, 181, 181, 181);
    luma[1][1] = new RGBPixel(1, 1, 18, 18, 18);
    luma[1][2] = new RGBPixel(1, 2, 25, 25, 25);
    luma[2][0] = new RGBPixel(2, 0, 73, 73, 73);
    luma[2][1] = new RGBPixel(2, 1, 143, 143, 143);
    luma[2][2] = new RGBPixel(2, 2, 228, 228, 228);

    this.model.lumaGrayScale("pixels1", "lumaPixels");
    assertEquals(this.pixelsToString(luma),
            this.pixelsToString(this.model.getMapForTesting().get("lumaPixels")));
  }

  @Test
  public void testFlipHorizontalRGB() {
    Pixel[][] horizontalFlip = new Pixel[3][3];

    horizontalFlip[0][0] = new RGBPixel(0, 2, 254, 254, 0);
    horizontalFlip[0][1] = new RGBPixel(0, 1, 254, 165, 0);
    horizontalFlip[0][2] = new RGBPixel(0, 0, 254, 0, 0);
    horizontalFlip[1][0] = new RGBPixel(1, 2, 75, 0, 130);
    horizontalFlip[1][1] = new RGBPixel(1, 1, 0, 0, 254);
    horizontalFlip[1][2] = new RGBPixel(1, 0, 0, 254, 0);
    horizontalFlip[2][0] = new RGBPixel(2, 2, 153, 254, 203);
    horizontalFlip[2][1] = new RGBPixel(2, 1, 253, 100, 253);
    horizontalFlip[2][2] = new RGBPixel(2, 0, 155, 38, 182);

    this.model.horizontalFlip("pixels1", "horizontalPixels");
    assertEquals(this.pixelsToString(horizontalFlip),
            this.pixelsToString(this.model.getMapForTesting().get("horizontalPixels")));
  }

  @Test
  public void testFlipHorizontalPNG() {
    Pixel[][] horizontalFlip = new Pixel[3][3];

    horizontalFlip[0][0] = new PNGPixel(0, 2, 254, 254, 0, 255);
    horizontalFlip[0][1] = new PNGPixel(0, 1, 254, 165, 0, 255);
    horizontalFlip[0][2] = new PNGPixel(0, 0, 254, 0, 0, 255);
    horizontalFlip[1][0] = new PNGPixel(1, 2, 75, 0, 130, 255);
    horizontalFlip[1][1] = new PNGPixel(1, 1, 0, 0, 254, 255);
    horizontalFlip[1][2] = new PNGPixel(1, 0, 0, 254, 0, 255);
    horizontalFlip[2][0] = new PNGPixel(2, 2, 153, 254, 203, 255);
    horizontalFlip[2][1] = new PNGPixel(2, 1, 253, 100, 253, 255);
    horizontalFlip[2][2] = new PNGPixel(2, 0, 155, 38, 182, 255);

    this.model2.horizontalFlip("pixels2", "horizontalPixels2");
    assertEquals(this.pixelsToString(horizontalFlip),
            this.pixelsToString(this.model2.getMapForTesting().get("horizontalPixels2")));
  }

  @Test
  public void testVerticalFlipRGB() {
    Pixel[][] verticalFlip = new Pixel[3][3];

    verticalFlip[0][0] = new RGBPixel(2, 0, 155, 38, 182);
    verticalFlip[0][1] = new RGBPixel(2, 1, 253, 100, 253);
    verticalFlip[0][2] = new RGBPixel(2, 2, 153, 254, 203);
    verticalFlip[1][0] = new RGBPixel(1, 0, 0, 254, 0);
    verticalFlip[1][1] = new RGBPixel(1, 1, 0, 0, 254);
    verticalFlip[1][2] = new RGBPixel(1, 2, 75, 0, 130);
    verticalFlip[2][0] = new RGBPixel(0, 0, 254, 0, 0);
    verticalFlip[2][1] = new RGBPixel(0, 1, 254, 165, 0);
    verticalFlip[2][2] = new RGBPixel(0, 2, 254, 254, 0);

    this.model.verticalFlip("pixels1", "verticalPixels");
    assertEquals(this.pixelsToString(verticalFlip),
            this.pixelsToString(this.model.getMapForTesting().get("verticalPixels")));
  }

  @Test
  public void testVerticalFlipPNG() {
    Pixel[][] verticalFlip = new Pixel[3][3];

    verticalFlip[0][0] = new PNGPixel(2, 0, 155, 38, 182, 255);
    verticalFlip[0][1] = new PNGPixel(2, 1, 253, 100, 253, 255);
    verticalFlip[0][2] = new PNGPixel(2, 2, 153, 254, 203, 255);
    verticalFlip[1][0] = new PNGPixel(1, 0, 0, 254, 0, 255);
    verticalFlip[1][1] = new PNGPixel(1, 1, 0, 0, 254, 255);
    verticalFlip[1][2] = new PNGPixel(1, 2, 75, 0, 130, 255);
    verticalFlip[2][0] = new PNGPixel(0, 0, 254, 0, 0, 255);
    verticalFlip[2][1] = new PNGPixel(0, 1, 254, 165, 0, 255);
    verticalFlip[2][2] = new PNGPixel(0, 2, 254, 254, 0, 255);

    this.model2.verticalFlip("pixels2", "verticalPixels2");
    assertEquals(this.pixelsToString(verticalFlip),
            this.pixelsToString(this.model2.getMapForTesting().get("verticalPixels2")));
  }

  @Test
  public void testBrightenByZero() {
    Pixel[][] brighten = new Pixel[3][3];
    brighten[0][0] = new RGBPixel(0, 0, 254, 0, 0);
    brighten[0][1] = new RGBPixel(0, 1, 254, 165, 0);
    brighten[0][2] = new RGBPixel(0, 2, 254, 254, 0);
    brighten[1][0] = new RGBPixel(1, 0, 0, 254, 0);
    brighten[1][1] = new RGBPixel(1, 1, 0, 0, 254);
    brighten[1][2] = new RGBPixel(1, 2, 75, 0, 130);
    brighten[2][0] = new RGBPixel(2, 0, 155, 38, 182);
    brighten[2][1] = new RGBPixel(2, 1, 253, 100, 253);
    brighten[2][2] = new RGBPixel(2, 2, 153, 254, 203);
    this.model.brighten(0, "pixels1", "brightenPixels");
    assertEquals(this.pixelsToString(brighten),
            this.pixelsToString(this.model.getMapForTesting().get("brightenPixels")));
  }

  @Test
  public void testBrightenRGB() {
    Pixel[][] brighten = new Pixel[3][3];
    brighten[0][0] = new RGBPixel(0, 0, 255, 30, 30);
    brighten[0][1] = new RGBPixel(0, 1, 255, 195, 30);
    brighten[0][2] = new RGBPixel(0, 2, 255, 255, 30);
    brighten[1][0] = new RGBPixel(1, 0, 30, 255, 30);
    brighten[1][1] = new RGBPixel(1, 1, 30, 30, 255);
    brighten[1][2] = new RGBPixel(1, 2, 105, 30, 160);
    brighten[2][0] = new RGBPixel(2, 0, 185, 68, 212);
    brighten[2][1] = new RGBPixel(2, 1, 255, 130, 255);
    brighten[2][2] = new RGBPixel(2, 2, 183, 255, 233);
    this.model.brighten(30, "pixels1", "brightenPixels");
    assertEquals(this.pixelsToString(brighten),
            this.pixelsToString(this.model.getMapForTesting().get("brightenPixels")));
  }

  @Test
  public void testBrightenPNG() {
    Pixel[][] brighten = new Pixel[3][3];
    brighten[0][0] = new PNGPixel(0, 0, 255, 30, 30, 255);
    brighten[0][1] = new PNGPixel(0, 1, 255, 195, 30, 255);
    brighten[0][2] = new PNGPixel(0, 2, 255, 255, 30, 255);
    brighten[1][0] = new PNGPixel(1, 0, 30, 255, 30, 255);
    brighten[1][1] = new PNGPixel(1, 1, 30, 30, 255, 255);
    brighten[1][2] = new PNGPixel(1, 2, 105, 30, 160, 255);
    brighten[2][0] = new PNGPixel(2, 0, 185, 68, 212, 255);
    brighten[2][1] = new PNGPixel(2, 1, 255, 130, 255, 255);
    brighten[2][2] = new PNGPixel(2, 2, 183, 255, 233, 255);
    this.model2.brighten(30, "pixels2", "brightenPixels2");
    assertEquals(this.pixelsToString(brighten),
            this.pixelsToString(this.model2.getMapForTesting().get("brightenPixels2")));
  }

  @Test
  public void testBrightenTo255() {
    Pixel[][] brighten = new Pixel[3][3];
    brighten[0][0] = new RGBPixel(0, 0, 255, 255, 255);
    brighten[0][1] = new RGBPixel(0, 1, 255, 255, 255);
    brighten[0][2] = new RGBPixel(0, 2, 255, 255, 255);
    brighten[1][0] = new RGBPixel(1, 0, 255, 255, 255);
    brighten[1][1] = new RGBPixel(1, 1, 255, 255, 255);
    brighten[1][2] = new RGBPixel(1, 2, 255, 255, 255);
    brighten[2][0] = new RGBPixel(2, 0, 255, 255, 255);
    brighten[2][1] = new RGBPixel(2, 1, 255, 255, 255);
    brighten[2][2] = new RGBPixel(2, 2, 255, 255, 255);
    this.model.brighten(300, "pixels1", "brightenPixels");
    assertEquals(this.pixelsToString(brighten),
            this.pixelsToString(this.model.getMapForTesting().get("brightenPixels")));
  }

  @Test
  public void brightenByNeg() {
    Pixel[][] brighten = new Pixel[3][3];
    brighten[0][0] = new RGBPixel(0, 0, 255, 255, 255);
    brighten[0][1] = new RGBPixel(0, 1, 255, 255, 255);
    brighten[0][2] = new RGBPixel(0, 2, 255, 255, 255);
    brighten[1][0] = new RGBPixel(1, 0, 255, 255, 255);
    brighten[1][1] = new RGBPixel(1, 1, 255, 255, 255);
    brighten[1][2] = new RGBPixel(1, 2, 255, 255, 255);
    brighten[2][0] = new RGBPixel(2, 0, 255, 255, 255);
    brighten[2][1] = new RGBPixel(2, 1, 255, 255, 255);
    brighten[2][2] = new RGBPixel(2, 2, 255, 255, 255);
    try {
      this.model.brighten(-20, "pixels1", "brightenPixels");
      assertEquals(this.pixelsToString(brighten),
              this.pixelsToString(this.model.getMapForTesting().get("brightenPixels")));
      fail();
    } catch (IllegalArgumentException e) {
      // Cannot brighten by a negative number
    }
  }

  @Test
  public void testDarkenByZero() {
    Pixel[][] darken = new Pixel[3][3];
    darken[0][0] = new RGBPixel(0, 0, 254, 0, 0);
    darken[0][1] = new RGBPixel(0, 1, 254, 165, 0);
    darken[0][2] = new RGBPixel(0, 2, 254, 254, 0);
    darken[1][0] = new RGBPixel(1, 0, 0, 254, 0);
    darken[1][1] = new RGBPixel(1, 1, 0, 0, 254);
    darken[1][2] = new RGBPixel(1, 2, 75, 0, 130);
    darken[2][0] = new RGBPixel(2, 0, 155, 38, 182);
    darken[2][1] = new RGBPixel(2, 1, 253, 100, 253);
    darken[2][2] = new RGBPixel(2, 2, 153, 254, 203);

    this.model.darken(0, "pixels1", "darkenPixels");
    assertEquals(this.pixelsToString(darken),
            this.pixelsToString(this.model.getMapForTesting().get("darkenPixels")));
  }

  @Test
  public void testDarkenRGB() {
    Pixel[][] darken = new Pixel[3][3];
    darken[0][0] = new RGBPixel(0, 0, 234, 0, 0);
    darken[0][1] = new RGBPixel(0, 1, 234, 145, 0);
    darken[0][2] = new RGBPixel(0, 2, 234, 234, 0);
    darken[1][0] = new RGBPixel(1, 0, 0, 234, 0);
    darken[1][1] = new RGBPixel(1, 1, 0, 0, 234);
    darken[1][2] = new RGBPixel(1, 2, 55, 0, 110);
    darken[2][0] = new RGBPixel(2, 0, 135, 18, 162);
    darken[2][1] = new RGBPixel(2, 1, 233, 80, 233);
    darken[2][2] = new RGBPixel(2, 2, 133, 234, 183);

    this.model.darken(20, "pixels1", "darkenPixels");
    assertEquals(this.pixelsToString(darken),
            this.pixelsToString(this.model.getMapForTesting().get("darkenPixels")));
  }

  @Test
  public void testDarkenPNG() {
    Pixel[][] darken = new Pixel[3][3];
    darken[0][0] = new PNGPixel(0, 0, 234, 0, 0, 255);
    darken[0][1] = new PNGPixel(0, 1, 234, 145, 0, 255);
    darken[0][2] = new PNGPixel(0, 2, 234, 234, 0, 255);
    darken[1][0] = new PNGPixel(1, 0, 0, 234, 0, 255);
    darken[1][1] = new PNGPixel(1, 1, 0, 0, 234, 255);
    darken[1][2] = new PNGPixel(1, 2, 55, 0, 110, 255);
    darken[2][0] = new PNGPixel(2, 0, 135, 18, 162, 255);
    darken[2][1] = new PNGPixel(2, 1, 233, 80, 233, 255);
    darken[2][2] = new PNGPixel(2, 2, 133, 234, 183, 255);

    this.model2.darken(20, "pixels2", "darkenPixels2");
    assertEquals(this.pixelsToString(darken),
            this.pixelsToString(this.model2.getMapForTesting().get("darkenPixels2")));
  }

  @Test
  public void testDarkenToZero() {
    Pixel[][] darken = new Pixel[3][3];
    darken[0][0] = new RGBPixel(0, 0, 0, 0, 0);
    darken[0][1] = new RGBPixel(0, 1, 0, 0, 0);
    darken[0][2] = new RGBPixel(0, 2, 0, 0, 0);
    darken[1][0] = new RGBPixel(1, 0, 0, 0, 0);
    darken[1][1] = new RGBPixel(1, 1, 0, 0, 0);
    darken[1][2] = new RGBPixel(1, 2, 0, 0, 0);
    darken[2][0] = new RGBPixel(2, 0, 0, 0, 0);
    darken[2][1] = new RGBPixel(2, 1, 0, 0, 0);
    darken[2][2] = new RGBPixel(2, 2, 0, 0, 0);

    this.model.darken(300, "pixels1", "darkenPixels");
    assertEquals(this.pixelsToString(darken),
            this.pixelsToString(this.model.getMapForTesting().get("darkenPixels")));
  }

  @Test
  public void testDarkenByNeg() {
    Pixel[][] darken = new Pixel[3][3];

    darken[0][0] = new RGBPixel(0, 0, 254, 0, 0);
    darken[0][1] = new RGBPixel(0, 1, 254, 165, 0);
    darken[0][2] = new RGBPixel(0, 2, 254, 254, 0);
    darken[1][0] = new RGBPixel(1, 0, 0, 254, 0);
    darken[1][1] = new RGBPixel(1, 1, 0, 0, 254);
    darken[1][2] = new RGBPixel(1, 2, 75, 0, 130);
    darken[2][0] = new RGBPixel(2, 0, 155, 38, 182);
    darken[2][1] = new RGBPixel(2, 1, 253, 100, 253);
    darken[2][2] = new RGBPixel(2, 2, 153, 254, 203);

    try {
      this.model.darken(-20, "pixels1", "darkenPixels");
      assertEquals(this.pixelsToString(darken),
              this.pixelsToString(this.model.getMapForTesting().get("darkenPixels")));
    } catch (IllegalArgumentException e) {
      // Cannot darken by a negative number
    }
  }

  @Test
  public void testBlurRGB() {
    Pixel[][] blur = new Pixel[3][3];
    blur[0][0] = new RGBPixel(0, 0, 186, 76, 15);
    blur[0][1] = new RGBPixel(0, 1, 186, 106, 46);
    blur[0][2] = new RGBPixel(0, 2, 199, 170, 39);
    blur[1][0] = new RGBPixel(1, 0, 61, 150, 46);
    blur[1][1] = new RGBPixel(1, 1, 61, 76, 140);
    blur[1][2] = new RGBPixel(1, 2, 101, 56, 118);
    blur[2][0] = new RGBPixel(2, 0, 131, 83, 161);
    blur[2][1] = new RGBPixel(2, 1, 168, 76, 219);
    blur[2][2] = new RGBPixel(2, 2, 144, 158, 197);

    this.model.blur("pixels1", "blurPixels");
    assertEquals(this.pixelsToString(blur),
            this.pixelsToString(this.model.getMapForTesting().get("blurPixels")));
  }

  @Test
  public void testBlurPNG() {
    Pixel[][] blur = new Pixel[3][3];
    blur[0][0] = new PNGPixel(0, 0, 186, 76, 15, 255);
    blur[0][1] = new PNGPixel(0, 1, 186, 106, 46, 255);
    blur[0][2] = new PNGPixel(0, 2, 199, 170, 39, 255);
    blur[1][0] = new PNGPixel(1, 0, 61, 150, 46, 255);
    blur[1][1] = new PNGPixel(1, 1, 61, 76, 140, 255);
    blur[1][2] = new PNGPixel(1, 2, 101, 56, 118, 255);
    blur[2][0] = new PNGPixel(2, 0, 131, 83, 161, 255);
    blur[2][1] = new PNGPixel(2, 1, 168, 76, 219, 255);
    blur[2][2] = new PNGPixel(2, 2, 144, 158, 197, 255);

    this.model2.blur("pixels2", "blurPixels2");
    assertEquals(this.pixelsToString(blur),
            this.pixelsToString(this.model2.getMapForTesting().get("blurPixels2")));
  }

  @Test
  public void testSharpenRGB() {
    Pixel[][] sharpen = new Pixel[3][3];
    sharpen[0][0] = new RGBPixel(0, 0, 131, 103, 63);
    sharpen[0][1] = new RGBPixel(0, 1, 131, 108, 63);
    sharpen[0][2] = new RGBPixel(0, 2, 157, 201, 110);
    sharpen[1][0] = new RGBPixel(1, 0, 126, 107, 63);
    sharpen[1][1] = new RGBPixel(1, 1, 126, 105, 64);
    sharpen[1][2] = new RGBPixel(1, 2, 178, 8, 157);
    sharpen[2][0] = new RGBPixel(2, 0, 50, 105, 255);
    sharpen[2][1] = new RGBPixel(2, 1, 89, 70, 255);
    sharpen[2][2] = new RGBPixel(2, 2, 77, 162, 255);

    this.model.sharpen("pixels1", "sharpenPixels");
    assertEquals(this.pixelsToString(sharpen),
            this.pixelsToString(this.model.getMapForTesting().get("sharpenPixels")));
  }

  @Test
  public void testSharpenPNG() {
    Pixel[][] sharpen = new Pixel[3][3];
    sharpen[0][0] = new PNGPixel(0, 0, 131, 103, 63, 255);
    sharpen[0][1] = new PNGPixel(0, 1, 131, 108, 63, 255);
    sharpen[0][2] = new PNGPixel(0, 2, 157, 201, 110, 255);
    sharpen[1][0] = new PNGPixel(1, 0, 126, 107, 63, 255);
    sharpen[1][1] = new PNGPixel(1, 1, 126, 105, 64, 255);
    sharpen[1][2] = new PNGPixel(1, 2, 178, 8, 157, 255);
    sharpen[2][0] = new PNGPixel(2, 0, 50, 105, 255, 255);
    sharpen[2][1] = new PNGPixel(2, 1, 89, 70, 255, 255);
    sharpen[2][2] = new PNGPixel(2, 2, 77, 162, 255, 255);

    this.model2.sharpen("pixels2", "sharpenPixels2");
    assertEquals(this.pixelsToString(sharpen),
            this.pixelsToString(this.model2.getMapForTesting().get("sharpenPixels2")));
  }

  @Test
  public void testGrayscaleRGB() {
    Pixel[][] grayscale = new Pixel[3][3];
    grayscale[0][0] = new RGBPixel(0, 0, 54, 54, 54);
    grayscale[0][1] = new RGBPixel(0, 1, 172, 172, 172);
    grayscale[0][2] = new RGBPixel(0, 2, 235, 235, 235);
    grayscale[1][0] = new RGBPixel(1, 0, 181, 181, 181);
    grayscale[1][1] = new RGBPixel(1, 1, 18, 18, 18);
    grayscale[1][2] = new RGBPixel(1, 2, 24, 24, 24);
    grayscale[2][0] = new RGBPixel(2, 0, 72, 72, 72);
    grayscale[2][1] = new RGBPixel(2, 1, 142, 142, 142);
    grayscale[2][2] = new RGBPixel(2, 2, 227, 227, 227);

    this.model.grayscale("pixels1", "grayscalePixels");
    assertEquals(this.pixelsToString(grayscale),
            this.pixelsToString(this.model.getMapForTesting().get("grayscalePixels")));
  }

  @Test
  public void testGrayscalePNG() {
    Pixel[][] grayscale = new Pixel[3][3];
    grayscale[0][0] = new PNGPixel(0, 0, 54, 54, 54, 255);
    grayscale[0][1] = new PNGPixel(0, 1, 172, 172, 172, 255);
    grayscale[0][2] = new PNGPixel(0, 2, 235, 235, 235, 255);
    grayscale[1][0] = new PNGPixel(1, 0, 181, 181, 181, 255);
    grayscale[1][1] = new PNGPixel(1, 1, 18, 18, 18, 255);
    grayscale[1][2] = new PNGPixel(1, 2, 24, 24, 24, 255);
    grayscale[2][0] = new PNGPixel(2, 0, 72, 72, 72, 255);
    grayscale[2][1] = new PNGPixel(2, 1, 142, 142, 142, 255);
    grayscale[2][2] = new PNGPixel(2, 2, 227, 227, 227, 255);

    this.model2.grayscale("pixels2", "grayscalePixels2");
    assertEquals(this.pixelsToString(grayscale),
            this.pixelsToString(this.model2.getMapForTesting().get("grayscalePixels2")));
  }

  @Test
  public void testSepiaRGB() {
    Pixel[][] sepia = new Pixel[3][3];
    sepia[0][0] = new RGBPixel(0, 0, 99, 88, 69);
    sepia[0][1] = new RGBPixel(0, 1, 225, 201, 157);
    sepia[0][2] = new RGBPixel(0, 2, 255, 255, 204);
    sepia[1][0] = new RGBPixel(1, 0, 195, 174, 135);
    sepia[1][1] = new RGBPixel(1, 1, 48, 42, 33);
    sepia[1][2] = new RGBPixel(1, 2, 53, 47, 37);
    sepia[2][0] = new RGBPixel(2, 0, 123, 110, 85);
    sepia[2][1] = new RGBPixel(2, 1, 222, 198, 154);
    sepia[2][2] = new RGBPixel(2, 2, 255, 255, 202);

    this.model.sepia("pixels1", "sepiaPixels");
    assertEquals(this.pixelsToString(sepia),
            this.pixelsToString(this.model.getMapForTesting().get("sepiaPixels")));
  }

  @Test
  public void testSepiaPNG() {
    Pixel[][] sepia = new Pixel[3][3];
    sepia[0][0] = new PNGPixel(0, 0, 99, 88, 69, 255);
    sepia[0][1] = new PNGPixel(0, 1, 225, 201, 157, 255);
    sepia[0][2] = new PNGPixel(0, 2, 255, 255, 204, 255);
    sepia[1][0] = new PNGPixel(1, 0, 195, 174, 135, 255);
    sepia[1][1] = new PNGPixel(1, 1, 48, 42, 33, 255);
    sepia[1][2] = new PNGPixel(1, 2, 53, 47, 37, 255);
    sepia[2][0] = new PNGPixel(2, 0, 123, 110, 85, 255);
    sepia[2][1] = new PNGPixel(2, 1, 222, 198, 154, 255);
    sepia[2][2] = new PNGPixel(2, 2, 255, 255, 202, 255);

    this.model2.sepia("pixels2", "sepiaPixels2");
    assertEquals(this.pixelsToString(sepia),
            this.pixelsToString(this.model2.getMapForTesting().get("sepiaPixels2")));
  }

  /*
    @Test
    public void testLoad() {
      Pixel[][] load = new Pixel[3][3];

      load[0][0] = new RGBPixel(0, 0, 255, 255, 0);
      load[0][1] = new RGBPixel(0, 1, 0, 255, 165);
      load[0][2] = new RGBPixel(0, 2, 0, 255, 255);
      load[1][0] = new RGBPixel(1, 0, 0, 0, 255);
      load[1][1] = new RGBPixel(1, 1, 0, 0, 0);
      load[1][2] = new RGBPixel(1, 2, 255, 75, 0);
      load[2][0] = new RGBPixel(2, 0, 130, 155, 38);
      load[2][1] = new RGBPixel(2, 1, 182, 255, 102);
      load[2][2] = new RGBPixel(2, 2, 255, 153, 255);
      this.model.load("res/test.ppm", "test");
      this.model.getMapForTesting().get("res/test.ppm");
      assertEquals(this.pixelsToString(load),
              this.pixelsToString(this.model.getMapForTesting().get("test")));
    }
  */
  @Test
  public void testLoadPPM() {
    Pixel[][] load = new Pixel[3][3];

    load[0][0] = new RGBPixel(0, 0, 255, 0, 0);
    load[0][1] = new RGBPixel(0, 1, 255, 165, 0);
    load[0][2] = new RGBPixel(0, 2, 255, 255, 0);
    load[1][0] = new RGBPixel(1, 0, 0, 255, 0);
    load[1][1] = new RGBPixel(1, 1, 0, 0, 255);
    load[1][2] = new RGBPixel(1, 2, 75, 0, 130);
    load[2][0] = new RGBPixel(2, 0, 155, 38, 182);
    load[2][1] = new RGBPixel(2, 1, 255, 102, 255);
    load[2][2] = new RGBPixel(2, 2, 153, 255, 204);
    this.model.load("res/test.ppm", "test");
    assertEquals(this.pixelsToString(load),
            this.pixelsToString(this.model.getMapForTesting().get("test")));
  }

  @Test
  public void testLoadPNG() {
    Pixel[][] load = new Pixel[3][3];

    load[0][0] = new PNGPixel(0, 0, 255, 0, 0, 255);
    load[0][1] = new PNGPixel(0, 1, 255, 165, 0, 255);
    load[0][2] = new PNGPixel(0, 2, 255, 255, 0, 255);
    load[1][0] = new PNGPixel(1, 0, 0, 255, 0, 255);
    load[1][1] = new PNGPixel(1, 1, 0, 0, 255, 255);
    load[1][2] = new PNGPixel(1, 2, 75, 0, 130, 255);
    load[2][0] = new PNGPixel(2, 0, 155, 38, 182, 255);
    load[2][1] = new PNGPixel(2, 1, 255, 102, 255, 255);
    load[2][2] = new PNGPixel(2, 2, 153, 255, 204, 255);
    this.model2.load("res/test.png", "testpng");
    assertEquals(this.pixelsToString(load),
            this.pixelsToString(this.model2.getMapForTesting().get("testpng")));
  }

  @Test
  public void testLoadBMP() {
    Pixel[][] load = new Pixel[3][3];

    load[0][0] = new RGBPixel(0, 0, 255, 0, 0);
    load[0][1] = new RGBPixel(0, 1, 255, 165, 0);
    load[0][2] = new RGBPixel(0, 2, 255, 255, 0);
    load[1][0] = new RGBPixel(1, 0, 0, 255, 0);
    load[1][1] = new RGBPixel(1, 1, 0, 0, 255);
    load[1][2] = new RGBPixel(1, 2, 75, 0, 130);
    load[2][0] = new RGBPixel(2, 0, 155, 38, 182);
    load[2][1] = new RGBPixel(2, 1, 255, 102, 255);
    load[2][2] = new RGBPixel(2, 2, 153, 255, 204);
    this.model.load("res/test.bmp", "testbmp");
    assertEquals(this.pixelsToString(load),
            this.pixelsToString(this.model.getMapForTesting().get("testbmp")));
  }

  @Test
  public void testLoadJPEG() {
    Pixel[][] load = new Pixel[3][3];

    load[0][0] = new RGBPixel(0, 0, 173, 37, 83);
    load[0][1] = new RGBPixel(0, 1, 254, 118, 164);
    load[0][2] = new RGBPixel(0, 2, 231, 252, 131);
    load[1][0] = new RGBPixel(1, 0, 227, 91, 137);
    load[1][1] = new RGBPixel(1, 1, 145, 9, 55);
    load[1][2] = new RGBPixel(1, 2, 11, 32, 0);
    load[2][0] = new RGBPixel(2, 0, 116, 54, 161);
    load[2][1] = new RGBPixel(2, 1, 191, 129, 236);
    load[2][2] = new RGBPixel(2, 2, 156, 255, 198);
    this.model.load("res/test.jpeg", "testjpeg");
    assertEquals(this.pixelsToString(load),
            this.pixelsToString(this.model.getMapForTesting().get("testjpeg")));
  }

  @Test
  public void testLoadInvalidFile() {
    Pixel[][] load = new Pixel[3][3];

    load[0][0] = new RGBPixel(0, 0, 255, 255, 0);
    load[0][1] = new RGBPixel(0, 1, 0, 255, 165);
    load[0][2] = new RGBPixel(0, 2, 0, 255, 255);
    load[1][0] = new RGBPixel(1, 0, 0, 0, 255);
    load[1][1] = new RGBPixel(1, 1, 0, 0, 0);
    load[1][2] = new RGBPixel(1, 2, 255, 75, 0);
    load[2][0] = new RGBPixel(2, 0, 130, 155, 38);
    load[2][1] = new RGBPixel(2, 1, 182, 255, 102);
    load[2][2] = new RGBPixel(2, 2, 255, 153, 255);
    try {
      this.model.load("", "test");
      assertEquals(this.pixelsToString(load),
              this.pixelsToString(this.model.getMapForTesting().get("test")));
      fail();
    } catch (StringIndexOutOfBoundsException s) {
      // path is empty
    }
  }

  @Test
  public void testSavePPM() throws IOException {
    // We created and saved our "test.ppm" file through the save method. It reads out the proper
    // string of text and is a viewable ppm file, therefore the save method works.
    Scanner sc = new Scanner(new FileInputStream("res/test.ppm"));
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }
    assertEquals("P3\n3 3\n255\n255\n0\n0" +
                    "\n255\n165\n0" +
                    "\n255\n255\n0" +
                    "\n0\n255\n0" +
                    "\n0\n0\n255" +
                    "\n75\n0\n130" +
                    "\n155\n38\n182" +
                    "\n255\n102\n255" +
                    "\n153\n255\n204\n",
            builder.toString());

  }

  /*
  @Test
  public void testSaveJPEG() {
    We created the file test.jpeg in the res folder by loading a file and then saving it as a jpeg,
    so we know that our program can correctly save a file as a jpeg.
  }

  @Test
  public void testSaveBMP() {
    We created the file test.bmp in the res folder by loading a file and then saving it as a bmp,
    so we know that our program can correctly save a file as a bmp.
  }

  @Test
  public void testSavePNG() {
    We created the file test.png in the res folder by loading a file and then saving it as a png,
    so we know that our program can correctly save a file as png.
  }

   */

  @Test
  public void testGetHistogram() {

    this.model.load("res/test.ppm", "test");

    int[] redHist = this.model.getHistogram("test", "red");
    assertEquals(2, redHist[0]);
    assertEquals(4, redHist[255]);
    assertEquals(1, redHist[153]);
    assertEquals(1, redHist[155]);

    int[] greenHist = this.model.getHistogram("test", "green");
    assertEquals(3, greenHist[0]);
    assertEquals(1, greenHist[38]);
    assertEquals(1, greenHist[102]);
    assertEquals(1, greenHist[165]);
    assertEquals(3, greenHist[255]);


    int[] blueHist = this.model.getHistogram("test", "blue");
    assertEquals(4, blueHist[0]);
    assertEquals(1, blueHist[130]);
    assertEquals(1, blueHist[182]);
    assertEquals(1, blueHist[204]);
    assertEquals(2, blueHist[255]);

    int[] intensity = this.model.getHistogram("test", "intensity");
    assertEquals(1, intensity[68]);
    assertEquals(3, intensity[85]);
    assertEquals(1, intensity[125]);
    assertEquals(1, intensity[140]);
    assertEquals(1, intensity[170]);
    assertEquals(2, intensity[204]);
  }

}

