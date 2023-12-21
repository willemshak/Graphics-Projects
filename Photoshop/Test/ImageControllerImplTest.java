import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import imagecontroller.ImageControllerImpl;
import imagemodel.IImageModel;
import imagemodel.ImageModelMock;
import imagetextview.ImageTextViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * Testing ImageControllerImpl.
 */
public class ImageControllerImplTest {
  Readable readable;
  IImageModel model;
  ImageTextViewImpl view;
  ImageControllerImpl controller;

  @Before
  public void setUp() {
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
  }

  @Test
  public void testMenu() {
    readable = new StringReader("menu");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    //regular menu call
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Operations Available:\n" +
            "red-component 'image-name' 'image-dest-name'\n" +
            "green-component 'image-name' 'image-dest-name'\n" +
            "blue-component 'image-name' 'image-dest-name'\n" +
            "value-component 'image-name' 'image-dest-name'\n" +
            "luma-component 'image-name' 'image-dest-name'\n" +
            "intensity-component 'image-name' 'image-dest-name'\n" +
            "horizontal-flip 'image-name' 'image-dest-name'\n" +
            "vertical-flip 'image-name' 'image-dest-name'\n" +
            "brighten 'value-to-brighten-by' 'image-name' 'image-dest-name'\n" +
            "darken 'value-to-darken-by' 'image-name' 'image-dest-name'\n" +
            "blur 'image-name' 'image-dest-name'\n" +
            "sharpen 'image-name' 'image-dest-name'\n" +
            "grayscale 'image-name' 'image-dest-name'\n" +
            "sepia 'image-name' 'image-dest-name'\n" +
            "script '.txt-file-path'\n" +
            "save 'image-name' 'file-path'\n" +
            "load 'file-path' 'image-name'\n", view.toString());

