
import java.lang.Math;

public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    //A constructor that takes in x, y, z components of the vector.
    public Vector3D (double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Methods to get the values of individual components(e.g. getX ,etc.).


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    //A toString method that returns a string that describes this vector.
    // Each component should be formatted to round to exactly two decimal

    public String toString() {
        return "(" + String.format("%.2f",x) +"," + String.format("%.2f", y) + "," + String.format("%.2f",z) + ")";
    }

    //A method getMagnitude that returns its magnitude.
    public double getMagnitude(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    //A method normalize that returns a normalized version of this vector.
    public Vector3D normalized() {
        if (getMagnitude() < 1e-6) {
            throw new IllegalStateException();
        }
        return new Vector3D(x / getMagnitude(), y / getMagnitude(), z / getMagnitude());
    }

    //A method add that returns the result of adding this vector to another vector.
    public Vector3D add(Vector3D v){
        return new Vector3D(x+v.getX(), y+v.getY(), z+v.getZ());
    }

    //A method multiply that returns the result of multiplying this vector by a constant.
    public Vector3D multiply(double c){
        return new Vector3D(x*c, y*c, z*c);
    }

    //A method dotProduct that returns the dot product of this vector and another vector.
    public Vector3D dotProduct(Vector3D v) {
        return new Vector3D(x * v.getX(), y * v.getY(), z * v.getZ());
    }

    //A method angleBetween that returns the angle between two vectors in degrees. It should not change the two vectors.
    //It should throw an IllegalStateException if this operation cannot be completed.
    public double angleBetween(Vector3D v){
        if(getMagnitude() < 1e-6 || v.getMagnitude() < 1e-6){
            throw new IllegalStateException();
        }
        Vector3D v1_norm = this.normalized();
        Vector3D v2_norm = v.normalized();
        return Math.toDegrees(Math.acos(v1_norm.getX()*v2_norm.getX()+ v1_norm.getY()* v2_norm.getY()+ v1_norm.getZ()* v2_norm.getZ()));

    }
}
