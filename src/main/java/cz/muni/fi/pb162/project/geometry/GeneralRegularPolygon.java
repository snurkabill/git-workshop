package cz.muni.fi.pb162.project.geometry;


/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {

    private Vertex2D center;
    private Color color;
    private int numEdges;
    private double edgeLength;

    /**
     * Initializes a black polygon.
     *
     * @param center     the polygon center
     * @param numEdges   the number of polygon edges
     * @param edgeLength the length of polygon edges
     */
    public GeneralRegularPolygon(Vertex2D center, int numEdges, double edgeLength) {
        this.center = center;
        this.numEdges = numEdges;
        this.edgeLength = edgeLength;
        this.color = Color.BLACK;
    }

    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        index = index % numEdges;
        double y = center.getX() - getRadius() * Math.cos(index * 2 * Math.PI / numEdges);
        double x = center.getY() - getRadius() * Math.sin(index * 2 * Math.PI / numEdges);
        return new Vertex2D(x, y);
    }

    @Override
    public int getNumVertices() {
        return this.numEdges;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public double getEdgeLength() {
        return edgeLength;
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return edgeLength / (2.0 * Math.sin(Math.PI / numEdges));
    }

    @Override
    public double getArea() {
        return (1.0 / 2.0) * numEdges * Math.pow(getRadius(), 2.0) * Math.sin((2 * Math.PI) / numEdges);
    }

    @Override
    public double getWidth() {
        return getRadius() * 2;
    }

    @Override
    public double getHeight() {
        return getRadius() * 2;
    }

    @Override
    public double getLength() {
        return numEdges * edgeLength;
    }

    /**
     * Returns list of triangles, that the polygon could be broken apart to.
     *
     * @return list of triangles
     */
    public Triangle[] triangulate() {
        Triangle[] parts = new Triangle[this.numEdges];

        for (int i = 0; i < this.numEdges; i++) {
            parts[i] = new Triangle(
                this.center,
                this.getVertex(i),
                this.getVertex(i + 1)
            );
        }

        return parts;
    }

    /**
     * Serializes the GeneralRegularPolygon to a string
     *
     * @return String
     */
    public String toString() {
        return numEdges + "-gon: center=" + center
            + ", edge length=" + edgeLength
            + ", color=" + color;
    }
}
