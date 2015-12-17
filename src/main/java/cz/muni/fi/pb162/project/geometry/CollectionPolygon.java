package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class CollectionPolygon extends SimplePolygon {

    private List<Vertex2D> vertices;

    /**
     * Constructs a polygon from list of points
     *
     * @param points vertices
     */
    public CollectionPolygon(Vertex2D[] points) {
        if (points == null) {
            throw new IllegalArgumentException("The argument points must be an initialized list of Vertex2D objects.");
        }

        vertices = new ArrayList<>(Arrays.asList(points));
        if (vertices.contains(null)) {
            int i = vertices.indexOf(null);
            throw new IllegalArgumentException("The index " + i + " of given points is null.");
        }
    }

    /**
     * @return vertices a collection
     */
    public Collection<Vertex2D> getVertices() {
        return Collections.unmodifiableCollection(vertices);
    }

    /**
     * @return polygon with inverted vertices
     */
    public CollectionPolygon invert() {
        List<Vertex2D> inverted = new ArrayList<>(vertices);
        Collections.reverse(inverted);
        return new CollectionPolygon(inverted.toArray(new Vertex2D[inverted.size()]));
    }

    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        return vertices.get(index % vertices.size());
    }

    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    /**
     * Finds the left most vertices and removes them from the collection.
     *
     * @return collection of removed vertices
     */
    public Collection<Vertex2D> removeLeftmostVertices() {
        Vertex2D leftmost = vertices.get(0);
        for (Vertex2D item : vertices) {
            if (leftmost.getX() > item.getX()) {
                leftmost = item;
            }
        }

        List<Vertex2D> removed = new ArrayList<>();
        for (Vertex2D item : vertices) {
            if (leftmost.getX() == item.getX()) {
                removed.add(item);
            }
        }

        for (Vertex2D item : removed) {
            vertices.remove(item);
        }

        return removed;
    }
}
