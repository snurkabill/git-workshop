package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class Demo {

    /**
     * @param args cli arguments
     */
    public static void main(String[] args) {
        Vertex2D a = new Vertex2D(-100, 0);
        Vertex2D b = new Vertex2D(0, 100);
        Vertex2D c = new Vertex2D(100, -100);
        Triangle t = new Triangle(a, b, c);
        System.out.println(t.toString());
    }
}
