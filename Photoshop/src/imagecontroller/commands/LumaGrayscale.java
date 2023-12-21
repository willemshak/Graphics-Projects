package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Command to set an image's color values to its luma value.
 */
public class LumaGrayscale extends AbstractCommand {

  /**
   * Constructor for a LumaGrayScale command.
   *
   * @param oldName the image to convert its values to luma.
   * @param newName the name of the new file whose values are converted to luma.
   */
  public LumaGrayscale(String oldName, String newName) {
    super(oldName, newName);
  }

  public void execute(IImageModel model) {
    model.lumaGrayScale(this.oldName, this.newName);
  }
}
