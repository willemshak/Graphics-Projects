import java.io.InputStreamReader;
import java.io.StringReader;

import imagecontroller.ImageController;
import imagecontroller.ImageControllerImpl;
import imagemodel.ImageModel;
import imagetextview.ImageGUIView;
import imagetextview.ImageTextView;
import imagetextview.ImageTextViewImpl;

/**
 * Main class, Instantiates a new basic controller without any images loaded. Commands can be
 * inputted to interact with the controller.
 */
public class Main {
  /**
   * main method to create the controller.
   *
   * @param args various arguments to be passed in.
   */
  public static void main(String[] args) {
    if (args.length == 2 && args[0].equals("-file")) {
      Readable readable = new StringReader("script " + args[1]);
      ImageModel model = new ImageModel();
      ImageTextView view = new ImageTextViewImpl(model, System.out);
      ImageController controller = new ImageControllerImpl(model, view, readable);
      controller.execute();
    } else if (args.length == 1 && args[0].equals("-text")) {
      Readable readable = new InputStreamReader(System.in);
      ImageModel model = new ImageModel();
      ImageTextView view = new ImageTextViewImpl(model, System.out);
      ImageController controller = new ImageControllerImpl(model, view, readable);
      controller.execute();
    } else if (args.length == 0) {
      ImageModel model = new ImageModel();
      ImageGUIView gui = new ImageGUIView(model);
    }
  }
}

