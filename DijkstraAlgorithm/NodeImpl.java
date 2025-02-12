package DijkstraAlgorithm;


import java.util.ArrayList;

public class NodeImpl implements Node {
    private String _name;
    private ArrayList<EdgeImpl> _outEdges;

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
    }

    @Override
    public String getName() {
        return _name;
    }

    public ArrayList<EdgeImpl> getOutEdges() {
        // TODO: Check if this implementation is correct
        if (_outEdges.isEmpty()) {
            System.out.println("There are no outgoing edges");
        } else {
            return _outEdges;
        }
        return null;
    }

    @Override
    public boolean edgeExists(Node dest) {
        // If there is an outgoing edge to dest, return true
        for (EdgeImpl e : _outEdges) {
            if (e.getDest() == dest.getName()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteEdge(Node dest) {
        if (edgeExists(dest)) {
            for (EdgeImpl e : _outEdges) {
                if (e.getDest() == dest.getName()) {
                    _outEdges.remove(e);
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;
    }
}



