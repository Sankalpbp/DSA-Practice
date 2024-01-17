public class LinkedList {

    public static Node createList ( ) {
        Node head = new Node ( 1, null );
        head.next = new Node ( 3, null );
        head.next.next = new Node ( 5, null );
        head.next.next.next = new Node ( 7, null );

        return head;
    }

    public static Node forPalindrome () {
        Node head = new Node ( 1, null );
        head.next = new Node ( 2, null );
        head.next.next = new Node ( 2, null );
        head.next.next.next = new Node ( 1, null );

        return head;
    }

    public static Node forSorting () {
        Node head = new Node ( 2, null );
        head.next = new Node ( 0, null );
        head.next.next = new Node ( 4, null );
        head.next.next.next = new Node ( 3, null );

        return head;
    }

    public static Node createListNew () {
        Node head = new Node ( 2, null );
        head.next = new Node ( 4, null );
        head.next.next = new Node ( 8, null );

        return head;
    }

    public static void printList ( Node head ) {
        Node ptr = head;

        while ( ptr != null ) {
            System.out.print ( ptr.data + " " );
            ptr = ptr.next;
        }
        System.out.println ();
    }

}
