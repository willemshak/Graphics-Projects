package imagecontroller.commands;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Command to downscale an image. Can size it to be small, medium, and large.
 */
public class Downscale extends AbstractCommand {
  String size;

  /**
   * Constructor for a command to downscale an object.
   * @param oldName name of the image to downscale.
   * @param newName the new name that the image will be stored as.
   * @param size the size of the downscale.
   */
  public Downscale(String oldName, String newName, String size) {
    super(oldName, newName);
    this.size = size;
  }


  @Override
  public void execute(IImageModel model) throws IOException {
    model.downscale(this.oldName, this.newName, this.size);
  }
}
