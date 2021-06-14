import java.util.NoSuchElementException;

// create a class Rectangle
public class Rectangle {
    private int x;
    private  int y;
    private int height;
    private int width;

/*Write a constructor that creates a rectangle using the x, y coordinates of its lower left corner,
its width and its height in that order.Creating a rectangle with non-positive width or height should
not be allowed, although x and y are allowed to be negative.
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

/*Write a method overlap(Rectangle other).
This method should return true if this rectangle overlaps with other, false otherwise.
Rectangles that touch each other are not considered to be overlapping.
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

/*Write a method intersect(Rectangle other).
This method should return a Rectangle object that represents the overlap of the two rectangles.
If no intersection exists, it should throw a NoSuchElementException with a helpful message.
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

/*Write a method union(Rectangle other).
This method returns a Rectangle object that represents the union of this rectangle and the other rectangle.
The union is the smallest rectangle that contains both rectangles. Note that unlike the intersection, the union always exists.
 */
  public Rectangle union(Rectangle other) {
      int u_x = Math.min(this.x, other.x);
      int u_y = Math.min(this.y, other.y);
      int u_height = Math.max(this.y + this.height, other.y + other.height) - u_y;
      int u_width = Math.max(this.x + this.width, other.x + other.width) - u_x;
      Rectangle rec = new Rectangle(u_x, u_y, u_width, u_height);
      return rec;
  }

//Write a method toString that returns a String.
    @Override
    public String toString() {
      return "x:" + this.x + ", y:" + this.y + ", w:" + this.width +", h:" +this.height;
    }

}