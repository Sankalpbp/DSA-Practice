public class CyclicList {

    public static CLLNode createList ( ) {
        CLLNode head = new CLLNode ( 1 );
        head.next = new CLLNode ( 2 );
        head.next.next = new CLLNode ( 3 );
        head.next.next.next = new CLLNode ( 4 );
        head.next.next.next.next = head;

        return head;
    }

    public static CLLNode createList2 ( ) {
        CLLNode head = new CLLNode ( 1 );
        head.next = new CLLNode ( 2 );
        head.next.next = new CLLNode ( 3 );
        head.next.next.next = head;

        return head;
    }

    public static CLLNode createList3 ( ) {
        CLLNode head = new CLLNode ( 1 );
        head.next = new CLLNode ( 2 );
        head.next.next = new CLLNode ( 3 );
        head.next.next.next = new CLLNode ( 4 );
        head.next.next.next.next = new CLLNode ( 5 );
        head.next.next.next.next.next = head;

        return head;
    }

    public static CLLNode createList4 ( ) {
        CLLNode head = new CLLNode ( 1 );
        head.next = new CLLNode ( 2 );
        head.next.next = head;

        return head;
    }

    public static CLLNode createList5 ( ) {
        CLLNode head = new CLLNode ( 1 );
        head.next = head;

        return head;
    }

    public static void printList ( CLLNode head ) {
        CLLNode ptr = head;

        System.out.println ( );
        System.out.print ( ptr.data + " " );
        ptr = ptr.next;

        while ( ptr != head ) {
            System.out.print ( ptr.data + " " );
            ptr = ptr.next;
        }
        System.out.println ( );
    }
}
