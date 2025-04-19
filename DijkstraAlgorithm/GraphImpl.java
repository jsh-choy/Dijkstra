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
        return _nodes.size();
    }

    @Override
    public int numEdges() {
        return _edges.size();
    }

    @Override
    public Map<String, Double> dijkstra(String start) {
        // TODO: Implement Dijkstra's Algorithm here after checking if the other features work correctly
        System.out.println();
        System.out.println("******** Reached Dijkstra ********");
        System.out.println("- This function isn't functioning correctly right now");

        HashMap<String, Double> _graph = new HashMap<>();
        // Set the initial distance to the nodes to 0
        //  Then set the rest of the nodes in the graph to -1
        setInitDistance(start);

        // TODO: Figure out how to visit each node whose distance is -1
        //  At this point we are pointing at the starting node



        System.out.println("******** Ended Dijkstra ********");
        return _graph;
    }

    private void setInitDistance(String start) {
        for (Node nd: _nodes.values()) {
            if (nd.getName() == start) {
                nd.setDist(0);
                continue;
            }
            nd.setDist(-1);
        }

    }
}
