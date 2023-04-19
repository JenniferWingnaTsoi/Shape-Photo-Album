package Model;


import java.util.List;

import Shape.IShape;

/**
 * The IShapeModel interface represents the model component of the Model-View-Controller (MVC) architecture.
 * It defines the methods that will be implemented in the ShapeModel class to carry out the functions of the photo album application.
 */
public interface IShapeModel {

  /**
   * Checks if a shape with the given name already exists in the photo album.
   *
   * @param name the name of the shape to check for duplicates
   * @return true if the shape with the given name already exists, false otherwise
   */
  boolean checkDuplicate(String name);


  /**
   * Adds a new shape to the photo album.
   *
   * @param newShape the new shape to be added
   */
  void addShape(IShape newShape);

  /**
   * Removes a shape from the photo album.
   *
   * @param name the name of the shape to be removed
   */
  void removeShape(String name);

  /**
   * Changes the size of a shape in the photo album.
   *
   * @param name  the name of the shape to be resized
   * @param size1 the new size of the first dimension of the shape
   * @param size2 the new size of the second dimension of the shape
   */
  void changeSize(String name, double size1, double size2);

  /**
   * Changes the color of a shape in the photo album.
   *
   * @param name  the name of the shape to be recolored
   * @param red   the new value of the red component of the color
   * @param green the new value of the green component of the color
   * @param blue  the new value of the blue component of the color
   */
  void changeColor(String name, double red, double green, double blue);

  /**
   * Moves a shape to a new position in the photo album.
   *
   * @param name  the name of the shape to be moved
   * @param xcoor the new x-coordinate of the shape
   * @param ycoor the new y-coordinate of the shape
   */
  void move(String name, double xcoor, double ycoor);

  List<Snapshot> getSnapshotList();

  /**
   * Resets the photo album to its initial state with no shapes.
   */
  void reset();

  /**
   * Takes a snapshot of the current state of the photo album with a description.
   *
   * @param description the description of the snapshot
   */
  void takeSnapshot(String description);

  /**
   * Returns a string representation of the list of all snapshots taken in the photo album.
   *
   * @return the list of snapshots taken in the photo album
   */
  String printSnapShotList();


  /**
   * Returns a string representation of all the shapes currently in the photo album.
   *
   * @return the information of all the shapes in the photo album
   */
  String getAllShapeInfo();
}
