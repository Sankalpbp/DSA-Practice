public class MergeTwoLists {

    public static void print ( ) {
        Node head1 = LinkedList.createList ();
        LinkedList.printList ( head1 );
        Node head2 = LinkedList.createListNew ();
        LinkedList.printList ( head2 );

        Node merged = merge ( head1, head2, true );
        System.out.println ( "\n\n\n" );
        LinkedList.printList ( merged );
        System.out.println ( "\n\n\n" );

        Node head3 = LinkedList.createListNew ();
        LinkedList.printList ( head3 );
        Node head4 = LinkedList.createList ();
        LinkedList.printList ( head4 );

        Node merged2 = merge ( head3, head4, true );
        System.out.println ( "\n\n\n" );
        LinkedList.printList ( merged2 );
        System.out.println ( "\n\n\n" );
    }

    public static Node merge ( Node head1, Node head2, boolean isFirst ) {
        if ( head1 == null && head2 == null ) {
            return null;
        }
        
        if ( head1 == null ) {
            return head2;
        }

        if ( head2 == null ) {
            return head1;
        }

        if ( isFirst ) {
            head1.next = merge ( head1.next, head2, false );
            return head1;
        } 
        head2.next = merge ( head1, head2.next, true );
        return head2;
    }
}
