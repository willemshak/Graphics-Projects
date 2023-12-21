package imagecontroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import imagecontroller.commands.BlueGrayscale;
import imagecontroller.commands.Blur;
import imagecontroller.commands.Brighten;
import imagecontroller.commands.Command;
import imagecontroller.commands.Darken;
import imagecontroller.commands.Downscale;
import imagecontroller.commands.FlipHorizontal;
import imagecontroller.commands.FlipVertical;
import imagecontroller.commands.Grayscale;
import imagecontroller.commands.GreenGrayscale;
import imagecontroller.commands.IntensityGrayscale;
import imagecontroller.commands.Load;
import imagecontroller.commands.LumaGrayscale;
import imagecontroller.commands.RedGrayscale;
import imagecontroller.commands.Save;
import imagecontroller.commands.Sepia;
import imagecontroller.commands.Sharpen;
import imagecontroller.commands.ValueGrayscale;
import imagemodel.IImageModel;
import imagetextview.ImageTextView;

/**
 * Class representing an ImageController. Has fields model, view, and readable which interact to
 * give an interface to a user, and do operations on images.
 */
public class ImageControllerImpl implements ImageController {
  private IImageModel model;
  private ImageTextView view;
  private Readable readable;

  /**
   * Three arg constructor for an ImageControllerImpl.
   *
   * @param model    and IImageModel that the operations are done on.
   * @param view     ImageTextView that the messages are printed on.
   * @param readable a readable for inputs into the controller.
   */
  public ImageControllerImpl(IImageModel model, ImageTextView view, Readable readable) {
    this.model = model;
    this.view = view;
    this.readable = readable;
  }

