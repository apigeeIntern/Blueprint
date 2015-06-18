//package main.java;

/**
 * Created by nishitarao on 6/16/15.
 */


import com.tinkerpop.blueprints.*;

public class Neo4J_Blueprint {

    public static void main( String[] args){

    Graph g = GraphFactory.open("graph.properties");
    String vis_var;
    Vertex personA = g.addVertex(null);
    Vertex personB = g.addVertex(null);
    Vertex personC = g.addVertex(null);
    Vertex personD = g.addVertex(null);

    Vertex restaurantA = g.addVertex(null);
    Vertex restaurantB = g.addVertex(null);
    Vertex restaurantC = g.addVertex(null);

    Edge edge1 = g.addEdge(null,personA,restaurantA,"rel");
    Edge edge2 = g.addEdge(null,personB,personA,"rel");
    Edge edge3 = g.addEdge(null,personA,personC,"rel");
    Edge edge4 = g.addEdge(null,personA,restaurantB,"rel");
    Edge edge5 = g.addEdge(null,personD,restaurantA,"rel");

    personA.setProperty("name","Anne");
    personB.setProperty("name","Bennie");
    personC.setProperty("name","Carrie");
    personD.setProperty("name","Danny");
    restaurantA.setProperty("name","Amici");
    restaurantB.setProperty("name","BerryDelight");
    restaurantC.setProperty("name","Casablanca");

    edge1.setProperty("rel","Visits");
    edge2.setProperty("rel","Follows");
    edge3.setProperty("rel","FollowedBy");
    edge4.setProperty("rel","Visits");
    edge5.setProperty("rel","Visits");

    System.out.println("Visits in graph " + g);
    for (Vertex vertex : g.getVertices()) {
        for (Edge edge : vertex.getEdges(Direction.OUT,"rel")) {
            System.out.println(vertex.getProperty("name"));
            System.out.println(edge.getProperty("rel"));
            if (edge.getProperty("rel").equals("Visits")) {
                System.out.print(vertex.getProperty("name")+" visits ");
                System.out.println(edge.getVertex(Direction.IN).getProperty("name"));

            }
            if (edge.getProperty("rel").equals("Follows")) {
                System.out.print(vertex.getProperty("name")+" follows ");
                System.out.println(edge.getVertex(Direction.IN).getProperty("name"));
        }
    }

    }
    }


