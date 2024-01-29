public class IsPalindrome {

    public static void print ( ) {
        Node head1 = LinkedList.forPalindrome ( );
        LinkedList.printList ( head1 );
        System.out.println ( isPalindrome ( head1 ) );

        Node head2 = LinkedList.forPalindrome2 ( );
        LinkedList.printList ( head2 );
        System.out.println ( isPalindrome ( head2 ) );

        Node head3 = LinkedList.createList ( );
        LinkedList.printList ( head3 );
        System.out.println ( isPalindrome ( head3 ) );
    }

    public static boolean isPalindrome ( Node head ) {

        System.out.print ( "initial: " );
        LinkedList.printList ( head );

        Node preSlow = null;
        Node slow = head;
        Node fast = head;

        while ( slow != null && fast != null && fast.next != null ) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }


        if ( preSlow != null ) {
            preSlow.next = null;
        }

        Node secondHalf = ( fast == null ) ? slow : slow.next;
        secondHalf = ReverseRecursive.reverse ( secondHalf );

        Node ptrFirst = head;
        Node ptrSecond = secondHalf;

        while ( ptrFirst != null && ptrSecond != null ) {
            if ( ptrFirst.data != ptrSecond.data ) {
                reset ( preSlow, secondHalf, slow );

                System.out.print ( "final: " );
                LinkedList.printList ( head );
                return false;
            }
            ptrFirst = ptrFirst.next;
            ptrSecond = ptrSecond.next;
        }

        reset ( preSlow, secondHalf, slow );

        System.out.print ( "final: " );
        LinkedList.printList ( head );

        return true;
    }

    private static void reset ( Node lastOfLeft, Node firstOfReversedRight, Node originalHeadOfRight ) {
        ReverseRecursive.reverse ( firstOfReversedRight );
        lastOfLeft.next = originalHeadOfRight;
    }
}
