package imagetextview;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.StringReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import imagecontroller.ImageController;
import imagecontroller.ImageControllerImpl;
import imagemodel.ImageModel;

/**
 * Class representing an ImageGUIView. This allows for an ImageModel to be interacted
 * with using a GUI.
 */
public class ImageGUIView {
  private JFrame frame;

  private JLabel imageL;
  private JPanel imageP;

  private JPanel errorMessaging;
  private JLabel errorMessage;
  private JLabel path;
  private String pathString;

  private JPanel histograms;
  private JPanel red;
  private JPanel green;
  private JPanel blue;
  private JPanel intensity;

  private JPanel loadSave;

  private ImageModel model;
  private String current;

  /**
   * Constructor for an ImageGUIView. Takes in a model that it will be doing operations on.
   *
   * @param m the ImageModel that operations will be done on.
   */
  public ImageGUIView(ImageModel m) {
    this.model = m;
    this.frame = new JFrame();
    this.imageL = new JLabel();
    this.imageP = new JPanel();
    this.errorMessaging = new JPanel();
    this.errorMessage = new JLabel();
    this.path = new JLabel();
    this.histograms = new JPanel();
    this.red = new JPanel();
    this.green = new JPanel();
    this.blue = new JPanel();
    this.intensity = new JPanel();
    this.loadSave = new JPanel();

    initGUIView();
    initOperationsPanel();

    this.frame.setVisible(true);
  }

  // Add histogram functionality
  // display the image currrently working on
  // log of operations
  // histogram on screen at all time, refereshes after every operation
  // error conditions should be displayed to the user


  // Extra credit
  // Imge downscaling
  // partial image manipulation

  private void initGUIView() {
    this.frame = new JFrame("Image Processing Application");
    this.frame.setSize(1920, 1080);
    this.frame.setLayout(new GridLayout(2, 2));

    this.frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    this.imageL = new JLabel();
    this.imageP = new JPanel();
    imageP.setLayout(new GridLayout(1, 1));
    JScrollPane scroll = new JScrollPane(this.imageL);
    scroll.setPreferredSize(new Dimension(1000, 1000));
    this.imageP.add(scroll);

    frame.add(imageP);

    // error messaging
    this.errorMessaging = new JPanel(new GridLayout(2, 1));
    this.frame.add(errorMessaging);
    this.errorMessage = new JLabel("Information will appear here");
    this.errorMessaging.add(this.errorMessage);
    this.pathString = "no path defined";
    this.path = new JLabel("The save path is: " + this.pathString);
    this.errorMessaging.add(this.path);
  }

  private void resetHistograms() {
    this.frame.remove(histograms);
    this.histograms = new JPanel();
    this.frame.add(this.histograms);
    this.histograms.setLayout(new GridLayout(2, 2));
    this.histograms.setBorder(BorderFactory.createTitledBorder("Histograms"));

    red = new JPanel(new GridLayout(1, 0));
    histograms.add(red);
    red.setBorder(BorderFactory.createTitledBorder("red component histogram"));
    HistogramPanel r = new HistogramPanel(Color.RED, model.getHistogram(current, "red"));
    red.add(r);

    green = new JPanel(new GridLayout(1, 0));
    histograms.add(green);
    green.setBorder(BorderFactory.createTitledBorder("green component histogram"));
    HistogramPanel g = new HistogramPanel(Color.GREEN, model.getHistogram(current, "green"));
    green.add(g);

    blue = new JPanel(new GridLayout(1, 0));
    histograms.add(blue);
    blue.setBorder(BorderFactory.createTitledBorder("blue component histogram"));
    HistogramPanel b = new HistogramPanel(Color.BLUE, model.getHistogram(current, "blue"));
    blue.add(b);

    intensity = new JPanel(new GridLayout(1, 0));
    histograms.add(intensity);
    intensity.setBorder(BorderFactory.createTitledBorder("intensity component histogram"));
    HistogramPanel i = new HistogramPanel(Color.GRAY, model.getHistogram(current, "intensity"));
    intensity.add(i);
  }

