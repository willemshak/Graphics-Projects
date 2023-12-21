package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Command to convert an image's color values to its red component.
 */
public class RedGrayscale extends AbstractCommand {

  /**
   * Constructor for a RedGrayscale command.
   *
   * @param oldName The image to convert its values to its red component.
   * @param newName The new key to put the converted image into.
   */
  public RedGrayscale(String oldName, String newName) {
    super(oldName, newName);
  }

  public void execute(IImageModel model) {
    model.redGrayScale(this.oldName, this.newName);
  }
}
