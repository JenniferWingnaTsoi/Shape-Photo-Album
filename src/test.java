import Model.IShapeModel;
import Model.ShapeModel;
import Model.Snapshot;
import Shape.IShape;
import Shape.Oval;
import Shape.Rectangle;

public class test {

  public static void main(String[] args) {
    IShapeModel model = new ShapeModel();
    model.takeSnapshot("empty");

    Oval one = new Oval("one",10,10,10,10,20,20,20);
    Rectangle two = new Rectangle("two",10,10,10,10,20,20,20);
    Rectangle three = new Rectangle("two",10,10,10,10,20,20,20);
    System.out.println(model.printSnapShotList());
    model.addShape(one);
    model.takeSnapshot("first");
    System.out.println(model.printSnapShotList());
    model.addShape(two);
    model.takeSnapshot("third");
    System.out.println(model.printSnapShotList());

    for(Snapshot each: model.getSnapshotList()){
      System.out.println(each.getShapeList());
    }

  }
}
