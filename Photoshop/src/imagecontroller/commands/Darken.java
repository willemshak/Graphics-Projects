package imagecontroller.commands;

import imagemodel.IImageModel;

/**
 * Function object to darken an image in the model's hashmap, and create the new darker version.
 */
public class Darken extends AbstractCommand {
  private int n;

  /**
   * Constructor for function object to darken an image in a model.
   *
   * @param n       the amount to darken the values by.
   * @param oldName the image to be darkened.
   * @param newName the name the darkened image will be put into the model's hashmap by.
   */
  public Darken(int n, String oldName, String newName) {
    super(oldName, newName);
    this.n = n;
  }

  public void execute(IImageModel model) {
    model.darken(this.n, this.oldName, this.newName);
  }
}
