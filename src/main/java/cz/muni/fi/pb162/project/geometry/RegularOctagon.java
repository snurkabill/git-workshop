package cz.muni.fi.pb162.project.geometry;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class RegularOctagon extends GeneralRegularPolygon {

    /**
     * Initializes regular octagon.
     *
     * @param center the octagon center
     * @param edgeLength the octagon sides length
     */
    public RegularOctagon(Vertex2D center, double edgeLength) {
        super(center, 8, edgeLength);
    }

}
