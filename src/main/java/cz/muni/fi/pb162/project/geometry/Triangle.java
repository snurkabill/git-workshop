package cz.muni.fi.pb162.project.geometry;

/**
 * Represents a geometrical triangle that cen be divided to multiple triangles.
 *
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class Triangle extends ArrayPolygon {

    private Triangle[] sub;

    private static final double EPSILON = 0.001;

    /**
     * The default constructor
     *
     * @param a first side
     * @param b second side
     * @param c third side
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        super(new Vertex2D[]{a, b, c});
        this.sub = null;
    }

    /**
     * The constructor that creates Sierpinski triangle
     *
     * @param a             first side
     * @param b             second side
     * @param c             third side
     * @param divisionDepth argument for implicit call of divide method
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c, int divisionDepth) {
        this(a, b, c);
        this.divide(divisionDepth);
    }

    /**
     * Tells if the triangle was already divided
     *
     * @return boolean
     */
    public boolean isDivided() {
        return this.sub != null;
    }

    /**
     * Returns the nth sub-triangle, where i is in range [0, 2].
     *
     * @param i number of triangle
     * @return Triangle
     */
    public Triangle getSubTriangle(int i) {
        return this.sub[i];
    }

    /**
     * Recursively splits the triangle into three smaller triangles, also known as Sierpinski triangle.
     *
     * @param depth the recursion depth
     * @return boolean
     */
    public boolean divide(int depth) {
        if (depth < 0) {
            return false;
        }

        if (depth >= 0) {
            this.divide();
        }

        if (depth >= 1) {
            sub[0].divide(depth - 1);
            sub[1].divide(depth - 1);
            sub[2].divide(depth - 1);
        }

        return true;
    }

    /**
     * Splits the triangle into three smaller triangles, also known as Sierpinski triangle.
     *
     * @return boolean
     */
    public boolean divide() {
        if (isDivided()) {
            return false;
        }

        Vertex2D a = getVertex(0);
        Vertex2D b = getVertex(1);
        Vertex2D c = getVertex(2);

        Vertex2D ab = new Vertex2D((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
        Vertex2D bc = new Vertex2D((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2);
        Vertex2D ac = new Vertex2D((a.getX() + c.getX()) / 2, (a.getY() + c.getY()) / 2);

        this.sub = new Triangle[]{
            new Triangle(a, ab, ac),
            new Triangle(ab, b, bc),
            new Triangle(ac, bc, c),
        };

        return true;
    }

    /**
     * Returns true if the triangle is equilateral
     *
     * @return boolean
     */
    public boolean isEquilateral() {
        double abDistance = getVertex(0).distance(getVertex(1));
        double acDistance = getVertex(0).distance(getVertex(2));
        double cbDistance = getVertex(1).distance(getVertex(2));

        return Math.abs(abDistance - acDistance) < EPSILON && Math.abs(abDistance - cbDistance) < EPSILON;
    }

}
