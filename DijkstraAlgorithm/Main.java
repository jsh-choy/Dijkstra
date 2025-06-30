package DijkstraAlgorithm;

public class Main {


    public static void main(String[] args) {

        //You are encouraged (but not required) to include your testing code here.
        //Hint: Try to test basic operations (e.g., adding a few nodes and edges to graphs)
        //before you implement more complex methods
        System.out.println();
        System.out.println("******* Creating the graph *******");
        System.out.println();

        GraphImpl _graph = new GraphImpl();

        _graph.addNode("a");
        _graph.addNode("b");
        _graph.addNode("c");
        _graph.addNode("d");

        // Create Edges (a,b), (a,c), (b,c), (c,d)
        _graph.addEdge("a", "b", 1.0);
        _graph.addEdge("a", "c", 9.0);
        _graph.addEdge("b", "c", 2.0);
        _graph.addEdge("c", "d", 5.0);

//        System.out.println("Nodes added: " + _graph.numNodes());
//        System.out.println("Edges added: " + _graph.numEdges());

        // TODO: Print out the added nodes
//        System.out.println();
//        System.out.println("******* Ended *******");
//
//        System.out.println();
//        System.out.println("--- Testing output ---");
//        System.out.println(_graph._nodes.keySet());

        // Start Dijkstra

        // Print out the nodes and the distance
//        System.out.println();
//        System.out.println("------- Nodes in the graph -------");
//        for (Node nd : _graph._nodes.values()) {
//            System.out.println("node: " + nd.getName() + ", distance: " + nd.getDist());
//        }
//        System.out.println();
//        System.out.println("------- Edges in the Graph --------");
//        for (Edge edge : _graph._edges) {
//            System.out.println("src: " + edge.getSrc() + " | dest: " + edge.getDest() + " | weight: " + edge.getWeight());
//        }
        _graph.dijkstra("a");
    }
}