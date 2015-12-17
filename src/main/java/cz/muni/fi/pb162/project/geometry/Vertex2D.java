package cz.muni.fi.pb162.project.geometry;

/**
 * Represents a point in 2D.
 *
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class Vertex2D implements Comparable<Vertex2D> {
    private double x;
    private double y;

    /**
     * The default constructor
     *
     * @param x axis point
     * @param y axis point
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the value of x
     *
     * @return double
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the value of y
     *
     * @return double
     */
    public double getY() {
        return y;
    }

    /**
     * Computes the Euclidean distance between two vertexes
     *
     * @param other the second vertex to compute the distance to
     * @return double
     */
    public double distance(Vertex2D other) {
        if (other == null) {
            return -1.0;
        }

        double a = this.getX() - other.getX();
        double b = this.getY() - other.getY();
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /**
     * Sums two vertexes and returns new object.
     *
     * @param other the second vertex to add
     * @return new moved vertex
     */
    public Vertex2D add(Vertex2D other) {
        if (other == null) {
            return this;
        }

        return new Vertex2D(x + other.getX(), y + other.getY());
    }

    /**
     * Adds given coordinates to current vertex and returns new object.
     *
     * @param addX the X coordinate
     * @param addY the Y coordinate
     * @return new moved vertex
     */
    public Vertex2D add(double addX, double addY) {
        return new Vertex2D(x + addX, y + addY);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertex2D)) {
            return false;
        }

        Vertex2D other = (Vertex2D) o;
        return other.x == this.x && other.y == this.y;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32)); // ^ Bitwise exclusive OR ... >>> Unsigned right shift
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Vertex2D b) {
        if (b == null) {
            return 0;
        }

        int x = Double.compare(this.getX(), b.getX());
        if (x != 0) {
            return x;
        }

        return Double.compare(this.getY(), b.getY());
    }

    /**
     * Compares two vertexes.
     *
     * @param other the other vertex to compare against
     * @return if the vertexes are equal
     */
    public boolean compare(Vertex2D other) {
        return other.x == this.x && other.y == this.y;
    }

    /**
     * Serializes the coordinates to string
     *
     * @return String
     */
    public String toString() {
        return "[" + Double.toString(x) + ", " + Double.toString(y) + "]";
    }

}