  private void initOperationsPanel() {
    // Operations Panel
    JPanel comboboxPanel = new JPanel(new GridLayout(2, 0));
    comboboxPanel.setBorder(BorderFactory.createTitledBorder("Operations"));
    comboboxPanel.setLayout(new BoxLayout(comboboxPanel, BoxLayout.PAGE_AXIS));
    frame.add(comboboxPanel);

    loadSave = new JPanel(new FlowLayout());
    comboboxPanel.add(loadSave);

    // load button
    JFileChooser chooser = new JFileChooser();
    JButton load = new JButton("Load");
    loadSave.add(load);
    load.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        int n = chooser.showOpenDialog(frame);
        ImageTextViewImpl view = new ImageTextViewImpl(model);
        if (n == JFileChooser.APPROVE_OPTION) {
          File file = chooser.getSelectedFile();
          int index = file.getPath().indexOf('.');
          String fileName = file.getPath().substring(0, index);
          int index2 = file.getPath().lastIndexOf('/');
          String imageName = file.getPath().substring(index2 + 1, index);

          ImageController controller = new ImageControllerImpl(model, view,
                  new StringReader("load " + file.getPath() + " " + fileName + " q"));
          current = fileName;
          controller.execute();

          errorMessage.setText("Successfully loaded " + imageName + " from location " +
                  file.getPath());
          imageL.setIcon(new ImageIcon(model.pixelsToBufferedImage(fileName)));
          resetHistograms();
        } else {
          errorMessage.setText("File could not be loaded");
        }
      }
    });

    // save button
    JButton save = new JButton("Save");
    loadSave.add(save);

    // name of the save file
    JTextField saveName = new JTextField(10);
    loadSave.add(saveName);
    saveName.setBorder(BorderFactory.createTitledBorder("save name"));

    // options for save type
    String[] saveTypes = {".jpg", ".bmp", ".ppm", ".png"};
    JComboBox<String> saveTypeOptions = new JComboBox<String>();
    for (int i = 0; i < saveTypes.length; i++) {
      saveTypeOptions.addItem(saveTypes[i]);
    }
    loadSave.add(saveTypeOptions);
    saveTypeOptions.setBorder(BorderFactory.createTitledBorder("save type"));

    // when save button is pressed
    save.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        System.out.println(saveName.getText());
        if (!model.isLoaded(current)) {
          errorMessage.setText("Save failed.\nNo image is loaded");
        } else if (saveName.getText().isBlank()) {
          errorMessage.setText("Save failed.\nMust define save name");
        } else if (pathString.equals("no path defined")) {
          errorMessage.setText("Save failed.\nNo save path defined");
        } else {
          String endPath =
                  pathString + "/" + saveName.getText() + saveTypeOptions.getSelectedItem();
          StringReader reader = new StringReader("save " + current + " " + endPath);

          ImageTextViewImpl view = new ImageTextViewImpl(model);
          ImageController controller = new ImageControllerImpl(model, view, reader);
          controller.execute();
          errorMessage.setText("Successfully saved " + saveName.getText() + " at " + endPath);
        }
      }
    });

    // the save path button, allows user to choose folder to save
    JButton savePath = new JButton("Save Path");
    loadSave.add(savePath);

    JFileChooser folderChooser = new JFileChooser();
    folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    savePath.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        int n = folderChooser.showOpenDialog(frame);
        if (n == JFileChooser.APPROVE_OPTION) {
          File file = folderChooser.getSelectedFile();
          String pathName = file.getPath();

          pathString = pathName;
          path.setText("The save path is: " + pathString);
        } else {
          errorMessage.setText("Save path could not be defined");
        }
      }
    });

    // options for user to perform operations on the image
    String[] options = {"red-component", "green-component", "blue-component", "value-component",
      "luma-component", "intensity-component", "horizontal-flip", "vertical-flip", "brighten",
      "darken", "blur", "sharpen", "grayscale", "sepia", "downscale"};
    JComboBox<String> combobox = new JComboBox<String>();
    combobox.setBorder(BorderFactory.createTitledBorder("Operations"));
    //the event listener when an option is selected
    combobox.setActionCommand("Size options");
    for (int i = 0; i < options.length; i++) {
      combobox.addItem(options[i]);
    }

    String[] optionsDownscale = {"large", "medium", "small"};
    JComboBox<String> comboboxDownscale = new JComboBox<String>();
    comboboxDownscale.setBorder(BorderFactory.createTitledBorder("Downscale options"));
    //the event listener when an option is selected
    comboboxDownscale.setActionCommand("Downscale options");
    for (int i = 0; i < optionsDownscale.length; i++) {
      comboboxDownscale.addItem(optionsDownscale[i]);
    }

    // apply button which executes the chosen operation
    comboboxPanel.add(combobox);
    comboboxPanel.add(comboboxDownscale);
    JButton run = new JButton("Apply");
    comboboxPanel.add(run);

    run.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        if (!model.isLoaded(current)) {
          errorMessage.setText("Edit failed. No image is loaded");
        } else {
          String s = combobox.getSelectedItem().toString();
          String newName = current + "-" + s;
          StringReader reader;

          if (s.equals("brighten") || s.equals("darken")) {
            reader = new StringReader(s + " 5 " + current + " " + newName + " q");
          }  else if (s.equals("downscale")) {
            reader = new StringReader(s + " " + current
                    + " " + newName + " " + comboboxDownscale.getSelectedItem());
          } else {
            reader = new StringReader(s + " " + current + " " + newName + " q");
          }

          ImageTextViewImpl view = new ImageTextViewImpl(model);
          ImageController controller = new ImageControllerImpl(model, view, reader);
          controller.execute();

          imageL.setIcon(new ImageIcon(model.pixelsToBufferedImage(newName)));
          errorMessage.setText(s + " applied to image successfully");
          current = newName;
          resetHistograms();
        }
      }
    });

    // sets up empty histograms
    histograms = new JPanel();
    histograms.setLayout(new GridLayout(2, 2));
    frame.add(histograms);
    histograms.setBorder(BorderFactory.createTitledBorder("Histograms"));

    red = new JPanel(new GridLayout(1, 0));
    histograms.add(red);
    red.setBorder(BorderFactory.createTitledBorder("red component histogram"));

    green = new JPanel(new GridLayout(1, 0));
    histograms.add(green);
    green.setBorder(BorderFactory.createTitledBorder("green component histogram"));

    blue = new JPanel(new GridLayout(1, 0));
    histograms.add(blue);
    blue.setBorder(BorderFactory.createTitledBorder("blue component histogram"));

    intensity = new JPanel(new GridLayout(1, 0));
    histograms.add(intensity);
    intensity.setBorder(BorderFactory.createTitledBorder("intensity component histogram"));

  }

}
