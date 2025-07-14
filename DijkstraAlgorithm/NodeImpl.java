package DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Objects;

public class NodeImpl implements Node {
    private String _name;
    private double _distance;
    private ArrayList<EdgeImpl> _edges;

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */

    public NodeImpl(String name) {
        this._name = name;
        this._edges = new ArrayList<>();
    }

    public boolean edgeExists(String dest) {
        // TODO: edge exists
        for (EdgeImpl ed : _edges) {
            if (Objects.equals(ed.getDest(), dest)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<EdgeImpl> getOutEdges() {
        return _edges;
    }

    public boolean addEdge(String a, String b, double weight) {
        if (edgeExists(b)) {
            return false;
        }

        EdgeImpl ed = new EdgeImpl(a, b, weight);
        _edges.add(ed);
        return true;
    }

    public boolean deleteNodeEdge(String dest) {
        if (edgeExists(dest)) {
            for (EdgeImpl ed : _edges) {
                if (ed.getDest() == dest) {
                    _edges.remove(ed);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setDist(double x) {
        _distance = x;
    }

    @Override
    public double getDist() {
        return _distance;
    }
}