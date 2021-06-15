import java.util.NoSuchElementException;

/**
 * create a class Rectangle
 * @author jingjing lin
 * @version 1.0
 * @since 2021-05-14
 */
public class Rectangle {
    private int x;
    private  int y;
    private int height;
    private int width;

  /**
  *Write a constructor that creates a rectangle using the x, y coordinates of its lower left corner,
  its width and its height in that order.
  *if the height or width is small or equal to zero, then, throw a illegal argument Exception
   * @param x x the coordinates of its lower left corner
   * @param y y the coordinates of its lower left corner
   * @param width the rectangle's width
   * @param height the rectangle's height
  */
  public Rectangle(int x, int y, int width, int height) {
      if(height <= 0 || width <= 0) {
          throw new IllegalArgumentException("Height or width should be non-positive!");
      }
      this.x = x;
      this.y = y;
      this.height = height;
      this.width = width;
  }

  /**
   * Write a method overlap(Rectangle other).
   * @param other input other rectangle
   * @return boolean This returns if it is overlap
   */
  public boolean overlap(Rectangle other) {
      if(other.x+other.width <= this.x) {
          return false;
      } else if(other.x >= this.x+this.width) {
          return false;
      } else if(other.y+ other.height <= this.y) {
          return false;
      } else if(other.y >= this.y+this.height) {
          return false;
      } else {
          return true;
      }
  }

  /**
   *Write a method intersect(Rectangle other).
   * @param other input other rectangle
   * @return Rectangle. Rectangle of intersect
   */
  public Rectangle intersect(Rectangle other) {
      if(!overlap(other)) {
          throw new NoSuchElementException("No intersect!");
      } else {
          int i_x = Math.max(this.x, other.x);
          int i_y = Math.max(this.y, other.y);
          int i_height = Math.min(this.y+this.height, other.y+other.height) - i_y;
          int i_width = Math.min(this.y+this.width, other.y+other.width) - i_x;
          Rectangle rec = new Rectangle(i_x, i_y, i_width, i_height);
          return rec;
      }
  }

  /**
  *Write a method union(Rectangle other).
   * @param other input other rectangle
   * @return Rectangle. Rectangle of union
   */
  public Rectangle union(Rectangle other) {
      int u_x = Math.min(this.x, other.x);
      int u_y = Math.min(this.y, other.y);
      int u_height = Math.max(this.y + this.height, other.y + other.height) - u_y;
      int u_width = Math.max(this.x + this.width, other.x + other.width) - u_x;
      Rectangle rec = new Rectangle(u_x, u_y, u_width, u_height);
      return rec;
  }

    /**
     *  Write a method toString that returns a String.
     * @return String This is print out
     */

    @Override
    public String toString() {
      return "x:" + this.x + ", y:" + this.y + ", w:" + this.width +", h:" +this.height;
    }

}