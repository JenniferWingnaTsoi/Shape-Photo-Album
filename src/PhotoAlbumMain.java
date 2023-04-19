import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;

import javax.swing.*;


import Controller.GraphicController;
import Controller.IModelController;
import Controller.IWebGraphicController;
import Controller.ModelController;
import Controller.WebController;
import Model.IShapeModel;
import Model.ShapeModel;

import javax.swing.JOptionPane;

/**
 * This is the Main class for running the Photo album in view and web mode.
 */
public class PhotoAlbumMain {
  /**
   * This is the main method that takes in the command line.
   *
   * @param args command line
   * @throws IllegalArgumentException if there exists illegal parameters.
   */
  public static void main(String[] args) throws IllegalArgumentException, IOException {
    IShapeModel model = new ShapeModel();
    String typeOfView = "";
    String output = "";
    Readable in = new StringReader("");
    int width = 1000;
    int height = 1000;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        try {
          in = new FileReader(args[i + 1]);
        } catch (FileNotFoundException e) {
          ErrorMessage("File not found: " + args[i + 1]);
        } catch (IndexOutOfBoundsException e) {
          ErrorMessage("File not specified");
        }
      }

      if (args[i].equals("-v") || args[i].equals("-view")) {
        try {
          typeOfView = args[i + 1];
        } catch (IndexOutOfBoundsException e) {
          ErrorMessage("View not specified");
        }
      }

      if (args[i].equals("-out")) {
        try {
          output = args[i + 1];
        } catch (IndexOutOfBoundsException e) {
          ErrorMessage("Output file not defined.");
        }
      }

      try {
        width = Integer.parseInt(args[i]);
        height = Integer.parseInt(args[i]);
      } catch (NumberFormatException ignored) {
      }
    }

    try {
      model = ReadFile.readFile(in, new ModelController() {
      });
    } catch (Exception e) {
      JOptionPane.showMessageDialog(new JFrame(), "Read file failure: " + e.getMessage());
      System.exit(0);
    }

    switch (typeOfView) {
      case "web":
        IWebGraphicController webController = new WebController(output, model);
        webController.exhibit(height, width);
        break;
      case "graphical":
        IWebGraphicController graphController = new GraphicController(model);
        graphController.exhibit(height, width);
        break;
      default:
        ErrorMessage("Invalid view choice " + typeOfView);
    }

  }

  /**
   * If there exists invalid input, pop up dialogue box.
   *
   * @param message messages for different invalid inputs
   */
  private static void ErrorMessage(String message) {
    JOptionPane.showMessageDialog(null, message,
            "Error", JOptionPane.ERROR_MESSAGE);
    System.exit(1);
  }
}