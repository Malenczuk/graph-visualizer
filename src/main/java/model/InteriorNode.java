package model;

import org.graphstream.graph.implementations.AbstractGraph;
import org.javatuples.Quartet;

public class InteriorNode extends GraphNode {

    private static final String INTERIOR_SYMBOL = "I";

    private Quartet<Vertex, Vertex, Vertex, Vertex> tetrahedron;

    public InteriorNode(AbstractGraph graph, String id, Coordinates coordinates) {
        super(graph, id, INTERIOR_SYMBOL, coordinates);
    }

    public InteriorNode(AbstractGraph graph, String id, Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        super(graph, id, INTERIOR_SYMBOL, getFacePosition(v1, v2, v3, v4));
        tetrahedron = new Quartet<>(v1, v2, v3, v4);
    }


    public Quartet<Vertex, Vertex, Vertex, Vertex> getTetrahedron(){
        return tetrahedron;
    }

    public Quartet<Vertex, Vertex, Vertex, Vertex> getTetrahedronVertices() {
        return tetrahedron;
    }

    private static Coordinates getFacePosition(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        return new Coordinates(getFaceXCoordinate(v1, v2, v3, v4), getFaceYCoordinate(v1, v2, v3, v4), getFaceZCoordinate(v1, v2, v3, v4));
    }

    private static double getFaceXCoordinate(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        return (v1.getXCoordinate() + v2.getXCoordinate() + v3.getXCoordinate() + v4.getXCoordinate()) / 4d;
    }

    private static double getFaceYCoordinate(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        return (v1.getYCoordinate() + v2.getYCoordinate() + v3.getYCoordinate() + v4.getYCoordinate()) / 4d;
    }

    private static double getFaceZCoordinate(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        return (v1.getZCoordinate() + v2.getZCoordinate() + v3.getZCoordinate() + v4.getZCoordinate()) / 4d;
    }
}