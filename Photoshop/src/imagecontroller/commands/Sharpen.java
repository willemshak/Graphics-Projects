package imagecontroller.commands;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Command to sharpen an image.
 */
public class Sharpen extends AbstractCommand {

  /**
   * Constructor of a command to sharpen an image.
   * @param oldName the image to sharpen.
   * @param newName the key that the sharpened image will be mapped to.
   */
  public Sharpen(String oldName, String newName) {
    super(oldName, newName);
  }

  @Override
  public void execute(IImageModel model) throws IOException {
    model.sharpen(oldName, newName);
  }
}
