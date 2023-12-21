package imagecontroller.commands;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Command to save an image at a specified directory.
 */
public class Save extends AbstractCommand {
  String type;

  /**
   * Constructor for the Save command.
   *
   * @param oldName The name of the image to save.
   * @param newName The directory of where to save the image.
   */
  public Save(String oldName, String newName) {
    super(oldName, newName);
  }

  @Override
  public void execute(IImageModel model) throws IOException {
    model.save(this.oldName, this.newName);
  }
}
