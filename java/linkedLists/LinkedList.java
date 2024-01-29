public class LinkedList {

    public static RandomLLNode createRandomList () {
        RandomLLNode head = new RandomLLNode ( 1 );
        head.next = new RandomLLNode ( 2 );
        head.next.next = new RandomLLNode ( 3 );
        head.next.next.next = new RandomLLNode ( 4 );

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head;
        head.next.next.next.random = head.next;

        return head;
    }

    public static Node createEvenOddList ( ) {
        Node head = new Node ( 1, null );
        head.next = new Node ( 2, null );
        head.next.next = new Node ( 3, null );
        head.next.next.next = new Node ( 4, null );

        return head;
    }

    public static Node createList ( ) {
        Node head = new Node ( 1, null );
        head.next = new Node ( 3, null );
        head.next.next = new Node ( 5, null );
        head.next.next.next = new Node ( 7, null );

        return head;
    }

    public static Node createLongList ( ) {
        Node head = new Node ( 1, null );
        head.next = new Node ( 2, null );
        head.next.next = new Node ( 3, null );
        head.next.next.next = new Node ( 4, null );
        head.next.next.next.next = new Node ( 5, null );
        head.next.next.next.next.next = new Node ( 6, null );
        head.next.next.next.next.next.next  = new Node ( 7, null );
        head.next.next.next.next.next.next.next = new Node ( 8, null );
        head.next.next.next.next.next.next.next.next  = new Node ( 9, null );
        head.next.next.next.next.next.next.next.next.next  = new Node ( 10, null );

        return head;
    }

    public static Node forPalindrome () {
        Node head = new Node ( 1, null );
        head.next = new Node ( 2, null );
        head.next.next = new Node ( 2, null );
        head.next.next.next = new Node ( 1, null );

        return head;
    }

    public static Node forPalindrome2 () {
        Node head = new Node ( 1, null );
        head.next = new Node ( 2, null );
        head.next.next = new Node ( 3, null );
        head.next.next.next = new Node ( 2, null );
        head.next.next.next.next = new Node ( 1, null );

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

    public static Node bigNumber2 () {
        Node head = new Node ( 9, null );
        head.next = new Node ( 9, null );

        return head;
    }

    public static Node bigNumber () {
        Node head = new Node ( 9, null );
        head.next = new Node ( 9, null );
        head.next.next = new Node ( 8, null );
        head.next.next.next = new Node ( 7, null );

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

    public static void printRandomList ( RandomLLNode head ) {
        RandomLLNode ptr = head;

        while ( ptr != null ) {
            System.out.print ( "data: " + ptr.data + " " );
            System.out.print ( "random data: " + ptr.random.data + " -> " );
            ptr = ptr.next;
        }
        System.out.println ();
    }

}
