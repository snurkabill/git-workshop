package cz.muni.fi.pb162.project.geometry;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class ArrayPolygon extends SimplePolygon {

    private Vertex2D[] points;

    /**
     * Constructs a polygon from list of points
     *
     * @param points vertices
     */
    public ArrayPolygon(Vertex2D[] points) {
        if (points == null) {
            throw new IllegalArgumentException("The argument points must be an initialized list of Vertex2D objects.");
        }

        this.points = new Vertex2D[points.length];
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("The index " + i + " of given points is null.");
            }

            this.points[i] = points[i];
        }
    }

    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        return points[index % points.length];
    }

    @Override
    public int getNumVertices() {
        return points.length;
    }

    /**
     * Returns a new polygon, with vertices in reverse order
     *
     * @return inverted polygon
     */
    public ArrayPolygon invert() {
        Vertex2D[] inverted = new Vertex2D[points.length];

        for (int l = 0, i = points.length - 1; i >= 0; i--) {
            inverted[l++] = points[i];
        }

        return new ArrayPolygon(inverted);
    }

    /**
     * Compares two array polygons if they're equal.
     *
     * @param other the other polygon to compare against
     * @return if the polygons are equal
     */
    public boolean compare(ArrayPolygon other) {
        if (other.getNumVertices() != this.getNumVertices()) {
            return false;
        }

        for (int nthVertex = 0, j; nthVertex < points.length; nthVertex++) {
            j = 0; // find first same point starting from our 0
            if (!this.getVertex(j).compare(other.getVertex(nthVertex))) {
                continue;

            } else if (points.length == 1) {
                return true; // if there is only one point, they are already equal
            }

            // try in the right direction
            if (this.compareFromOffsetInDirection(other, nthVertex, +1)) {
                return true;
            }

            // try in the left direction
            if (this.compareFromOffsetInDirection(other, nthVertex, -1)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Compares two polygons from the given offset of the other polygon in the given direction.
     *
     * @param other     the other polygon to compare against
     * @param offset    of the other polygon
     * @param direction left or right
     * @return if the polygons are equal
     */
    private boolean compareFromOffsetInDirection(ArrayPolygon other, int offset, int direction) {
        for (int j = 1; j < points.length; j++) {
            offset = (points.length + offset + direction) % points.length;
            if (!this.getVertex(j).compare(other.getVertex(offset))) {
                return false; // not equal
            }
        }

        return true;
    }

}
