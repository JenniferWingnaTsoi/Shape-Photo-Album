package Model;

import java.util.List;

import Shape.IShape;

public class Snapshot {

  private String ID;
  private String description;
  private List<IShape> shapeList;

  public Snapshot(String ID,String description,List<IShape>shapeList){
    this.ID = ID;
    this.description = description;
    this.shapeList = shapeList;
  }

  public String getID() {
    return ID;
  }

  public String getDescription() {
    return description;
  }

  public List<IShape> getShapeList() {
    return shapeList;
  }
}
