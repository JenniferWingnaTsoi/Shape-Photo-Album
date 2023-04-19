package View;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import Model.IShapeModel;
import Model.Snapshot;
import Shape.IShape;

public class Web implements IView {

  private static final String HTML_HEADER = "<!DOCTYPE html>\n<html>\n<body>\n";
  private static final String HTML_FOOTER = "</body>\n</html>";
  private static final String SVG_HEADER = "<svg width=\"%d\" height=\"%d\" version=\"1.1\" style=\"border: solid 2px red; background-color:rgb(173,216,230)\" xmlns=\"http://www.w3.org/2000/svg\"><g>\n";
  private static final String SVG_FOOTER = "</g></svg>\n<p></p>\n";
  private static final String RECTANGLE_TEMPLATE = "<rect id=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" height=\"%.2f\" fill=\"rgb(%f,%f,%f)\" visibility=\"visible\"/>\n";
  private static final String OVAL_TEMPLATE = "<ellipse id=\"%s\" cx=\"%.2f\" cy=\"%.2f\" rx=\"%.2f\" ry=\"%.2f\" fill=\"rgb(%f,%f,%f)\" visibility=\"visible\"/>\n";


  private final int wid;
  private final int height;
  private final List<Snapshot> snapshotList;
  private final StringBuilder result;

  public Web(int height,int wid,IShapeModel model){
    this.height = height;
    this.wid = wid;
    this.snapshotList = model.getSnapshotList();
    this.result = new StringBuilder();
  }

  /**
   * Edit to create an HTML file for display.
   */
  @Override
  public void display() {
    result.append(HTML_HEADER);
    for(Snapshot each:snapshotList){
      try{
        paintSVG(each);
      } catch (IOException e){
        e.printStackTrace();
      }
    }
    result.append(HTML_FOOTER);
  }

  public void paintSVG(Snapshot snapshot) throws IOException{
    if(snapshot == null){
      return;
    }
    result.append(String.format(SVG_HEADER, wid, height));
    //System.out.println("Signal1\n");
    // Get all the instance variables of each snapshot from the list
    String description = snapshot.getDescription();
    //System.out.println("Signal2\n");
    String ID = snapshot.getID();
    //System.out.println("Signal3\n");
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
    result.append("text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">");
    result.append(ID).append("</text>\n");

    // Add description
    result.append("<text x=\"10\" y=\"40\" font-size=\"20\">");
    result.append("Description: ").append(description).append("</text>\n");
    result.append(SVG_FOOTER);
  }

  /**
   * Saves the current SVG drawing to a file at the given file path.
   *
   * @param path the file path where the SVG file will be saved
   * @throws IOException if there is an error while writing to the file
   */
  public void writeFile(String path) throws IOException {
    try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))){
      writer.write(this.getResult());
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  public String getResult() {
    return result.toString();
  }
}
