package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Function object that creates a new Pixel[][] in the model's hashmap, with its Pixel color values
 * changed to the blue's value.
 */
public class BlueGrayscale extends AbstractCommand {

  /**
   * Constructor for the BlueGrayScale function object.
   *
   * @param oldName the name of the file to convert to blue grayscale.
   * @param newName the name of the new file that the converted one is mapped to.
   */
  public BlueGrayscale(String oldName, String newName) {
    super(oldName, newName);
  }

  public void execute(IImageModel model) {
    model.blueGrayScale(this.oldName, this.newName);
  }
}
