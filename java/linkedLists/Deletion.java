public class Deletion {

    public static void print ( ) {
        Node head = LinkedList.createList ();

        System.out.println ( "Created List: " );
        LinkedList.printList ( head );

        System.out.println ( "After deleting the first node: " );
        head = deleteFirst ( head );
        LinkedList.printList ( head );

        System.out.println ( "After deleting the last node: " );
        head = deleteLast ( head );
        LinkedList.printList ( head );

        head = LinkedList.createList ();

        System.out.println ( "Created List: " );
        LinkedList.printList ( head );

        System.out.println ( "After deleting the node with data 3: " );
        head = deleteX ( head, 3 );
        LinkedList.printList ( head );

        System.out.println ( "After deleting the node after the node with data 2: " );
        head = deleteAfterX ( head, 2 );
        LinkedList.printList ( head );
    }

    private static Node deleteAfterX ( Node head, int x ) {
        Node ptr = head;

        while ( ptr != null && ptr.data != x ) {
            ptr = ptr.next;
        }

        if ( ptr == null || ptr.next == null ) {
            return head;
        }

        ptr.next = ptr.next.next;

        return head;
    }

    private static Node deleteX ( Node head, int x ) {
        Node ptr = head;
        Node preptr = null;

        while ( ptr != null && ptr.data != x ) {
            preptr = ptr;
            ptr = ptr.next;
        }

        if ( ptr == null ) {
            return head;
        }

        if ( preptr == null ) {
            // first node
            return head.next;
        }

        preptr.next = ptr.next;
        return head;
    }

    private static Node deleteFirst ( Node head ) {
        if ( head == null ) {
            return head;
        }
        return head.next;
    }

    private static Node deleteLast ( Node head ) {
        if ( head == null || head.next == null ) {
            return null;
        }

        Node ptr = head;

        while ( ptr.next.next != null ) {
            ptr = ptr.next;
        }

        ptr.next = null;

        return head;
    }
}
