package cz.muni.fi.pb162.project.geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class LabeledPolygon extends SimplePolygon implements PolygonIO {

    private SortedMap<String, Vertex2D> points = new TreeMap<>();

    /**
     * Adds a vertex to the polygon.
     *
     * @param label name of vertex
     * @param vert  vertex
     */
    public void addVertex(String label, Vertex2D vert) {
        if (label == null) {
            throw new IllegalArgumentException("label");
        }
        if (vert == null) {
            throw new IllegalArgumentException("vert");
        }

        points.put(label, vert);
    }

    /**
     * Returns vertex by name.
     *
     * @param label name of vertex
     * @return vertex
     */
    public Vertex2D getVertex(String label) {
        Vertex2D point = points.get(label);
        if (point == null) {
            throw new IllegalArgumentException("Unknown vertex " + label);
        }

        return point;
    }

    /**
     * @return collection of labels
     */
    public Collection<String> getLabels() {
        return Collections.unmodifiableSet(points.keySet());
    }

    /**
     * @return naturally sorted set of vertices
     */
    public Collection<Vertex2D> getSortedVertices() {
        return new TreeSet<>(points.values());
    }

    /**
     * @param comparator sorts the set
     * @return set of vertices sorted with comparator
     */
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        Collection<Vertex2D> sorted = new TreeSet<>(comparator);
        sorted.addAll(points.values());
        return sorted;
    }

    /**
     * Set of keys that contain vertex with given value.
     *
     * @param vertex vertex to search for
     * @return collection of keys
     */
    public Collection<String> getLabels(Vertex2D vertex) {
        return points.entrySet()
            .stream()
            .filter(entry -> Objects.equals(vertex, entry.getValue()))
            .map(Map.Entry<String, Vertex2D>::getKey)
            .collect(Collectors.toSet());
    }

    /**
     * @return set of vertexes, that are duplicated in the polygon
     */
    public Collection<Vertex2D> duplicateVertices() {
        List<Vertex2D> existing = new ArrayList<>();
        List<Vertex2D> duplicates = new ArrayList<>();

        for (Vertex2D item : points.values()) {
            if (existing.contains(item)) {
                duplicates.add(item);
            } else {
                existing.add(item);
            }
        }

        return duplicates;
    }

    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("negative index");
        }

        return new ArrayList<>(points.values()).get(index % points.size());
    }

    @Override
    public int getNumVertices() {
        return points.size();
    }

    /**
     * Write the polygon data into given output stream using binary write
     * @param os the output stream that will the method write to
     * @throws IOException when the something fails
     */
    public void binaryWrite(OutputStream os) throws IOException {
        for (Map.Entry<String, Vertex2D> entry : points.entrySet()) {
            Vertex2D item = entry.getValue();
            os.write(String.format("%s %s %s%n", item.getX(), item.getY(), entry.getKey()).getBytes());
        }
    }

    @Override
    public void write(OutputStream os) throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(os));

        for (Map.Entry<String, Vertex2D> entry : points.entrySet()) {
            Vertex2D item = entry.getValue();
            wr.write(String.format("%s %s %s", item.getX(), item.getY(), entry.getKey()));
            wr.newLine();
        }
    }

    @Override
    public void write(File file) throws IOException {
        try (FileOutputStream os = new FileOutputStream(file)) {
            write(os);
        }
    }

    @Override
    public void read(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        SortedMap<String, Vertex2D> loadedPoints = new TreeMap<>();

        String line = br.readLine();
        while (line != null) {
            String[] rec = line.split(" ", 3);
            if (rec.length != 3) {
                throw new IOException("Invalid format");
            }

            try {
                loadedPoints.put(rec[2], new Vertex2D(
                    Double.valueOf(rec[0]),
                    Double.valueOf(rec[1])
                ));

            } catch (NumberFormatException e) {
                throw new IOException("Expected number", e);
            }

            line = br.readLine();
        }

        this.points.putAll(loadedPoints);
    }

    @Override
    public void read(File file) throws IOException {
        try (FileInputStream is = new FileInputStream(file)) {
            read(is);
        }
    }

}
