package imagecontroller.commands;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Command to apply a sepia filter to an image.
 */
public class Sepia extends AbstractCommand {

  /**
   * Constructor for a commond to apply a sepia filter.
   *
   * @param oldName the name of the image to apply the sepia filter.
   * @param newName the key of the sepia filtered image to map to.
   */
  public Sepia(String oldName, String newName) {
    super(oldName, newName);
  }

  @Override
  public void execute(IImageModel model) throws IOException {
    model.sepia(oldName, newName);
  }
}
