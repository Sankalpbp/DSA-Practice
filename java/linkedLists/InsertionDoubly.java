public class InsertionDoubly {

    public static void print ( ) {
        System.out.println ( "Initial Doubly Linked List: " );
        DoublyNode head = DoublyList.createList ();
        DoublyList.printList ( head );

        head = insertAtFirst ( 99 );
        System.out.println ( "Doubly Linked List after adding at the first: " );
        DoublyList.printList ( head );
        
        head = insertAtLast ( 88 );
        System.out.println ( "Doubly Linked List after adding at the last: " );
        DoublyList.printList ( head );

        head = insertAtLocation ( 77, 3 );
        System.out.println ( "Doubly Linked List after adding at the third location: " );
        DoublyList.printList ( head );
    }

    private static DoublyNode insertAtLocation ( int data, int x ) {

    }

    private static DoublyNode insertAtFirst ( int data ) {
    }

    private static DoublyNode insertAtLast ( int data ) {

    }
}
