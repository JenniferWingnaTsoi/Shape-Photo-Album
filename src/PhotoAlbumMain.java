import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import Controller.GraphicController;
import Controller.IWebGraphicController;
import Controller.ModelController;
import Controller.WebController;
import Model.IShapeModel;
import Model.ShapeModel;

/**
 * The main class of the application that controls the program flow.
 */
public class PhotoAlbumMain {

  /**
   * The main method of the application that takes in command-line arguments and executes the program.
   *
   * @param args The command-line arguments.
   * @throws IllegalArgumentException If there is an error in the arguments or input/output files.
   * @throws IOException If there is an error reading the input file.
   */
  public static void main(String[] args) throws IllegalArgumentException, IOException {

    // init argument for main
    String outputFile = "";
    Readable inputFile = new StringReader("");

    String typeOfView = "";

    // init of canvas dimensions
    int canvasWidth = 1000;
    int canvasHeight = 1000;

    // Parse command-line arguments
    // throw index out of bound exception thrown when accessing
    // the command-line argument array args at an index that does not exist
    for (int i = 0; i < args.length; i++) {
      String arg = args[i];
      switch (arg) {
        case "-in" -> {  // Input file
          try {
            inputFile = new FileReader(args[i + 1]);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Missing input args");
          }
        }
        case "-out" -> {  // Output file
          try {
            outputFile = args[i + 1];
          } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Missing output args");
          }
        }
        case "-view","-v" -> {  // View type
          try {
            typeOfView = args[i + 1];
          } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Missing view args");
          }
        }
        case "-width" -> { // Canvas width
          try {
            canvasWidth = Integer.parseInt(args[i + 1]);
          } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException("Invalid canvas width");
          }
        }
        case "-height" -> { // Canvas height
          try {
            canvasHeight = Integer.parseInt(args[i + 1]);
          } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException("Invalid canvas height");
          }
        }
      }
    }

    // Create a new Model for each photo album
    IShapeModel model = new ShapeModel();
    // Read input file and create model
    try {
      model = ReadFile.readFile(inputFile, new ModelController() {});
    } catch (Exception e) {
      throw new IllegalArgumentException("Error reading input file");
    }



    // Create view controller based on view type
    switch (typeOfView) {
      case "web" -> {
        IWebGraphicController webController = new WebController(outputFile, model);
        webController.exhibit(canvasHeight, canvasWidth);
      }
      case "graphical" -> {
        IWebGraphicController graphicController = new GraphicController(model);
        graphicController.exhibit(canvasHeight, canvasWidth);
      }
      default -> throw new IllegalArgumentException("Invalid view type");
    }
  }
}
