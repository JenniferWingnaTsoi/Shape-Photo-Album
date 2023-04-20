package Controller;

import Model.IShapeModel;

/**
 * This is the interface defines the method for controlling the ShapeModel.
 */
public interface IModelController {

  /**
   * Create a new instance of ShapeModel.
   *
   * @return IShapeModel Instance
   */
  IShapeModel create();

  /**
   * Creates a new shape and adds it to the model.
   *
   * @param name  name of the shape
   * @param type  the type of the shape
   * @param xcoor x_pos of the shape
   * @param ycoor y_pos of the shape
   * @param size1 size of the first dimension of the shape
   * @param size  size of the second dimension of the shape
   * @param red   red value of the color of the shape
   * @param green green value of the color of the shape
   * @param blue  blue value of the color of the shape
   */
  void createShape(String name, String type, int xcoor, int ycoor, int size1, int size,
                   int red, int green, int blue);


  /**
   * Remove the shape to a new place.
   *
   * @param name name of the shape
   * @param newX new x_pos of the shape
   * @param newY new y_pos of the shape
   */
  void moveShape(String name, int newX, int newY);


  /**
   * Change the size of shape.
   *
   * @param name     name of the shape
   * @param newSize1 new size one
   * @param newSize2 new size two
   */
  void changeSize(String name, int newSize1, int newSize2);


  /**
   * Change the color of the shape.
   *
   * @param name     name of the shape
   * @param newRed   new red value
   * @param newGreen new green value
   * @param newBlue  new blue value
   */
  void changecolor(String name, int newRed, int newGreen, int newBlue);


  /**
   * Remove the shape from the canvas.
   *
   * @param name name of the shape to be removed
   */
  void remove(String name);

  /**
   * Take a snapshot of the canvas.
   *
   * @param Description A string that describes the snapshot
   */
  void snapShot(String Description);
}
