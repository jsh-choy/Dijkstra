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
        _graph.addEdge("a", "c", 3.0);
        _graph.addEdge("b", "c", 2.0);
        _graph.addEdge("c", "d", 5.0);

        System.out.println("Nodes added: " + _graph.numNodes());
        System.out.println("Edges added: " + _graph.numEdges());

        // Delete an Edge
        _graph.deleteEdge("a", "b");
        _graph.deleteEdge("a", "d");

        // Delete a Node
        _graph.deleteNode("a");

        System.out.println("Edges added: " + _graph.numEdges());
        System.out.println();
        System.out.println("******* Ended *******");
        System.out.println();
        System.out.println("All the nodes in the graph");

        System.out.println(_graph._nodes.entrySet());
    }

}