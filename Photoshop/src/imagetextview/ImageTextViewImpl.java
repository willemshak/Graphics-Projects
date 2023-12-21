package imagetextview;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Class Representing an ImageTextViewImpl. Helps to display messages given by the controller.
 */
public class ImageTextViewImpl implements ImageTextView {
  private IImageModel model;
  private Appendable appendable;

  /**
   * Two arg constructor for setting both the model and appendable.
   *
   * @param model      the model to be viewed.
   * @param appendable the appendable to be viewed.
   * @throws IllegalArgumentException when the arguments are null.
   */
  public ImageTextViewImpl(IImageModel model, Appendable appendable)
          throws IllegalArgumentException {
    if (model == null || appendable == null) {
      throw new IllegalArgumentException("model or appendable is null.");
    }
    this.model = model;
    this.appendable = appendable;
  }

  /**
   * Constructor for just the model, defaults the appendable to System.out.
   *
   * @param model the model to be viewed.
   * @throws IllegalArgumentException when argument is null.
   */
  public ImageTextViewImpl(IImageModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("model is null.");
    }
    this.model = model;
    this.appendable = System.out;
  }

  @Override
  public void renderMessage(String s) throws IOException {
    this.appendable.append(s + "\n");
  }

  @Override
  public String toString() {
    return this.appendable.toString();
  }
}
