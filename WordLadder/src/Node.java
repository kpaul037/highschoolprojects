/*Kevin Paul, 4B, 10/20/19*/

public class Node {
    private Object data;
    private Node nextNode;

    Node() {
        data = null;
        nextNode = null;
    }

    Node(Object data) {
        this.data = data;
        nextNode = null;
    }

    Object get() { return data; }

    public void set(Object data) { this.data = data; }

    Object getNextNode() { return nextNode; }

    public void setNextNode(Node nextNode) { this.nextNode = nextNode; }

    @Override
    public String toString() {
        return "Data: " + data;
    }
}