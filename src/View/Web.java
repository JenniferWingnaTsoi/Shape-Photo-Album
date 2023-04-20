package View;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import Model.IShapeModel;
import Model.Snapshot;
import Shape.IShape;


/**
 * The Web class is responsible for displaying the snapshots of shapes and their descriptions
 * in a web interface. It is controller by the WebController.
 * It implements the IWebView interface and extends the JFrame class.
 */
public class Web implements IWebView{

  // constants for string literals to read easily
  private static final String HTML_HEADER = "<!DOCTYPE html>\n<html>\n<body>\n";
  private static final String HTML_FOOTER = "</body>\n</html>";
  private static final String SVG_HEADER = "<svg width=\"%d\" height=\"%d\" version=\"1.1\"" +
          " style=\"border: solid 2px red; background-color:rgb(173,216,230)\"" +
          " xmlns=\"http://www.w3.org/2000/svg\"><g>\n";
  private static final String SVG_FOOTER = "</g></svg>\n<p></p>\n";
  private static final String RECTANGLE_TEMPLATE = "<rect id=\"%s\" x=\"%.2f\" y=\"%.2f\"" +
          " width=\"%.2f\" height=\"%.2f\" fill=\"rgb(%f,%f,%f)\" visibility=\"visible\"/>\n";
  private static final String OVAL_TEMPLATE = "<ellipse id=\"%s\" cx=\"%.2f\" cy=\"%.2f\"" +
          " rx=\"%.2f\" ry=\"%.2f\" fill=\"rgb(%f,%f,%f)\" visibility=\"visible\"/>\n";
  private final int wid;
  private final int height;
  private final List<Snapshot> snapshotList;
  private final StringBuilder result;

  /**
   * Constructs a Web object with the specified shape model and dimensions.
   *
   * @param model the shape model that contains the implementation of photo album
   *             and snapshots to be displayed
   * @param wid the width of the graphical interface
   * @param height the height of the graphical interface
   */
  public Web(int height,int wid,IShapeModel model){
    this.height = height;
    this.wid = wid;
    this.snapshotList = model.getSnapshotList();
    this.result = new StringBuilder();
  }


  @Override
  public void merge() {
    result.append(HTML_HEADER);
    for(Snapshot each:snapshotList){
        generateSVG(each); // generate a photo in form of web view for each snapshot
    }
    result.append(HTML_FOOTER);
  }


  @Override
  public void writeFile(String path) throws IOException {
    try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))){
      writer.write(result.toString());
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  @Override
  public String getResult() {
    return result.toString();
  }

  @Override
  public void generateSVG(Snapshot snapshot){
    if(snapshot == null){
      return;
    }
    result.append(String.format(SVG_HEADER, wid, height));
    // Get all the instance variables of each snapshot from the list
    String description = snapshot.getDescription();
    String ID = snapshot.getID();
    List<IShape> shapeList = snapshot.getShapeList();

    //Loop through all the shape to draw the shape
    for(IShape each:shapeList){
      String details;
      if(each.getType().equalsIgnoreCase("oval")){
        // ellipse instead of oval is used for drawing 2D shapes and images on a GUI
        details = String.format(OVAL_TEMPLATE,
                each.getName(),
                each.getXCoor(),each.getYCoor(),
                each.sizeOne(),each.sizeTwo(),
                each.colorR(),each.colorG(),each.colorB());
      } else if (each.getType().equalsIgnoreCase("rectangle")) {
        // a tag used to draw rectangle in SVG graphics
        details = String.format(RECTANGLE_TEMPLATE,
                each.getName(),
                each.getXCoor(),each.getYCoor(),
                each.sizeOne(),each.sizeTwo(),
                each.colorR(),each.colorG(),each.colorB());
      } else {
        throw new IllegalStateException("Invalid shape.\n");
      }
      result.append(details);
    }

    // Add snapshot ID
    result.append("<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">");
    result.append(ID).append("</text>\n");

    // Add description
    result.append("<text x=\"10\" y=\"65\" font-size=\"20\">");
    result.append("Description: ").append(description).append("</text>\n");
    result.append(SVG_FOOTER);
  }
}
