package imagecontroller.commands;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Command to blur an image.
 */
public class Blur extends AbstractCommand {

  /**
   * Constructor for a blur command.
   *
   * @param oldName the name of the image to blur.
   * @param newName the name of the key to map the blurred image to.
   */
  public Blur(String oldName, String newName) {
    super(oldName, newName);
  }

  @Override
  public void execute(IImageModel model) throws IOException {
    model.blur(oldName, newName);
  }
}
