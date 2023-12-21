package imagecontroller.commands;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Command to load a file into a model.
 */
public class Load extends AbstractCommand {

  /**
   * Constructor for a command to load  file into a model.
   *
   * @param path     the path of the file to put into the model.
   * @param filename the name of the key for the image to be put into the model's hashmap.
   */
  public Load(String path, String filename) {
    super(path, filename);
  }

  @Override
  public void execute(IImageModel model) throws IOException {
    model.load(this.oldName, this.newName);
  }
}
