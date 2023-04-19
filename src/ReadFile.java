import java.util.Scanner;

import Controller.IModelController;
import Model.IShapeModel;

/**
 * This class reads script from a file and executes the commands.
 */
public class ReadFile {

  /**
   * Parses an animation script and builds a model of the animation.
   *
   * @param input a Readable object that provides access to the file
   * @param albumController  a controller that is used to construct the model
   * @return the model of the animation
   */
  public static IShapeModel readFile(Readable input, IModelController albumController) {
    try (Scanner scanner = new Scanner(input)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
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

  private static void MoveCommand(String[] commandTokens, IModelController albumController) {
    if(commandTokens.length!=4){
      throw new IllegalArgumentException("Shape info missing\n");
    }
    String name = commandTokens[1];
    int newX = Integer.parseInt(commandTokens[2]);
    int newY = Integer.parseInt(commandTokens[3]);
    albumController.moveShape(name,newX,newY);

  }

  private static void ResizeCommand(String[] commandTokens, IModelController albumController) {
    if(commandTokens.length!=4){
      throw new IllegalArgumentException("Missing shape info\n");
    }
    String name = commandTokens[1];
    int size1 = Integer.parseInt(commandTokens[2]);
    int size2 = Integer.parseInt(commandTokens[3]);
    albumController.changeSize(name,size1,size2);
  }


  private static void RemoveCommand(String[] commandTokens, IModelController albumController) {
    if(commandTokens.length!=2){
      throw new IllegalArgumentException("Missing shape info\n");
    }
    albumController.remove(commandTokens[1]);
  }

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