    readable = new StringReader("load res/test.ppm test menu q");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Loaded 'res/test.ppm' with the file name 'test'\n" +
            "Operations Available:\n" +
            "red-component 'image-name' 'image-dest-name'\n" +
            "green-component 'image-name' 'image-dest-name'\n" +
            "blue-component 'image-name' 'image-dest-name'\n" +
            "value-component 'image-name' 'image-dest-name'\n" +
            "luma-component 'image-name' 'image-dest-name'\n" +
            "intensity-component 'image-name' 'image-dest-name'\n" +
            "horizontal-flip 'image-name' 'image-dest-name'\n" +
            "vertical-flip 'image-name' 'image-dest-name'\n" +
            "brighten 'value-to-brighten-by' 'image-name' 'image-dest-name'\n" +
            "darken 'value-to-darken-by' 'image-name' 'image-dest-name'\n" +
            "blur 'image-name' 'image-dest-name'\n" +
            "sharpen 'image-name' 'image-dest-name'\n" +
            "grayscale 'image-name' 'image-dest-name'\n" +
            "sepia 'image-name' 'image-dest-name'\n" +
            "script '.txt-file-path'\n" +
            "save 'image-name' 'file-path'\n" +
            "load 'file-path' 'image-name'\n" +
            "Program Quit\n", view.toString());

  }

  @Test
  public void testQuit() {
    readable = new StringReader("q");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // just quit
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Program Quit\n", view.toString());

    readable = new StringReader("menu q");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // menu then quit
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Operations Available:\n" +
            "red-component 'image-name' 'image-dest-name'\n" +
            "green-component 'image-name' 'image-dest-name'\n" +
            "blue-component 'image-name' 'image-dest-name'\n" +
            "value-component 'image-name' 'image-dest-name'\n" +
            "luma-component 'image-name' 'image-dest-name'\n" +
            "intensity-component 'image-name' 'image-dest-name'\n" +
            "horizontal-flip 'image-name' 'image-dest-name'\n" +
            "vertical-flip 'image-name' 'image-dest-name'\n" +
            "brighten 'value-to-brighten-by' 'image-name' 'image-dest-name'\n" +
            "darken 'value-to-darken-by' 'image-name' 'image-dest-name'\n" +
            "blur 'image-name' 'image-dest-name'\n" +
            "sharpen 'image-name' 'image-dest-name'\n" +
            "grayscale 'image-name' 'image-dest-name'\n" +
            "sepia 'image-name' 'image-dest-name'\n" +
            "script '.txt-file-path'\n" +
            "save 'image-name' 'file-path'\n" +
            "load 'file-path' 'image-name'\n" +
            "Program Quit\n", view.toString());

    readable = new StringReader("a bc  menu a b c d q a d");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // bad inputs menu more bad inputs then quit, inputs after quit
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Unknown Command: a\n" +
            "Unknown Command: bc\n" +
            "Operations Available:\n" +
            "red-component 'image-name' 'image-dest-name'\n" +
            "green-component 'image-name' 'image-dest-name'\n" +
            "blue-component 'image-name' 'image-dest-name'\n" +
            "value-component 'image-name' 'image-dest-name'\n" +
            "luma-component 'image-name' 'image-dest-name'\n" +
            "intensity-component 'image-name' 'image-dest-name'\n" +
            "horizontal-flip 'image-name' 'image-dest-name'\n" +
            "vertical-flip 'image-name' 'image-dest-name'\n" +
            "brighten 'value-to-brighten-by' 'image-name' 'image-dest-name'\n" +
            "darken 'value-to-darken-by' 'image-name' 'image-dest-name'\n" +
            "blur 'image-name' 'image-dest-name'\n" +
            "sharpen 'image-name' 'image-dest-name'\n" +
            "grayscale 'image-name' 'image-dest-name'\n" +
            "sepia 'image-name' 'image-dest-name'\n" +
            "script '.txt-file-path'\n" +
            "save 'image-name' 'file-path'\n" +
            "load 'file-path' 'image-name'\n" +
            "Unknown Command: a\n" +
            "Unknown Command: b\n" +
            "Unknown Command: c\n" +
            "Unknown Command: d\n" +
            "Program Quit\n", view.toString());
  }

  @Test
  public void testRedComponent() {
    readable = new StringReader("red-component true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // red-component where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Red component set for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("red-component false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // red-component where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());

  }

  @Test
  public void testGreenComponent() {
    readable = new StringReader("green-component true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // green-component where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Green component set for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("green-component false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // green-component where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());
  }

  @Test
  public void testBlueComponent() {
    readable = new StringReader("blue-component true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // blue-component where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Blue component set for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("blue-component false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // blue-component where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());
  }

  @Test
  public void testValueComponent() {
    readable = new StringReader("value-component true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // value-component where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Value component set for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("value-component false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // value-component where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());
  }

  @Test
  public void testLumaComponent() {
    readable = new StringReader("luma-component true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // luma-component where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Luma component set for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("luma-component false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // luma-component where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());
  }

  @Test
  public void testIntensityComponent() {
    readable = new StringReader("intensity-component true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // intensity-component where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Intensity component set for file 'true' and created " +
            "'newName'\n", this.view.toString());

    readable = new StringReader("intensity-component false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // intensity-component where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());
  }

  @Test
  public void testHorizontalFlip() {
    readable = new StringReader("horizontal-flip true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // horizontal-flip where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Horizontal Flip for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("horizontal-flip false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // horizontal-flip where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());
  }

  @Test
  public void testVerticalFlip() {
    readable = new StringReader("vertical-flip true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // vertical-flip where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Vertical Flip for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("vertical-flip false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // vertical-flip where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());
  }

  @Test
  public void testBrighten() {
    readable = new StringReader("brighten 30 true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // brighten where the image is created
    assertEquals("true30 true newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Brightened 'true' by 30 and created 'newName'\n", this.view.toString());

    readable = new StringReader("brighten 30 false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // brighten where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());

  }

  @Test
  public void testDarken() {
    readable = new StringReader("darken 30 true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // darken where the image is created
    assertEquals("true30 true newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Darkened 'true' by 30 and created 'newName'\n", this.view.toString());

    readable = new StringReader("darken 30 false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // darken where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());

  }

  @Test
  public void testSave() {
    readable = new StringReader("save true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // save where the image is saved
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "File 'true' saved at 'newName'\n", this.view.toString());

    readable = new StringReader("save false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // save where the image does not exist
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());

  }

  @Test
  public void testLoad() {
    readable = new StringReader("load true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // load where the image is created
    assertEquals("true newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Loaded 'true' with the file name 'newName'\n", this.view.toString());

    readable = new StringReader("load false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // load where the image is created
    assertEquals("false newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Loaded 'false' with the file name 'newName'\n", this.view.toString());

  }

  @Test
  public void testBlur() {
    readable = new StringReader("blur true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // blur where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Blur for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("blur false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // blur where the image is not created
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());

  }

  @Test
  public void testSharpen() {
    readable = new StringReader("sharpen true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // sharpen where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Sharpen for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("sharpen false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // sharpen where the image is not created
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());

  }

  @Test
  public void testGrayscale() {
    readable = new StringReader("grayscale true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // grayscale where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Grayscale for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("grayscale false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // grayscale where the image is not created
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());

  }

  @Test
  public void testSepia() {
    readable = new StringReader("sepia true newName");
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();

    // sepia where the image is created
    assertEquals("truetrue newName", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "Sepia for file 'true' and created 'newName'\n", this.view.toString());

    readable = new StringReader("sepia false newName");
    model = new ImageModelMock();
    view = new ImageTextViewImpl(model, new StringBuilder());
    controller = new ImageControllerImpl(model, view, readable);
    controller.execute();


    // blur where the image is not created
    assertEquals("false", model.toString());
    assertEquals("Image Processing Application\n" +
            "Input 'menu' to see operations, 'q' to quit\n" +
            "false has not been loaded.\n", this.view.toString());

  }
}
