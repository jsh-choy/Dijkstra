package DijkstraAlgorithm;

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
        return _name;  //Dummy return value.  Remove when you implement!
    }


    public ArrayList<EdgeImpl> getOutEdges() {
      if (_outEdges.size() == 0) {
        System.out.println("There are no outgoing edges");
      } else {
          return _outEdges;
      }
    }

    boolean edgeExists(Node a, Node b) {
      boolean flag = false;
      for (int i = 0; i < _outEdges.size(); i++) {
        if (_outEdges.get(i).getSrc() == a.getName() && _outEdges.get(i).getDest() == b.getName()) {
          // Check to see if there is an edge between the two nodes...
          //  if yes, return false;
          flag = false;
          return flag;
        } else {
          flag = true;
        }
      }
      return flag;
    }
    
    boolean delEdge(Node dest) {
      for (int i = 0; i < _outEdges.size(); i++) {
        if (_outEdges.get(i).getDest() == dest) {
          _outEdges.remove(i);
          return true;
        }
        return false;
      }
    }
}



