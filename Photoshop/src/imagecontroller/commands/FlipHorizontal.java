package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Command to flip an image horizontally.
 */
public class FlipHorizontal extends AbstractCommand {

  /**
   * Constructor for commannd to flip image horizontally.
   *
   * @param oldName The image to flip horizontally.
   * @param newName The name of the new file to save the horizontally flipped old image.
   */
  public FlipHorizontal(String oldName, String newName) {
    super(oldName, newName);
  }

  public void execute(IImageModel model) {
    model.horizontalFlip(this.oldName, this.newName);
  }
}
