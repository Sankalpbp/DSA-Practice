public class PairReverse {

    public static void print ( ) {

        Node head = LinkedList.createList ();
        Node head2 = LinkedList.createListNew ();

        /*

        head = reverseInPairs ( head );
        LinkedList.printList ( head );

        Node head2 = LinkedList.createListNew ();
        LinkedList.printList ( head2 );

        head2 = reverseInPairs ( head2 );
        LinkedList.printList ( head2 );
        
        */

        LinkedList.printList ( head );
        head = reverseIterative ( head );
        LinkedList.printList ( head );

        LinkedList.printList ( head2 );
        head2 = reverseIterative ( head2 );
        LinkedList.printList ( head2 );

    }

    private static Node reverseIterative ( Node head ) {
        Node current = head;
        Node next = null;
        Node previous = null;
        Node nextPairHead = null;

        while ( current != null && current.next != null ) {
            if ( next == null ) {
                head = current.next;
            }
            next = current.next;
            nextPairHead = next.next;

            next.next = current;
            if ( previous != null ) {
                previous.next = next;
            }
            previous = current;
            current = nextPairHead;
        }

        previous.next = current;

        return head;
    }

    private static Node reverseInPairs ( Node head ) {
        if ( head == null || head.next == null ) {
            return head;
        }

        /*
            For better understanding: 

            Node current = head;
            Node next = head.next;
            Node rest = head.next.next;

            current.next = null;
            next.next = current;

            rest = reverseInPairs ( rest );

            current.next = rest;
        */

        // For Elegance

        Node next = head.next;

        head.next = reverseInPairs ( head.next.next );
        next.next = head;

        return next;
    }

}
