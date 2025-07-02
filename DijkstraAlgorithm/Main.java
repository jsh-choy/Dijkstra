package DijkstraAlgorithm;

public class Main {


    public static void main(String[] args) {

        //You are encouraged (but not required) to include your testing code here.
        //Hint: Try to test basic operations (e.g., adding a few nodes and edges to graphs)
        //before you implement more complex methods
        System.out.println();
        // Create the graph
        // Example: GraphImpl _graph = new GraphImpl();
        GraphImpl _graph = new GraphImpl();

        // Add Nodes: _graph.addNode("node name");
        _graph.addNode("0");
        _graph.addNode("1");
        _graph.addNode("2");
        _graph.addNode("3");
        _graph.addNode("4");
        _graph.addNode("5");
        _graph.addNode("6");

        // Add Edges: _graph.addEdge("source", "destination", 0.0)
        _graph.addEdge("0", "1", 2.0);
        _graph.addEdge("0", "2", 6.0);
        _graph.addEdge("1", "3", 5.0);
        _graph.addEdge("2", "3", 8.0);
        _graph.addEdge("3", "4", 10.0);
        _graph.addEdge("3", "5", 15.0);
        _graph.addEdge("4", "5", 6.0);
        _graph.addEdge("3", "4", 10.0);
        _graph.addEdge("5", "6", 6.0);
        _graph.addEdge("4", "6", 2.0);


        // Start dijkstra: _graph.dijkstra("start)
        _graph.dijkstra("0");
    }
}