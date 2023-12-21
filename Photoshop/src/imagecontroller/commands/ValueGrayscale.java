package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Command that converts an image's color values to its Value.
 */
public class ValueGrayscale extends AbstractCommand {

  /**
   * Constructor for a ValueGrayscale command.
   *
   * @param oldName The image to convert to its Value.
   * @param newName The new name of the image which has been converted to Value.
   */
  public ValueGrayscale(String oldName, String newName) {
    super(oldName, newName);
  }

  public void execute(IImageModel model) {
    model.valueGrayScale(this.oldName, this.newName);
  }
}
