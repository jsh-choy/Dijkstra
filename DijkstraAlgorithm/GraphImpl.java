package DijkstraAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphImpl implements Graph {
    Map<String, Node> _nodes; //Do not delete.  Use this field to store your nodes.
    // key: name of node. value: a5.Node object associated with name
    LinkedList<EdgeImpl> _edges;

    public GraphImpl() {
        _nodes = new HashMap<>();
        _edges = new LinkedList<>();
    }

    @Override
    public boolean addNode(String name) {
        if (_nodes.containsKey(name)) {
            return false;
        } else {
            Node nd = new NodeImpl(name);
            _nodes.put(name, nd);
            return true;
        }
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        // Check if the graph contains the nodes
        if (_nodes.containsKey(src) && _nodes.containsKey(dest)) {
            EdgeImpl e = new EdgeImpl(src, dest, weight);
            _edges.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteNode(String name) {
        // Hint: Do you need to remove edges when you delete a node?
        System.out.println();
        System.out.println("---- Deleting a node ---- ");
        if (_nodes.containsKey(name)) {
            System.out.println("Deleting an edge when deleting a node...");
            _edges.removeIf(e -> e.getDest() == name);
            _nodes.remove(name);
            return true;
        } else {
            System.out.println("The node doesn't exist");
            return false;
        }
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        for (EdgeImpl e : _edges) {
            if (e.getSrc() == src && e.getDest() == dest) {
                System.out.println();
                System.out.println("---- Deleting edges ----");
                System.out.println("Successfully deleted edge: " + e.getSrc() + e.getDest());
                _edges.remove(e);
                return true;
            }
        }
        System.out.println("Unsuccessfully deleted edge");
        return false;
    }

    @Override
    public int numNodes() {
        // return _nodes.size(); returns the size of the nodes in graph
        return _nodes.size();
    }

    @Override
    public int numEdges() {
        return _edges.size();
    }

    @Override
    public Map<String, Double> dijkstra(String start) {

        return null;  //Dummy return value.  Remove when you implement!
    }
}
