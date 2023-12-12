public class Insertion {

    public static void print ( ) {
        Node head = LinkedList.createList ();

        System.out.println ( "Before any addition: " );
        LinkedList.printList ( head );

        System.out.println ( "Adding on the front: " );
        head = insertOnFront ( head, 99 );
        LinkedList.printList ( head );

        System.out.println ( "Adding at the end: " );
        head = insertAtEnd ( head, 88 );
        LinkedList.printList ( head );

        System.out.println ( "Adding after 3: " );
        head = insertAfterT ( head, 3, 77 );
        LinkedList.printList ( head );

    }

    private static Node insertAfterT ( Node head, int t, int x ) {
        Node newNode = new Node ( x, null );
        Node ptr = head;

        while ( ptr != null && ptr.data != t ) {
            ptr = ptr.next;
        }

        if ( ptr == null ) {
            return head;
        }

        newNode.next = ptr.next;
        ptr.next = newNode;

        return head;
    }

    private static Node insertAtEnd ( Node head, int x ) {
        Node newNode = new Node ( x, null );
        Node ptr = head;

        while ( ptr != null && ptr.next != null ) {
            ptr = ptr.next;
        }

        ptr.next = newNode;
        return head;
    }

    private static Node insertOnFront ( Node head, int x ) {
        Node newNode = new Node ( x, null );
        newNode.next = head;
        return newNode;
    }
}
