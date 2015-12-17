package cz.muni.fi.pb162.project.geometry;


/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class Square extends GeneralRegularPolygon {

    /**
     * Intializes a square
     *
     * @param center     the square center
     * @param edgeLength the square edge length
     */
    public Square(Vertex2D center, double edgeLength) {
        super(center, 4, edgeLength);
    }

    /**
     * Constructs a square from given circumscribed circle.
     *
     * @param radius the radius of circle
     * @param center the center of circle
     */
    public Square(double radius, Vertex2D center) {
        super(center, 4, Math.sqrt(Math.pow(radius, 2) + Math.pow(radius, 2)));
    }
}
