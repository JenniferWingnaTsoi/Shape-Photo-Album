package Controller;

import Model.IShapeModel;
import View.Graphic;

/**
 * This the controller for Graphic class and its implementation.
 */
public class GraphicController implements IWebGraphicController {

  private IShapeModel model;
  private Graphic screen;

  /**
   * Constructor of the GraphicController.
   * @param model the ShapeModel that carry out implementation
   */
  public GraphicController(IShapeModel model) {this.model = model;}

  @Override
  public void exhibit(int height, int wid) {
    screen = new Graphic(this.model, wid, height);
    screen.pack();
    screen.setVisible(true); // make the photo album visible
  }
}
