package cz.muni.fi.pb162.project.geometry;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class Gauger {

    /**
     * Outputs measurements of a Measurable object
     *
     * @param measurable geometry object
     */
    public static void printMeasurement(Measurable measurable) {
        System.out.println(measurable.toString());
        System.out.println("Length/Perimeter: " + measurable.getLength());
    }

    /**
     * Outputs measurements of a Solid object
     *
     * @param solid geometry object
     */
    public static void printMeasurement(Solid solid) {
        printMeasurement((Measurable) solid);
        System.out.println("Area: " + solid.getArea());
    }
}
