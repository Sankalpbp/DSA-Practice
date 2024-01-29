public class SplitEvenOdd {

    public static void print () {
        Node head = LinkedList.createEvenOddList ();
        LinkedList.printList ( head );
        head = split ( head );
        LinkedList.printList ( head );

        Node head2 = LinkedList.createList ();
        LinkedList.printList ( head2 );
        head2 = split ( head2 );
        LinkedList.printList ( head2 );

        Node head3 = LinkedList.createListNew ();
        LinkedList.printList ( head3 );
        head3 = split ( head3 );
        LinkedList.printList ( head3 );
    }

    private static Node split ( Node head ) {
        if ( head == null || head.next == null ) {
            return head;
        }

        Node ptr = head;

        Node evenHead = null;
        Node oddHead = null;

        Node lastEven = null;
        Node lastOdd = null;

        while ( ptr != null ) {
            if ( ptr.data % 2 == 0 ) {
                evenHead = ( evenHead == null ) ? ptr : evenHead;
                if ( lastEven != null ) {
                    lastEven.next = ptr;
                }
                lastEven = ptr;
            } else {
                oddHead = ( oddHead == null ) ? ptr : oddHead;
                if ( lastOdd != null ) {
                    lastOdd.next = ptr;
                }
                lastOdd = ptr;
            }
            ptr = ptr.next;
        }

        if ( lastEven != null ) {
            lastEven.next = oddHead;
        }
        if ( lastOdd != null ) {
            lastOdd.next = null;
        }

        return ( evenHead == null ) ? oddHead : evenHead;
    }
}
