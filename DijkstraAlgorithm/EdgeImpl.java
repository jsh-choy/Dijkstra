package DijkstraAlgorithm;


public class EdgeImpl implements Edge {
    /* You will include the implementations for any edge methods you need in this file. */
    String _src;
    String _dest;
    double _weight;

    /*Hint: Make sure you update the Edge interface in Edge.java when you add a new method implementation
    in EdgeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any edge fields you want to add for the object should go in this file.  */
    public EdgeImpl(String src, String dest, double weight) {
        this._src = src;
        this._dest = dest;
        this._weight = weight;
    }

    @Override
    public String getSrc() {
        return this._src;
    }

    public String getDest() {
        return this._dest;
    }

    public double getWeight() {
        return this._weight;
    }
}
