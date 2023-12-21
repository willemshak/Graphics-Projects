package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Command that converts all the color values in an image to its green component.
 */
public class GreenGrayscale extends AbstractCommand {

  /**
   * Constructor for a GreenGrayScale command.
   *
   * @param oldName The image to convert the color values green.
   * @param newName The name of the image to put the green converted image into in the hashmap.
   */
  public GreenGrayscale(String oldName, String newName) {
    super(oldName, newName);
  }

  public void execute(IImageModel model) {
    model.greenGrayScale(this.oldName, this.newName);
  }
}
