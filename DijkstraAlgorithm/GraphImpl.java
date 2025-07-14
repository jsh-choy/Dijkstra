package DijkstraAlgorithm;

import java.util.*;

public class GraphImpl implements Graph {
    Map<String, Node> _nodes; //Do not delete.  Use this field to store your nodes.
    // key: name of node. value: a5.Node object associated with name
    HashMap<String, Double> _graph = new HashMap<>();
//    Comparator<ShortestPathQueueObject> _compare = Comparator.comparingDouble(a -> a.distance);
//    PriorityQueue<ShortestPathQueueObject> _queue = new PriorityQueue<>(_compare);

    public GraphImpl() {
        _nodes = new HashMap<>();
    }

    @Override
    public boolean addNode(String name) {
        if (_nodes.containsKey(name)) {
            return false;
        } else {
            Node nd = new NodeImpl(name);
            nd.setDist(-1.0);
            _nodes.put(name, nd);
            return true;
        }
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (_nodes.get(src).edgeExists(dest)) {
            System.out.println("Edge already exists between: " + " src: " + src + " | dest: " + dest);
            return false;
        }

        _nodes.get(src).addEdge(src, dest, weight);
        return true;
    }

    @Override
    public boolean deleteNode(String name) {
        if (_nodes.containsKey(name)) {
            if (_nodes.get(name).getOutEdges().isEmpty()) {
                _nodes.remove(name);
                return true;
            }

            _nodes.get(name).getOutEdges().clear();
            _nodes.remove(name);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if (_nodes.containsKey(src)) {
            return _nodes.get(src).deleteNodeEdge(dest);
        }

        return false;
    }

    @Override
    public int numNodes() {
        return _nodes.size();
    }

    @Override
    public int numEdges() {
        int countEdges = 0;
        for (String nd : _nodes.keySet()) {
            ArrayList<EdgeImpl> edges = _nodes.get(nd).getOutEdges();
            countEdges += edges.size();
        }
        return countEdges;
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
            if (Objects.equals(nd.getName(), start)) {
                nd.setDist(0.0);
                _graph.put(start, 0.0);
                continue;
            }
            nd.setDist(-1.0);
            _graph.put(nd.getName(), -1.0);
        }
    }

    private void setDistanceToNodes() {
        Node curr;
    }

    private void printStuff() {
        System.out.println();
        System.out.println("graph entry: " + _graph.entrySet());
        System.out.println();
        System.out.println(" Edges in graph: ");
        for (String nd : _nodes.keySet()) {
            ArrayList<EdgeImpl> edd = new ArrayList<>();
            edd = _nodes.get(nd).getOutEdges();

            for (int i = 0; i < edd.size(); i++) {
                System.out.println("src: " + edd.get(i).getSrc() + " | dest: " + edd.get(i).getDest() + " | weight: "
                + edd.get(i).getWeight());
            }
        }
    }
}