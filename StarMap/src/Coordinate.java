/** Kevin Paul, 4B*/

public class Coordinate {
    public double x,y,z;
    private boolean isTriple = false;

    public Coordinate(double x, double y) {
        this.x = x; this.y = y; this.z = 0;
    }

    public Coordinate(double x, double y, double z) {
        this.x = x; this.y = y; this.z = z;
        isTriple = true;
    }

    public String toString() {
        if(isTriple) {
            return "{" + x + ", " + y + ", " + z + "}";
        } else {
            return "{" + x + ", " + y + "}";
        }
    }
}