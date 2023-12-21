package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Command that flips an image vertically given a model.
 */
public class FlipVertical extends AbstractCommand {

  /**
   * Constructor for command that flips image vertically.
   *
   * @param oldName The image to flip vertically.
   * @param newName The name to put the vertically flipped image into the hashmap.
   */
  public FlipVertical(String oldName, String newName) {
    super(oldName, newName);
  }

  public void execute(IImageModel model) {
    model.verticalFlip(this.oldName, this.newName);
  }
}
