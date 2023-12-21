import org.junit.Test;

import java.io.IOException;

import imagemodel.IImageModel;
import imagemodel.ImageModel;
import imagetextview.ImageTextViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * Testing for ImageTextViewImple.
 */
public class ImageTextViewImplTest {

  ImageTextViewImpl view;
  ImageTextViewImpl view2;

  ImageTextViewImpl view3;
  IImageModel nullModel;
  IImageModel model;
  Appendable nullAppendable;


  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() {
    this.view = new ImageTextViewImpl(nullModel, nullAppendable);
    this.view2 = new ImageTextViewImpl(nullModel);
  }

  @Test
  public void testRenderEmptyMessage() throws IOException {
    Appendable appendable = new StringBuilder();
    this.model = new ImageModel();
    this.view3 = new ImageTextViewImpl(this.model, appendable);
    this.view3.renderMessage("");
    assertEquals("\n", appendable.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    Appendable appendable = new StringBuilder();
    this.model = new ImageModel();
    this.view3 = new ImageTextViewImpl(this.model, appendable);
    this.view3.renderMessage("Cannot execute command.");
    assertEquals("Cannot execute command.\n", appendable.toString());
  }

}