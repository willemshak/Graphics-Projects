package imagecontroller.commands;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Command to grayscale an image.
 */
public class Grayscale extends AbstractCommand {

  /**
   * Constructor of command to grayscale and image.
   * @param oldName the name of the image to grayscale.
   * @param newName the key of the grayscaled image to map to.
   */
  public Grayscale(String oldName, String newName) {
    super(oldName, newName);
  }

  @Override
  public void execute(IImageModel model) throws IOException {
    model.grayscale(oldName, newName);
  }
}
