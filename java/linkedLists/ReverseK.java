public class ReverseK {

    public static void print ( ) {
        Node head1 = LinkedList.createLongList ();
        LinkedList.printList ( reverseK ( head1, 2 ) );

        Node head2 = LinkedList.createLongList ();
        LinkedList.printList ( reverseK ( head2, 3 ) );

        Node head3 = LinkedList.createLongList ();
        LinkedList.printList ( reverseK ( head3, 4 ) );

        Node head4 = LinkedList.createLongList ();
        LinkedList.printList ( reverseK ( head4, 5 ) );

        Node head5 = LinkedList.createLongList ();
        LinkedList.printList ( reverseK ( head5, 6 ) );
    }

    private static Node reverseK ( Node head, int k ) {
        if ( length ( head ) < k ) {
            return head;
        }

        Node current = head;
        Node previous = null;
        Node next = null;

        int n = 0;

        while ( current != null && n < k ) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            ++n;
        }

        head.next = reverseK ( next, k );

        return previous;
    }

    private static int length ( Node head ) {
        if ( head == null ) {
            return 0;
        }
        return 1 + length ( head.next );
    }
}