  /**
   * Method to give commands to the model. Does operations on images in the model.
   */
  public void execute() {
    Scanner scanner = new Scanner(this.readable);
    try {
      this.view.renderMessage("Image Processing Application\n" +
              "Input 'menu' to see operations, 'q' to quit");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    while (scanner.hasNext()) {
      String input = scanner.next();
      Command cmd = null;

      try {
        String oldName;
        String newName;
        int changeBy;
        switch (input) {
          case "menu":
            this.view.renderMessage("Operations Available:\n" +
                    "red-component 'image-name' 'image-dest-name'" +
                    "\ngreen-component 'image-name' 'image-dest-name'\n" +
                    "blue-component 'image-name' 'image-dest-name'" +
                    "\nvalue-component 'image-name' 'image-dest-name'" +
                    "\nluma-component 'image-name' 'image-dest-name'" +
                    "\nintensity-component 'image-name' 'image-dest-name'\n" +
                    "horizontal-flip 'image-name' 'image-dest-name'" +
                    "\nvertical-flip 'image-name' 'image-dest-name'\n" +
                    "brighten 'value-to-brighten-by' 'image-name' 'image-dest-name'\n" +
                    "darken 'value-to-darken-by' 'image-name' 'image-dest-name'\n" +
                    "blur 'image-name' 'image-dest-name'\n" +
                    "sharpen 'image-name' 'image-dest-name'\n" +
                    "grayscale 'image-name' 'image-dest-name'\n" +
                    "sepia 'image-name' 'image-dest-name'\n" +
                    "script '.txt-file-path'\n" +
                    "save 'image-name' 'file-path'\n" +
                    "load 'file-path' 'image-name'");
            break;
          case "red-component":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new RedGrayscale(oldName, newName);
              this.view.renderMessage("Red component set for file '" + oldName + "'" +
                      " and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "green-component":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new GreenGrayscale(oldName, newName);
              this.view.renderMessage("Green component set for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "blue-component":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new BlueGrayscale(oldName, newName);
              this.view.renderMessage("Blue component set for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "value-component":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new ValueGrayscale(oldName, newName);
              this.view.renderMessage("Value component set for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "luma-component":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new LumaGrayscale(oldName, newName);
              this.view.renderMessage("Luma component set for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "intensity-component":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new IntensityGrayscale(oldName, newName);
              this.view.renderMessage("Intensity component set for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "horizontal-flip":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new FlipHorizontal(oldName, newName);
              this.view.renderMessage("Horizontal Flip for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "vertical-flip":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new FlipVertical(oldName, newName);
              this.view.renderMessage("Vertical Flip for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "brighten":
            try {
              changeBy = scanner.nextInt();
              oldName = scanner.next();
              newName = scanner.next();
              if (model.isLoaded(oldName)) {
                try {
                  cmd = new Brighten(changeBy, oldName, newName);
                  this.view.renderMessage("Brightened '" + oldName +
                          "' by " + changeBy + " and created '" + newName + "'");
                } catch (IllegalArgumentException e) {
                  this.view.renderMessage("The number to brighten the image by must be " +
                          "greater than or equal to zero.");
                }
              } else {
                this.view.renderMessage(oldName + " has not been loaded.");
              }
            } catch (InputMismatchException ime) {
              this.view.renderMessage("Enter an integer to brighten the image by.");
            }
            break;
          case "darken":
            try {
              changeBy = scanner.nextInt();
              oldName = scanner.next();
              newName = scanner.next();
              if (model.isLoaded(oldName)) {
                try {
                  cmd = new Darken(changeBy, oldName, newName);
                  this.view.renderMessage("Darkened '" + oldName +
                          "' by " + changeBy + " and created '" + newName + "'");
                } catch (IllegalArgumentException e) {
                  this.view.renderMessage("The number to darken the image by must be " +
                          "greater than or equal to zero.");
                }
              } else {
                this.view.renderMessage(oldName + " has not been loaded.");
              }
            } catch (InputMismatchException ime) {
              this.view.renderMessage("Enter an integer to brighten the image by.");
            }
            break;
          case "blur":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new Blur(oldName, newName);
              this.view.renderMessage("Blur for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "sharpen":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new Sharpen(oldName, newName);
              this.view.renderMessage("Sharpen for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "sepia":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new Sepia(oldName, newName);
              this.view.renderMessage("Sepia for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "grayscale":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new Grayscale(oldName, newName);
              this.view.renderMessage("Grayscale for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "downscale":
            oldName = scanner.next();
            newName = scanner.next();
            String scaleType = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new Downscale(oldName, newName, scaleType);
              this.view.renderMessage("Downscale for file '" + oldName +
                      "' and created '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "save":
            oldName = scanner.next();
            newName = scanner.next();
            if (model.isLoaded(oldName)) {
              cmd = new Save(oldName, newName);
              this.view.renderMessage("File '" + oldName +
                      "' saved at '" + newName + "'");
            } else {
              this.view.renderMessage(oldName + " has not been loaded.");
            }
            break;
          case "load":
            oldName = scanner.next();
            newName = scanner.next();
            cmd = new Load(oldName, newName);
            this.view.renderMessage("Loaded '" + oldName +
                    "' with the file name '" + newName + "'");
            break;
          case "q":
          case "quit":
            this.view.renderMessage("Program Quit");
            return;
          case "script":
            readTextFile(scanner.next());
            this.view.renderMessage("Running given script.");
            scanner = new Scanner(this.readable);
            break;
          default:
            this.view.renderMessage("Unknown Command: " + input);
            cmd = null;
            break;
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      try {
        if (cmd != null) {
          cmd.execute(this.model);
        }
      } catch (IOException e) {
        try {
          this.view.renderMessage("Cannot execute command");
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    }
  }

  private void readTextFile(String path) {
    StringBuilder sb = new StringBuilder();
    try {
      File file = new File(path);
      Scanner s = new Scanner(file);


      while (s.hasNextLine()) {
        String current = s.nextLine();
        sb.append(current + "\n");
      }
    } catch (FileNotFoundException f) {
      System.out.print("Could not find file " + path);
    }
    this.readable = new StringReader(sb.toString());
  }
}
