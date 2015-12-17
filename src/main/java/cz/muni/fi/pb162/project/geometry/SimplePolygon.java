package cz.muni.fi.pb162.project.geometry;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public abstract class SimplePolygon implements Polygon {

    @Override
    public double getArea() {
        double area = 0;

        for (int i = 0; i < getNumVertices(); i++) {
            area += getVertex(i).getX() * getVertex(i + 1).getY();
            area -= getVertex(i + 1).getX() * getVertex(i).getY();
        }

        return area / 2;
    }

    @Override
    public double getWidth() {
        double min = getVertex(0).getX();
        double max = getVertex(0).getX();

        for (int i = 1; i < getNumVertices(); i++) {
            min = Math.min(min, getVertex(i).getX());
            max = Math.max(max, getVertex(i).getX());
        }

        return max - min;
    }

    @Override
    public double getHeight() {
        double min = getVertex(0).getY();
        double max = getVertex(0).getY();

        for (int i = 1; i < getNumVertices(); i++) {
            min = Math.min(min, getVertex(i).getY());
            max = Math.max(max, getVertex(i).getY());
        }

        return max - min;
    }

    @Override
    public double getLength() {
        double distance = 0.0;

        for (int i = 0; i < getNumVertices(); i++) {
            distance += Math.abs(getVertex(i).distance(getVertex(i + 1)));
        }

        return distance;
    }

    /**
     * @return string representation
     */
    public String toString() {
        String ret = "Polygon: vertices =";
        for (int i = 0; i < getNumVertices(); i++) {
            ret += " " + getVertex(i);
        }

        return ret;
    }

}
