public class Node {
    int data;
    Node next;

    public Node ( int data, Node next ) {
        this.data = data;
        this.next = next;
    }

    public Node ( int data ) {
        this.data = data;
        this.next = null;
    }

    public Node () {
        this.data = 0;
        this.next = null;
    }

}
