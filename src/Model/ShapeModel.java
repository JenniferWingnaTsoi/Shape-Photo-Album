package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Shape.IShape;
import Shape.Oval;
import Shape.Rectangle;


/**
 * The ShapeModel class is responsible for managing the collection of IShape objects.
 * and providing methods to modify and access the shapes.
 */
public class ShapeModel implements IShapeModel {
  private Map<String, IShape> shapeMap;
  private List<Snapshot> snapshotList;

  /**
   * Constructs a new ShapeModel object with an empty list of shapes.
   * an empty list of snapshot IDs, and an empty map of snapshot descriptions.
   */
  public ShapeModel() {
    snapshotList = new ArrayList<>();
    shapeMap = new LinkedHashMap<>();
  }

  public Map<String, IShape> getShapeMap() {
    return shapeMap;
  }


  @Override
  public void addShape(IShape newShape) {
    if(checkDuplicate(newShape.getName())){
      throw new IllegalArgumentException("Name already exist.");
    } else{
      shapeMap.put(newShape.getName(), newShape);
    }

  }

  @Override
  public boolean checkDuplicate(String name) {
    return shapeMap.containsKey(name);
  }

  @Override
  public void removeShape(String name) {
    shapeMap.remove(name);
  }

  @Override
  public void changeSize(String name, double size1, double size2) {
    IShape updateSize = shapeMap.get(name);
    updateSize.setSizeOne(size1);
    updateSize.setSizeTwo(size2);
    shapeMap.put(name, updateSize);
  }

  @Override
  public void changeColor(String name, double red, double green, double blue) {
    IShape updateColor = shapeMap.get(name);
    updateColor.setR(red);
    updateColor.setG(green);
    updateColor.setB(blue);
    shapeMap.put(name, updateColor);
  }

  @Override
  public void move(String name, double xcoor, double ycoor) {
    IShape updateLoc = shapeMap.get(name);
    updateLoc.setX(xcoor);
    updateLoc.setY(ycoor);
    shapeMap.put(name, updateLoc);
  }

  @Override
  public void takeSnapshot(String description) {
    LocalDateTime ID = LocalDateTime.now();
    DateTimeFormatter EastIDFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS");
    String IDString = ID.format(EastIDFormatter);

    Date timeStamp = new Date();
    SimpleDateFormat Formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


    // Create a copy of the current shapes
    List<IShape> shapes = new ArrayList<>(shapeMap.values());
    snapshotList.add(new Snapshot(IDString,description,shapes));

    /**
     *     Map<String, IShape> snapshotShapes = new HashMap<>();
     *     for (IShape shape : shapes) {
     *       snapshotShapes.put(shape.getName(), shape.copy());
     *     }
     *
     *     StringBuilder shapeinfo = new StringBuilder();
     *     for (IShape shape : snapshotShapes.values()) {
     *       shapeinfo.append(shape.toString());
     *     }
     *     String snapDetail = "SnapShot ID: " + ID
     *             + "\n" + "TimeStamp: " + Formatter.format(timeStamp)
     *             + "\n" + "Description: " + description + "\n"
     *             + "Shape Information:" + shapeinfo + "\n";
     *     descriptionMap.put(ID, snapDetail);
     */

  }

  @Override
  public List<Snapshot> getSnapshotList() {
    return snapshotList;
  }

  @Override
  public void reset() {
    shapeMap.clear();
  }


  @Override
  public String printSnapShotList() {

    return "List of snapshots taken before reset: " + snapshotList + "\n";
  }

  /*
  @Override
  public String printSnapshot() {
    StringBuilder output = new StringBuilder();
    output.append("\nPrinting Snapshots\n\n");

    List<LocalDateTime> sortedIds = new ArrayList<>(descriptionMap.keySet());
    Collections.sort(sortedIds);
    for (LocalDateTime id : sortedIds) {
      output.append(descriptionMap.get(id));
    }
    return output.toString();
  }
  */

  @Override
  public String getAllShapeInfo() {
    List<IShape> shapeList = new ArrayList<>(shapeMap.values());
    StringBuilder message = new StringBuilder();
    for (IShape shape : shapeList) {
      message.append(shape.toString());
    }
    return message.toString();
  }
}
