package Controller;

import java.io.IOException;

import Model.IShapeModel;
import View.Web;

/**
 * This the controller for Web class and its implementation.
 */
public class WebController implements IWebGraphicController {
  private String outputPath;
  private IShapeModel model;
  private Web webview;

  /**
   * Constructor of WebController.
   * @param outputPath the file path of output file
   * @param model the ShapeModel to be used.
   */
  public WebController(String outputPath, IShapeModel model) {
    this.model = model;
    this.outputPath = outputPath;
  }

  @Override
  public void exhibit(int height, int wid) {
    webview = new Web(height, wid, model);
    webview.merge(); // start to merge and edit the content for html file
    try {
      webview.writeFile(outputPath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
