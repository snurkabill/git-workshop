package cz.muni.fi.pb162.project.geometry;


/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class OlympicRings {

    private Circle blackRing;
    private Circle blueRing;
    private Circle redRing;
    private Circle yellowRing;
    private Circle greenRing;

    /**
     * Initializes olympic rings structure relative to given black circle.
     * @param blackCenter the center of black circle
     * @param circlesRadius the radius of black circle
     */
    public OlympicRings(Vertex2D blackCenter, double circlesRadius) {
        blackRing = new Circle(blackCenter, circlesRadius);

        blueRing = blackRing.moveX(-circlesRadius * 2 - 10);
        blueRing.setColor(Color.BLUE);

        redRing = blackRing.moveX(circlesRadius * 2 + 10);
        redRing.setColor(Color.RED);

        yellowRing = blackRing.moveX(-circlesRadius - 5).moveY(-circlesRadius - 5);
        yellowRing.setColor(Color.YELLOW);

        greenRing = blackRing.moveX(circlesRadius + 5).moveY(-circlesRadius - 5);
        greenRing.setColor(Color.GREEN);
    }

    public Circle getBlackRing() {
        return blackRing;
    }

    public Circle getBlueRing() {
        return blueRing;
    }

    public Circle getRedRing() {
        return redRing;
    }

    public Circle getYellowRing() {
        return yellowRing;
    }

    public Circle getGreenRing() {
        return greenRing;
    }
}
