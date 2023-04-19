package Controller;

import Model.IShapeModel;

public interface IModelController {

  IShapeModel create();
  IModelController createShape(String name, String type,int xcoor, int ycoor, int size1, int size,
                            int red, int green, int blue);

  IModelController moveShape(String name, int newX, int newY);

  IModelController changeSize(String name, int newSize1, int newSize2);

  IModelController changecolor(String name, int newRed, int newGreen, int newBlue);
  IModelController  remove(String name);
  IModelController  snapShot(String Description);
}
