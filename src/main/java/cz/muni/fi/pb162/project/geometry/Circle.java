package cz.muni.fi.pb162.project.geometry;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class Circle extends GeneralRegularPolygon implements Solid {

    private double radius;

    /**
     * Creates circle with center in the given vertex with given radius
     *
     * @param center the center of the circle
     * @param radius the radius of the circle
     */
    public Circle(Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, 0.0);
        this.radius = radius;
    }

    /**
     * Creates circle in the origin with radius 1
     */
    public Circle() {
        this(new Vertex2D(0, 0), 1.0);
    }

    /**
     * Returns the radius of the circle
     *
     * @return double
     */
    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getLength() {
        return 2.0 * Math.PI * this.radius;
    }

    /**
     * Move the circle in X direction and shrink it
     *
     * @param factor shrink factor
     * @return new circle
     */
    public Circle moveAndShrinkX(double factor) {
        double newRadius = this.getRadius() * Math.abs(factor);
        return new Circle(this.getCenter().add((this.getRadius() + newRadius) * Math.signum(factor), 0.0), newRadius);
    }

    /**
     * Move the circle in Y direction and shrink it
     *
     * @param factor shrink factor
     * @return new circle
     */
    public Circle moveAndShrinkY(double factor) {
        double newRadius = this.getRadius() * Math.abs(factor);
        return new Circle(this.getCenter().add(0.0, (this.getRadius() + newRadius) * Math.signum(factor)), newRadius);
    }

    /**
     * Move the circle in X direction
     *
     * @param length shrink factor
     * @return new circle
     */
    public Circle moveX(double length) {
        return new Circle(this.getCenter().add(length, 0.0), this.radius);
    }

    /**
     * Move the circle in Y direction
     *
     * @param length shrink factor
     * @return new circle
     */
    public Circle moveY(double length) {
        return new Circle(this.getCenter().add(0.0, length), this.radius);
    }

    /**
     * Returns string representation fo circle
     *
     * @return String
     */
    public String toString() {
        return "Circle: center=" + this.getCenter() + ", radius=" + this.radius;
    }
}
