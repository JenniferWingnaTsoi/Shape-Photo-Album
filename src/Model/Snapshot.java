package Model;

import java.util.List;

import Shape.IShape;

/**
 * This class represents a snapshot of the current state of the drawing canvas,
 * including the shapes on the canvas and a unique identifier and description.
 */
public class Snapshot {

  private String ID;
  private String description;
  private List<IShape> shapeList;

  /**
   * Constructs a Snapshot object with the given identifier, description, and list of shapes.
   *
   * @param ID the unique identifier of the snapshot
   * @param description a brief description of the snapshot
   * @param shapeList a list of the shapes on the canvas at the time the snapshot was taken
   */
  public Snapshot(String ID, String description, List<IShape> shapeList) {
    this.ID = ID;
    this.description = description;
    this.shapeList = shapeList;
  }

  /**
   * Returns the unique identifier of the snapshot.
   *
   * @return the unique identifier of the snapshot
   */
  public String getID() {
    return ID;
  }

  /**
   * Returns the description of the snapshot.
   *
   * @return the description of the snapshot
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns a list of the shapes on the canvas at the time the snapshot was taken.
   *
   * @return a list of the shapes on the canvas at the time the snapshot was taken
   */
  public List<IShape> getShapeList() {
    return shapeList;
  }
}
