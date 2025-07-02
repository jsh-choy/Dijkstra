package DijkstraAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphImpl implements Graph {
    Map<String, Node> _nodes; //Do not delete.  Use this field to store your nodes.
    // key: name of node. value: a5.Node object associated with name
    LinkedList<EdgeImpl> _edges;
    HashMap<String, Double> _graph = new HashMap<>();

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
        System.out.println("******** Starting Dijkstra ********");
        setInitDistance(start);
        setDistanceToNodes();
        printStuff();
        System.out.println("******** Ended Dijkstra ********");
        return _graph;
    }

    private void setInitDistance(String start) {
        for (Node nd: _nodes.values()) {
            if (nd.getName() == start) {
                nd.setDist(0);
                _graph.put(start, 0.0);
                continue;
            }
            nd.setDist(-1);
        }
    }

    private void setDistanceToNodes() {
        Node currNode;
        Node nextNode;

        while (!_edges.isEmpty()) {
            currNode = _nodes.get(_edges.peek().getSrc());
            nextNode = _nodes.get(_edges.peek().getDest());
            if (nextNode.getDist() == -1) {
                nextNode.setDist(_edges.peek().getWeight());
                System.out.println(_edges.peek().getSrc() +
                        " -> " + _edges.peek().getDest() + " | dist: " + _edges.peek().getWeight());
                continue;
            }
            if (nextNode.getDist() > _edges.peek().getWeight()) {
                double sum =  currNode.getDist() + _edges.peek().getWeight();
                nextNode.setDist(sum);
                _graph.put(currNode.getName(), currNode.getDist());
                System.out.println(_edges.peek().getSrc() +
                        " -> " + _edges.peek().getDest() + " | dist: " + _edges.peek().getWeight());
                _edges.pop();
                continue;
            }
            double sum =  currNode.getDist() + _edges.peek().getWeight();
            nextNode.setDist(sum);
            _graph.put(nextNode.getName(), nextNode.getDist());
            _edges.pop();
        }
    }

    private void printStuff() {
        System.out.println();
        System.out.println("graph entry: " + _graph.entrySet());
    }
}