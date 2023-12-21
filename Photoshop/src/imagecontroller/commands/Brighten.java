package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Function object to brighten an image in the model's hashmap and create a new version.
 */
public class Brighten extends AbstractCommand {
  private int n;

  /**
   * Constructor for the function object to brighten the values.
   *
   * @param n       the amount to brighten the values by.
   * @param oldName the name of the file to brighten.
   * @param newName where the brightened version is put into the hashmap.
   */
  public Brighten(int n, String oldName, String newName) {
    super(oldName, newName);
    this.n = n;
  }

  public void execute(IImageModel model) {
    model.brighten(this.n, this.oldName, this.newName);
  }
}
