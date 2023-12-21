package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Command to convert the image's color values into its intensity value.
 */
public class IntensityGrayscale extends AbstractCommand {

  /**
   * Constructor for the command to set color values to intensity.
   *
   * @param oldName The image to convert vals to intensity.
   * @param newName The new place in the model's hashmap to store the intensity value version.
   */
  public IntensityGrayscale(String oldName, String newName) {
    super(oldName, newName);
  }

  public void execute(IImageModel model) {
    model.intensityGrayScale(this.oldName, this.newName);
  }
}
