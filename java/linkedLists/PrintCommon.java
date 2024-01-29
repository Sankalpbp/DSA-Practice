public class PrintCommon {

    public static void print () {
        Node head1 = LinkedList.createList ();
        LinkedList.printList ( head1 );

        Node head2 = LinkedList.createEvenOddList ();
        LinkedList.printList ( head2 );

        printCommon ( head1, head2 );
    }

    private static void printCommon ( Node head1, Node head2 ) {
        if ( head1 == null || head2 == null ) {
            return;
        }

        if ( head1.data == head2.data ) {
            System.out.print ( head1.data + " " );
            head1 = head1.next;
            head2 = head2.next;
        } else if ( head1.data > head2.data ) {
            head2 = head2.next;
        } else {
            head1 = head1.next;
        }

        printCommon ( head1, head2 );
    }

}
