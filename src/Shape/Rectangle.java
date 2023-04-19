package Shape;

/**
 * Concrete class of rectangle that implement IShape interface.
 */
public class Rectangle implements IShape {
  private String Name;
  private double xCoor;
  private double yCoor;
  private double size1;
  private double size2;
  private double colorR;
  private double colorG;
  private double colorB;
  private static final int MIN = 0;
  private static final int MAX = 255;

  /**
   * Constructor to create a rectangle.
   *
   * @param Name   String that represent the name of the rectangle.
   * @param xCoor  double value that represent the X- coordinate of rectangle.
   * @param yCoor  double value that represent the Y- coordinate of rectangle.
   * @param size1  double value that represent the X- radius.
   * @param size2  double value that represent the Y- radius.
   * @param colorR double value that represent the red RGB value.
   * @param colorG double value that represent the green RGB value.
   * @param colorB double value that represent the blue RGB value.
   */
  public Rectangle(String Name, double xCoor, double yCoor,
                   double size1, double size2, double colorR, double colorG, double colorB) {
    if (!isValidRGB(colorR, colorG, colorB)) {
      throw new IllegalArgumentException("Invalid RGB value.");
    }
    if (Name == null || Name.isEmpty()) {
      throw new IllegalArgumentException("Invalid Name.");
    }
    this.Name = Name;
    this.xCoor = xCoor;
    this.yCoor = yCoor;
    this.size1 = size1;
    this.size2 = size2;
    this.colorR = colorR;
    this.colorB = colorB;
    this.colorG = colorG;
  }

  @Override
  public double getXCoor() {
    return xCoor;
  }

  @Override
  public void setX(double x) {
    this.xCoor = x;
  }

  @Override
  public double getYCoor() {
    return yCoor;
  }

  @Override
  public void setY(double y) {
    this.yCoor = y;
  }

  @Override
  public String getName() {
    return Name;
  }

  @Override
  public double sizeOne() {
    return size1;
  }

  @Override
  public void setSizeOne(double size) {
    this.size1 = size;
  }

  @Override
  public double sizeTwo() {
    return size2;
  }

  @Override
  public void setSizeTwo(double size) {
    this.size2 = size;
  }

  @Override
  public double colorR() {
    return colorR;
  }

  @Override
  public void setR(double Red) {
    this.colorR = Red;
  }

  @Override
  public double colorG() {
    return colorG;
  }

  @Override
  public void setG(double Green) {
    this.colorG = Green;
  }

  @Override
  public double colorB() {
    return colorB;
  }

  @Override
  public void setB(double Blue) {
    this.colorB = Blue;
  }

  @Override
  public boolean isValidRGB(double r, double g, double b) {
    return (r >= MIN && r <= MAX) && (g >= MIN && g <= MAX) && (b >= MIN && b <= MAX);
  }

  @Override
  public String getType() {
    return "rectangle";
  }

  /**
   * ToString method to get a well-formatted string.
   *
   * @return a string
   */
  @Override
  public String toString() {
    return "Name: " + Name + '\n'
            + "Type: Rectangle\n"
            + "Min corner: (" + xCoor + "," + yCoor + "), "
            + "Width: " + size1 + ", Height: " + size2
            + ", Color: (" + colorR + "," + colorG + "," + colorB + ")\n";
  }
}
