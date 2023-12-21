import org.junit.Before;
import org.junit.Test;

import pixel.Pixel;
import pixel.RGBPixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Testing RGBPixel class.
 */
public class RGBPixelTest {

  Pixel pixel1;
  Pixel pixel2;
  Pixel pixel3;
  Pixel pixel4;
  Pixel pixel5;
  Pixel pixel6;
  Pixel pixel7;
  Pixel pixel8;
  Pixel pixel9;
  Pixel pixel10;
  Pixel pixel11;
  Pixel pixel12;

  Pixel pixel13;
  Pixel pixel14;
  Pixel pixel15;
  Pixel pixel16;


  @Before
  public void setUp() {
    this.pixel1 = new RGBPixel(0, 0, 130, 220, 50);
    this.pixel8 = new RGBPixel(0, 1, 192, 170, 20);
    this.pixel9 = new RGBPixel(0, 2, 130, 120, 250);
    this.pixel10 = new RGBPixel(1, 0, 190, 210, 71);
    this.pixel11 = new RGBPixel(1, 1, 55, 255, 10);
    this.pixel12 = new RGBPixel(1, 2, 250, 100, 130);

    this.pixel13 = this.pixel1;
    this.pixel14 = new RGBPixel(0, 0, 130, 220, 50);
    this.pixel15 = new RGBPixel(1, 1, 130, 220, 50);

    this.pixel16 = new RGBPixel(1, 1, 0, 0, 255);


  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    // negative red
    this.pixel2 = new RGBPixel(3, 4, -2, 50, 100);
    // red over 255
    this.pixel3 = new RGBPixel(3, 4, 256, 50, 100);
    // negative green
    this.pixel4 = new RGBPixel(3, 4, 170, -3, 100);
    // green over 255
    this.pixel5 = new RGBPixel(3, 4, 170, 257, 100);
    // negative blue
    this.pixel6 = new RGBPixel(3, 4, 170, 59, -100);
    // blue over 255
    this.pixel7 = new RGBPixel(3, 4, 170, 70, 300);

  }

  @Test
  public void testValue() {
    assertEquals(220, this.pixel1.value());
    assertEquals(192, this.pixel8.value());
    assertEquals(250, this.pixel9.value());
  }

  @Test
  public void testIntensity() {
    assertEquals(133, this.pixel1.intensity());
    assertEquals(127, this.pixel8.intensity());
    assertEquals(166, this.pixel9.intensity());
  }

  @Test
  public void testLuma() {
    assertEquals(188.592, this.pixel1.luma(), 0.01);
    assertEquals(163.8472, this.pixel8.luma(), 0.01);
    assertEquals(131.512, this.pixel9.luma(), 0.01);
  }

  @Test
  public void testConvert() {
    pixel1.convert("red");
    assertEquals("\n130\n130\n130\n", pixel1.getColors());
    pixel8.convert("green");
    assertEquals("\n170\n170\n170\n", pixel8.getColors());
    pixel9.convert("blue");
    assertEquals("\n250\n250\n250\n", pixel9.getColors());
    pixel16.convert("blue");
    assertEquals("\n255\n255\n255\n", pixel16.getColors());
    pixel10.convert("value");
    assertEquals("\n210\n210\n210\n", pixel10.getColors());
    pixel11.convert("intensity");
    assertEquals("\n106\n106\n106\n", pixel11.getColors());
    pixel12.convert("luma");
    assertEquals("\n134\n134\n134\n", pixel12.getColors());
  }

  @Test
  public void testBrighten() {
    try {
      pixel1.brighten(-20);
      fail();
    } catch (IllegalArgumentException e) {
      // given int has to be greater than or equal to 0.
    }

    pixel1.brighten(0);
    assertEquals("\n130\n220\n50\n", pixel1.getColors());

    pixel1.brighten(20);
    assertEquals("\n150\n240\n70\n", pixel1.getColors());

    pixel8.brighten(300);
    assertEquals("\n255\n255\n255\n", pixel8.getColors());
  }

  @Test
  public void testDarken() {
    try {
      pixel1.darken(-20);
      fail();
    } catch (IllegalArgumentException e) {
      // given int has to be greater than or equal to 0.
    }

    pixel1.darken(0);
    assertEquals("\n130\n220\n50\n", pixel1.getColors());

    pixel1.darken(20);
    assertEquals("\n110\n200\n30\n", pixel1.getColors());

    pixel8.darken(300);
    assertEquals("\n0\n0\n0\n", pixel8.getColors());
  }

  @Test
  public void testGetColors() {
    assertEquals("\n130\n220\n50\n", pixel1.getColors());
    assertEquals("\n192\n170\n20\n", pixel8.getColors());
    assertEquals("\n130\n120\n250\n", pixel9.getColors());
  }

  @Test
  public void testToString() {
    assertEquals("x: 0 y: 0 Red: 130 Green: 220 Blue: 50", pixel1.toString());
    assertEquals("x: 0 y: 1 Red: 192 Green: 170 Blue: 20", pixel8.toString());
    assertEquals("x: 0 y: 2 Red: 130 Green: 120 Blue: 250", pixel9.toString());
  }

  @Test
  public void testEquals() {
    assertTrue(this.pixel1.equals(this.pixel13));
    assertTrue(this.pixel1.equals(this.pixel1));
    assertTrue(this.pixel13.equals(this.pixel1));
    assertTrue(this.pixel13.equals(this.pixel13));
    assertFalse(this.pixel1.equals(this.pixel14));
    assertFalse(this.pixel14.equals(this.pixel1));
    assertFalse(this.pixel1.equals(this.pixel15));
    assertFalse(this.pixel13.equals(this.pixel15));
    assertFalse(this.pixel14.equals(this.pixel15));
    assertFalse(this.pixel8.equals(this.pixel1));
    assertFalse(this.pixel15.equals(this.pixel1));
  }
}
