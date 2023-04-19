package Controller;

import Model.IShapeModel;
import View.Graphic;

public class GraphicController implements IWebGraphicController{

  private IShapeModel model;
  private Graphic screen;

  public GraphicController(IShapeModel model){
    this.model = model;
  }
  @Override
  public void exhibit(int height, int wid) {
    screen = new Graphic(this.model,wid,height);
    screen.display();
  }
}
