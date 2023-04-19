package Shape;

/**
 * This is the concrete class of oval that implement IShape interface.
 */
public class Oval implements IShape {
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
   * Constructor to create an oval.
   *
   * @param Name   String that represent the name of the oval.
   * @param xCoor  double value that represent the X- coordinate of oval.
   * @param yCoor  double value that represent the Y- coordinate of oval.
   * @param size1  double value that represent the X- radius.
   * @param size2  double value that represent the Y- radius.
   * @param colorR double value that represent the red RGB value.
   * @param colorG double value that represent the green RGB value.
   * @param colorB double value that represent the blue RGB value.
   */
  public Oval(String Name, double xCoor, double yCoor, double size1, double size2, double colorR,
              double colorG, double colorB) {
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

  /**
   * ToString method that return a well-formatted string.
   *
   * @return a string.
   */
  @Override
  public String toString() {
    return "Name: " + Name + '\n'
            + "Type: Oval\n"
            + "Center: (" + xCoor + "," + yCoor + "), "
            + "X radius: " + size1 + ", Y radius: " + size2
            + ", Color: (" + colorR + "," + colorG + "," + colorB + ")\n";
  }

  @Override
  public String getType() {
    return "oval";
  }
}
