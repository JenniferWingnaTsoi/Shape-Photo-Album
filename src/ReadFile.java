import java.util.Scanner;

import Controller.IModelController;
import Model.IShapeModel;

/**
 * The ReadFile class reads commands from a file and uses them to create an IShapeModel.
 */
public class ReadFile {

  /**
   * Reads commands from the input and executes them to create an IShapeModel.
   *
   * @param input           the input to read the commands from
   * @param albumController the controller to execute the commands on
   * @return                an IShapeModel representing the state of the shapes after executing the commands
   */
  public static IShapeModel readFile(Readable input, IModelController albumController) {
    try (Scanner scanner = new Scanner(input)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (line.isEmpty() || line.startsWith("#")) {
          continue;
        }
        String[] commandTokens = line.split("\\s+");
        String command = commandTokens[0].toLowerCase();
        switch (command) {
          case "shape" -> ShapeCommand(commandTokens, albumController);
          case "move" -> MoveCommand(commandTokens, albumController);
          case "resize" -> ResizeCommand(commandTokens, albumController);
          case "remove" -> RemoveCommand(commandTokens, albumController);
          case "color" -> ColorCommand(commandTokens, albumController);
          case "snapshot" -> SnapshotCommand(commandTokens, albumController);
          default -> System.err.println("Unknown command: " + command);
        }
      }
    }catch (Exception e) {
      System.err.println("Error while reading input file: " + e.getMessage());
    }
    return albumController.create(); // create an IShapeModel to implement command
  }


  /**
   * Creates a new shape in the {@link IShapeModel} using the given information.
   *
   * @param commandTokens the tokens containing the shape information
   * @param albumController the {@link IModelController} to use to modify the {@link IShapeModel}
   */
  private static void ShapeCommand(String[] commandTokens, IModelController albumController) {
    if(commandTokens.length != 10){
      throw new IllegalArgumentException("Shape info missing.\n");
    }
    String name = commandTokens[1];
    String type = commandTokens[2];
    int x = Integer.parseInt(commandTokens[3]);
    int y = Integer.parseInt(commandTokens[4]);
    int size1 = Integer.parseInt(commandTokens[5]);
    int size2 = Integer.parseInt(commandTokens[6]);
    int red = Integer.parseInt(commandTokens[7]);
    int green = Integer.parseInt(commandTokens[8]);
    int blue = Integer.parseInt(commandTokens[9]);
    albumController.createShape(name,type,x,y,size1,size2,red,green,blue);

  }


  /**
   * Moves the shape with the given name to the specified position.
   *
   * @param commandTokens the tokens containing the move information
   * @param albumController the {@link IModelController} to use to modify the {@link IShapeModel}
   */
  private static void MoveCommand(String[] commandTokens, IModelController albumController) {
    if(commandTokens.length!=4){
      throw new IllegalArgumentException("Shape info missing\n");
    }
    String name = commandTokens[1];
    int newX = Integer.parseInt(commandTokens[2]);
    int newY = Integer.parseInt(commandTokens[3]);
    albumController.moveShape(name,newX,newY);

  }

  /**
   * The ResizeCommand method receives an array of tokens representing the command
   * and an IModelController object
   * and calls the IModelController's changeSize method to resize a shape
   * with the specified name to the specified sizes.
   * @param commandTokens an array of strings representing the command tokens.
   * @param albumController an IModelController object that the method will use
   *                       to call the changeSize method.
   * @throws IllegalArgumentException if the commandTokens array does not contain exactly 4 elements.

   */
  private static void ResizeCommand(String[] commandTokens, IModelController albumController) {
    if(commandTokens.length!=4){
      throw new IllegalArgumentException("Missing shape info\n");
    }
    String name = commandTokens[1];
    int size1 = Integer.parseInt(commandTokens[2]);
    int size2 = Integer.parseInt(commandTokens[3]);
    albumController.changeSize(name,size1,size2);
  }

  /**
   * This method is used to execute the Remove command, which removes a shape from the album
   * @param commandTokens an array of Strings containing the command and its arguments
   * @param albumController the album controller that performs the action
   * @throws IllegalArgumentException if there are not enough arguments provided for the command
   */
  private static void RemoveCommand(String[] commandTokens, IModelController albumController) {
    if(commandTokens.length!=2){
      throw new IllegalArgumentException("Missing shape info\n");
    }
    albumController.remove(commandTokens[1]);
  }

  /**
   * This method is used to execute the Color command, which changes the color of a shape in the album
   * @param commandTokens an array of Strings containing the command and its arguments
   * @param albumController the album controller that performs the action
   * @throws IllegalArgumentException if there are not enough arguments provided for the command
   */
  private static void ColorCommand(String[] commandTokens, IModelController albumController) {
    if(commandTokens.length !=5){
      throw new IllegalArgumentException("Missing shape info");
    }
    String name = commandTokens[1];
    int red = Integer.parseInt(commandTokens[2]);
    int green = Integer.parseInt(commandTokens[3]);
    int blue = Integer.parseInt(commandTokens[4]);
    albumController.changecolor(name,red,green,blue);
  }

  /**
   * This method is used to execute the Snapshot command, which takes a snapshot of the current album
   * @param commandTokens an array of Strings containing the command and its arguments
   * @param albumController the album controller that performs the action
   */
  private static void SnapshotCommand(String[] commandTokens, IModelController albumController) {
    StringBuilder description = new StringBuilder();
    // if it is equal to 1, description is empty indx 1 is the command
    if(commandTokens.length>1){
      for(int i=1;i<commandTokens.length;i++){
        description.append(commandTokens[i]).append(" ");
      }
      description = new StringBuilder(description.toString().trim());
    }
    albumController.snapShot(description.toString());
  }
}
