package Shape;

/**
 * This interface represents a shape in the photo album.
 * It defines methods for getting and setting the shape's properties, such as
 * its x and y coordinates, name, size, and RGB values.
 */
public interface IShape {

   /**
    * Gets the x-coordinate of the shape.
    *
    * @return the x-coordinate
    */
   double getXCoor();

   /**
    * Sets the x-coordinate of the shape.
    *
    * @param x the new x-coordinate
    */
   void setX(double x);

   /**
    * Gets the y-coordinate of the shape.
    *
    * @return the y-coordinate
    */
   double getYCoor();

   /**
    * Sets the y-coordinate of the shape.
    *
    * @param y the new y-coordinate
    */
   void setY(double y);

   /**
    * Gets the name of the shape.
    *
    * @return the name
    */
   String getName();

   /**
    * Gets the size of the shape in the first dimension.
    *
    * @return the size in the first dimension
    */
   double sizeOne();

   /**
    * Sets the size of the shape in the first dimension.
    *
    * @param size the new size in the first dimension
    */
   void setSizeOne(double size);

   /**
    * Gets the size of the shape in the second dimension.
    *
    * @return the size in the second dimension
    */
   double sizeTwo();

   /**
    * Sets the size of the shape in the second dimension.
    *
    * @param size the new size in the second dimension
    */
   void setSizeTwo(double size);

   /**
    * Gets the value of the red component of the shape's RGB color.
    *
    * @return the red component
    */
   double colorR();

   /**
    * Sets the value of the red component of the shape's RGB color.
    *
    * @param Red the new value of the red component
    */
   void setR(double Red);

   /**
    * Gets the value of the green component of the shape's RGB color.
    *
    * @return the green component
    */
   double colorG();

   /**
    * Sets the value of the green component of the shape's RGB color.
    *
    * @param Green the new value of the green component
    */
   void setG(double Green);

   /**
    * Gets the value of the blue component of the shape's RGB color.
    *
    * @return the blue component
    */
   double colorB();

   /**
    * Sets the value of the blue component of the shape's RGB color.
    *
    * @param Blue the new value of the blue component
    */
   void setB(double Blue);

   /**
    * Checks if the given RGB values are valid.
    *
    * @param r the red component
    * @param g the green component
    * @param b the blue component
    * @return true if the RGB values are valid, false otherwise
    */
   boolean isValidRGB(double r, double g, double b);



   String getType();
}
