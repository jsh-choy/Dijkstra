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
//            _nodes.get(src).addEdge(src, dest, weight);
            _edges.add(e);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteNode(String name) {
        if (_nodes.containsKey(name)) {
            _edges.removeIf(e -> e.getDest() == name);
            _nodes.remove(name);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        for (EdgeImpl e : _edges) {
            if (e.getSrc() == src && e.getDest() == dest) {
                _edges.remove(e);
                return true;
            }
        }
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
        //      1. Starting node
        //      2. Set the nodes connected to starting node to the edge weight
        //      3. Do this until all the out-edges are done
        for (Node nd : _nodes.values()) {
            // Check to see if there are outgoing edges
            for (EdgeImpl ed : _edges) {
                // For each edge connected to source
                // If distance of dest node is <, not -1, distance of dest stays
                // otherwise set the distance of dest node as the edge weight
                if (nd.getDist() == 0) {
                    // This is the starting node, continue
                    continue;
                }

                if (nd.getDist() == -1) {
                    nd.setDist(ed.getWeight());
                    deleteEdge(ed.getSrc(), ed.getDest());
                    continue;
                }

                if (nd.getDist() < ed.getWeight()) {
                    deleteEdge(ed.getSrc(), ed.getDest());
                    continue;
                }

                if (nd.getDist() > ed.getWeight()) {
                    deleteEdge(ed.getSrc(), ed.getDest());
                    nd.setDist(ed.getWeight());
                }
            }
        }

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
