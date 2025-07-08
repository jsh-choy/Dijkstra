package DijkstraAlgorithm;

public class Main {


    public static void main(String[] args) {
        //You are encouraged (but not required) to include your testing code here.
        //Hint: Try to test basic operations (e.g., adding a few nodes and edges to graphs)
        //before you implement more complex methods

        // Create the graph
        // Example: GraphImpl _graph = new GraphImpl();
        GraphImpl _graph = new GraphImpl();

        // Add Nodes: _graph.addNode("node name");
        _graph.addNode("a");
        _graph.addNode("b");
        _graph.addNode("c");
        _graph.addNode("d");

        _graph.deleteNode("a");
//        _graph.addEdge("a", "b", 2.0);

//        _graph.deleteNode("a");
        // Add Edges: _graph.addEdge("source", "destination", 0.0)


        // Start dijkstra: _graph.dijkstra("start)
//        _graph.dijkstra("0");
    }
}