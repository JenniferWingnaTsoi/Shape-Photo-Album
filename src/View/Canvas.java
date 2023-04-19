package View;

import java.awt.*;
import Shape.IShape;
import java.util.List;
import javax.swing.*;

public class Canvas extends JPanel {

  private List<IShape> shapeList;

  public List<IShape> getShapeList() {
    return shapeList;
  }

  public Canvas(){
    // set the background color
    this.setBackground(Color.BLUE);
  }

  public void drawShape(List<IShape> shapeList){
    this.shapeList = shapeList;
    // clear the canvas before displaying next snapshot
    // repaint the canvas
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g); // set up basic background

    for(IShape each:shapeList){
      Color shapecolor = new Color((int)each.colorR(),(int)each.colorG(),(int)each.colorB());
      g.setColor(shapecolor);

      if(each.getType().equalsIgnoreCase("oval")){
        g.fillOval((int) each.getXCoor(),(int) each.getYCoor(),(int) each.sizeOne(),(int) each.sizeTwo());
      } else if (each.getType().equalsIgnoreCase("rectangle")) {
        g.fillRect((int) each.getXCoor(),(int) each.getYCoor(),(int) each.sizeOne(),(int) each.sizeTwo());
      } else{
        throw new IllegalStateException("Invalid shape type/ shape list.\n");
      }
    }
  }
}
