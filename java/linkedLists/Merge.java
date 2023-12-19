public class Merge {

    public static void print () {
        Node head1 = LinkedList.createList ();
        LinkedList.printList ( head1 );
        Node head2 = LinkedList.createListNew ();
        LinkedList.printList ( head2 );

//        LinkedList.printList ( mergeIterative ( head1, head2 ) );
        LinkedList.printList ( mergeRecursive ( head1, head2 ) );
    }

    private static Node mergeRecursive ( Node head1, Node head2 ) {
        if ( head1 == null && head2 == null ) {
            return null;
        }

        if ( head1 == null ) {
            return head2;
        }

        if ( head2 == null ) {
            return head1;
        }

        if ( head1.data > head2.data ) {
            head2.next = mergeRecursive ( head1, head2.next );
            return head2;
        }

        head1.next = mergeRecursive ( head1.next, head2 );
        return head1;
    }

    private static Node mergeIterative ( Node head1, Node head2 ) {
        Node dummy = new Node ( Integer.MIN_VALUE );
        Node ptr1 = head1;
        Node ptr2 = head2;
        Node ptr = dummy;

        while ( ptr1 != null && ptr2 != null ) {
            if ( ptr1.data > ptr2.data ) {
                ptr.next = ptr2;
                ptr2 = ptr2.next;
            } else {
                ptr.next = ptr1;
                ptr1 = ptr1.next;
            }

            ptr = ptr.next;
        }

        System.out.println ( "used iterative" );

        if ( ptr1 != null ) {
            ptr.next = ptr1;
        }

        if ( ptr2 != null ) {
            ptr.next = ptr2;
        }

        return dummy.next;
    }
}
