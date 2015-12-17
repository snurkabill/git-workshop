package cz.muni.fi.pb162.project.geometry;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class Snowman {
    private Circle bottomBall;
    private Circle middleBall;
    private Circle topBall;
    private Circle leftHandBall;
    private Circle rightHandBall;

    /**
     * Constructs a snowman with several balls.
     * @param radius radius of the bottom ball
     * @param factor shrinkage factor
     */
    public Snowman(double radius, double factor) {
        if (factor <= 0 || factor > 1) {
            factor = 0.8;
        }

        bottomBall = new Circle(new Vertex2D(0.0, 0.0), radius);
        middleBall = bottomBall.moveAndShrinkY(factor);
        topBall = middleBall.moveAndShrinkY(factor);
        leftHandBall = middleBall.moveAndShrinkX(0.5);
        rightHandBall = middleBall.moveAndShrinkX(-0.5);
    }

    /**
     * @return bottom circle
     */
    public Circle getBottomBall() {
        return bottomBall;
    }

    /**
     * @return middle circle
     */
    public Circle getMiddleBall() {
        return middleBall;
    }

    /**
     * @return top circle
     */
    public Circle getTopBall() {
        return topBall;
    }

    /**
     * @return left circle
     */
    public Circle getLeftHandBall() {
        return leftHandBall;
    }

    /**
     * @return right circle
     */
    public Circle getRightHandBall() {
        return rightHandBall;
    }
}
