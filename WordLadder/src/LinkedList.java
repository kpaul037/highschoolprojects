/*Kevin Paul, 4B, 10/19/19*/

public class LinkedList {
    private Node head;
    private int count;

    LinkedList() {
        head = null;
        count = 0;
    }

    //Adds an Object to the beginning of the list
    void addToFront(Object data) {
        Node newHead = new Node(data);
        Node prevHead = head;
        newHead.setNextNode(prevHead);
        head = newHead;
        count++;
    }

    //Adds an Object to the end of the list
    void addToBack(Object data) {
        Node newNode = new Node(data);
        if (count > 0) {
            Node current = head;
            for (int i = 0; i < count; i++) {
                if (current.getNextNode() == null)
                    current.setNextNode(newNode);
                current = (Node) current.getNextNode();
            }
            count++;
        } else {
            head = newNode;
            count = 1;
        }
    }

    Object get(int index) {
        Node current = head;
        int cIndex = 0;
        while (current != null) {
            if (cIndex == index)
                return current.get();
            current = (Node) current.getNextNode();
            cIndex++;
        }
        return null;
    }

    //removes from the front of the LinkedList
    Object removeFromFront() {
        Node removedHead = head;
        head = (Node) removedHead.getNextNode();
        Object removedData = removedHead.get();
        count--;
        return removedData;
    }

    int size() {
        return count;
    }
}