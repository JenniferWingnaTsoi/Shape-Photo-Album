package View;

import java.awt.*;

import Shape.IShape;

import java.util.List;

import javax.swing.*;

/**
 * This class represents a canvas that draws and displays a list of shapes.
 */
public class Canvas extends JPanel {

  private List<IShape> shapeList;


  /**
   * Creates a new instance of the Canvas class.
   */
  public Canvas() {
    // set the background color
    this.setBackground(Color.BLUE);
  }

  /**
   * Draws a list of shapes on the canvas.
   *
   * @param shapeList the list of shapes to be drawn
   */
  public void drawShape(List<IShape> shapeList) {
    this.shapeList = shapeList;
    // clear the canvas before displaying next snapshot
    // repaint the canvas
    this.repaint();
  }

  /**
   * This method is used by the JPanel to paint the component.
   *
   * @param g the graphics object used to paint the component
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g); // set up basic background

    if (shapeList == null) {
      return;
    }
    for (IShape each : shapeList) {
      Color shapecolor = new Color((int) each.colorR(), (int) each.colorG(), (int) each.colorB());
      g.setColor(shapecolor);

      int x;
      int y;
      int size1;
      int size2;

      if (each.getType().equalsIgnoreCase("oval")) {
        x = (int) each.getXCoor();
        y = (int) each.getYCoor();
        size1 = (int) each.sizeOne();
        size2 = (int) each.sizeTwo();

        g.fillOval(x, y, size1, size2);

      } else if (each.getType().equalsIgnoreCase("rectangle")) {
        x = (int) each.getXCoor();
        y = (int) each.getYCoor();
        size1 = (int) each.sizeOne();
        size2 = (int) each.sizeTwo();

        g.fillRect(x, y, size1, size2);

      } else {
        throw new IllegalStateException("Invalid shape type/ shape list.\n");
      }
    }
  }
}
