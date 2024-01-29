public class Rearrange {

    public static void print () {
        Node head = LinkedList.createList ();
        LinkedList.printList ( head );
        LinkedList.printList ( rearrange ( head ) );

        System.out.println ();

        Node head2 = LinkedList.createLongList ();
        LinkedList.printList ( head2 );
        LinkedList.printList ( rearrange ( head2 ) );

        System.out.println ();

        Node head3 = LinkedList.createListNew ();
        LinkedList.printList ( head3 );
        LinkedList.printList ( rearrange ( head3 ) );
    }

    private static Node rearrange ( Node head ) {
        if ( head == null || head.next == null ) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while ( slow != null && fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node headOfReversedSecondHalf = ReverseRecursive.reverse ( slow.next );
        slow.next = null;

        return MergeTwoLists.merge ( head, headOfReversedSecondHalf, true );
    }
    
}
