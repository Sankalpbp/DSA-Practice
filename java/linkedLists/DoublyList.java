public class DoublyList {

    public static DoublyNode createList () {
        DoublyNode head = new DoublyNode ( 1 );
        head.previous = null;

        head.next = new DoublyNode ( 2 );
        head.next.previous = head;

        head.next.next = new DoublyNode ( 3 );
        head.next.next.previous = head.next;

        head.next.next.next = new DoublyNode ( 4 );
        head.next.next.next.previous = head.next.next;

        return head;
    }

    public static void printList ( DoublyNode head ) {
        DoublyNode ptr = head;

        while ( ptr != null ) {
            System.out.print ( ptr.data + " " );
            ptr = ptr.next;
        }

        System.out.println ( "\n" );
    }

}
