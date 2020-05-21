package transform;

import model.*;

public class Transform2122Closure {

    public static ModelGraph transform(ModelGraph g) {

        Vertex v1 = g.getVertex("n4").get();
        Vertex v2 = g.getVertex("n3").get();
        Vertex v3 = g.getVertex("n2").get();
        Vertex v4 = g.getVertex("n1").get();

        FaceNode t1 = g.getFace("t1").get();
        FaceNode t2 = g.getFace("t2").get();
        FaceNode t3 = g.getFace("t4").get();
        FaceNode t4 = g.getFace("t3").get();


        /* REFINE T1 */

        // vertices
        Coordinates coord5 = v4.getCoordinates().middlePoint(v3.getCoordinates());
        Vertex v5 = g.insertVertex("n5", coord5);

        // edges
        g.deleteEdge(v4, v3);
        g.insertEdge("e7", v5, v2, true);
        g.insertEdge("e8", v5, v3, true);
        g.insertEdge("e9", v5, v4, true);

        // faces
        g.removeFace(t1.getId());
        g.insertFace("t5", v2, v3, v5);
        g.insertFace("t6", v2, v5, v4);

        /* REFINE T2 */

        // vertices
        Coordinates coord6 = v1.getCoordinates().middlePoint(v3.getCoordinates());
        Coordinates coord7 = v1.getCoordinates().middlePoint(v4.getCoordinates());
        Vertex v6 = g.insertVertex("n6", coord6);
        Vertex v7 = g.insertVertex("n7", coord7);

        // edges
        g.insertEdge("e10", v1, v5, true);

        g.deleteEdge(v1, v3);
        g.insertEdge("e11", v6, v1, true);
        g.insertEdge("e12", v6, v3, true);
        g.insertEdge("e13", v6, v5, true);

        g.deleteEdge(v1, v4);
        g.insertEdge("e14", v7, v1, true);
        g.insertEdge("e15", v7, v4, true);
        g.insertEdge("e16", v7, v5, true);

        // faces
        g.removeFace(t2.getId());
        g.insertFace("t7", v1, v6, v5);
        g.insertFace("t8", v1, v5, v7);
        g.insertFace("t9", v3, v5, v6);
        g.insertFace("t10", v4, v5, v7);

        /* REFINE T3 */

        // vertices

        // edges
        g.insertEdge("e17", v7, v2, true);

        // faces
        g.removeFace(t3.getId());
        g.insertFace("t11", v1, v2, v7);
        g.insertFace("t12", v2, v4,  v7);

        /* REFINE T4 */

        // vertices

        // edges
        g.insertEdge("e18", v6, v2, true);

        // faces
        g.removeFace(t4.getId());
        g.insertFace("t13", v1, v2, v6);
        g.insertFace("t14", v2, v6, v3);

        /* INTERNAL INSERTIONS */

        // interior nodes
        g.insertInterior("i1", v1, v2, v5, v6);
        g.insertInterior("i2", v1, v2, v5, v7);
        g.insertInterior("i3", v2, v3, v5, v6);
        g.insertInterior("i4", v2 ,v4, v5, v7);

        // faces
        g.insertFace("t15", v2, v5, v7);
        g.insertFace("t16", v2, v6, v5);
        g.insertFace("t17", v2, v5, v1);

        return g;
    }

}
