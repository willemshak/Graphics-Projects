package imagetextview;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


/**
 * Class representing a Histogram panel. Draws all values of the
 * histogram based on a given array and color.
 */
public class HistogramPanel extends JPanel {
  Color color;
  int[] vals;

  /**
   * Constructor for a Histogram panel.
   * @param color the color to draw the shapes in.
   * @param vals the array which the values are pulled from.
   */
  public HistogramPanel(Color color, int[] vals) {
    super();
    this.color = color;
    this.vals = vals;
  }

  public HistogramPanel() {
    super();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D histogram = (Graphics2D) g;
    histogram.setColor(this.color);

    int max = 0;
    int n = 0;
    for (int i = 0; i < this.vals.length; i++) {
      n += this.vals[i];
      if (max < this.vals[i]) {
        max = this.vals[i];
      }
    }

    for (int j = 0; j < this.vals.length; j++) {
      double percentHeight = ((double) this.vals[j]) / ((double) max);
      int height = (int) (percentHeight * 170);
      int yStart = 170 - height;
      int xStart = j;
      histogram.fillRect(xStart, yStart, 1, height);
    }
  }
}