public class ReverseRecursive {

    public static void print ( ) {
        Node list = LinkedList.createList ( );
        LinkedList.printList ( list );
        list = reverse ( list );
        LinkedList.printList ( list );
    }

    private static Node reverse ( Node head ) {
        if ( head == null || head.next == null ) {
            return head;
        }

        Node newHead = reverse ( head.next );

        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}
