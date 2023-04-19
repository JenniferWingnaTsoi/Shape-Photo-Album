package Controller;

import org.w3c.dom.css.Rect;

import Model.IShapeModel;
import Model.ShapeModel;
import Shape.IShape;
import Shape.Oval;
import Shape.Rectangle;


/**
 * This the controller for Model class and its implementation.
 */
public class ModelController implements IModelController {

  private IShapeModel newModel = new ShapeModel();

  @Override
  public IShapeModel create() {
    return this.newModel;
  }

  @Override
  public IModelController createShape(String name, String type, int xcoor, int ycoor,
                                           int size1, int size2, int red, int green, int blue) {
    IShape newshape = null;
    if(type.equalsIgnoreCase("oval")){
      newshape = new Oval(name,xcoor,ycoor, size1, size2, red, green, blue);
    }
    if(type.equalsIgnoreCase("rectangle")){
      newshape = new Rectangle(name,xcoor,ycoor, size1, size2, red, green, blue);
    }
    this.newModel.addShape(newshape);
    return this;
  }

  @Override
  public IModelController moveShape(String name, int newX, int newY) {
    this.newModel.move(name,newX,newY);
    return this;
  }

  @Override
  public IModelController changeSize(String name, int newSize1, int newSize2) {
    this.newModel.changeSize(name,newSize1,newSize2);
    return this;
  }

  @Override
  public IModelController changecolor(String name, int newRed, int newGreen, int newBlue) {
    this.newModel.changeColor(name,newRed,newGreen,newBlue);
    return this;
  }

  @Override
  public IModelController remove(String name) {
    this.newModel.removeShape(name);
    return this;
  }

  @Override
  public IModelController snapShot(String Description) {
    if(Description==null){
      Description = ""; // the description can be empty
    }
    this.newModel.takeSnapshot(Description);
    return this;
  }
}
