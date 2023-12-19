public class DoublyNode {
    int data;
    DoublyNode previous;
    DoublyNode next;

    public DoublyNode ( int data ) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public DoublyNode ( ) {
        this.data = 0;
        this.next = null;
        this.previous = null;
    }
}
