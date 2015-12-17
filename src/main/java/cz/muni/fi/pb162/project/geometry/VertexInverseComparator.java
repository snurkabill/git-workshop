package cz.muni.fi.pb162.project.geometry;

import java.util.Comparator;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {

    @Override
    public int compare(Vertex2D v1, Vertex2D v2) {
        if (v1 == null || v2 == null) {
            throw new NullPointerException();
        }

        return v2.compareTo(v1);
    }

}
