import java.util.Map;
import java.util.HashMap;

public class RandomClone {

    public static void print () {
        RandomLLNode head = LinkedList.createRandomList ( );
        System.out.println ( "\n\nOriginal list: " );
        LinkedList.printRandomList ( head );

        RandomLLNode cloned = createCopyUsingSpace ( head );
        System.out.println ( "\n\nClonedlist: " );
        LinkedList.printRandomList ( cloned );

        RandomLLNode head2 = LinkedList.createRandomList ( );
        System.out.println ( "\n\nOriginal list: " );
        LinkedList.printRandomList ( head2 );

        RandomLLNode cloned2 = createCopyWOUsingSpace ( head2 );
        System.out.println ( "\n\nClonedlist: " );
        LinkedList.printRandomList ( cloned2 );

    }

    private static RandomLLNode createCopyWOUsingSpace ( RandomLLNode head ) {
        RandomLLNode newNode = null;
        RandomLLNode ptr = head;

        // set the next of the elements of the original list to the be new elements
        // and the next of the new elements the next of the original list
        while ( ptr != null ) {
            newNode = new RandomLLNode ( ptr.data );
            newNode.next = ptr.next;
            ptr.next = newNode;

            ptr = ptr.next.next;
        }

        // set the random of the new elements using the existing list
        ptr = head;
        while ( ptr != null ) {
            ptr.next.random = ptr.random.next;
            ptr = ptr.next.next;
        }

        // save the head of the new list
        RandomLLNode newHead = head.next;
        RandomLLNode ptrNext = null;

        // set the next of the new list and reset the next of the original list
        ptr = head;
        while ( ptr != null ) {
            ptrNext = ptr.next.next;
            if ( ptr.next.next != null ) {
                ptr.next.next = ptr.next.next.next;
            }

            ptr.next = ptrNext;
            ptr = ptr.next;
        }

        return newHead;
    }

    private static RandomLLNode createCopyUsingSpace ( RandomLLNode head ) {
        Map<RandomLLNode, RandomLLNode> copyForOriginal = new HashMap<> ();

        RandomLLNode ptr = head;

        while ( ptr != null ) {
            copyForOriginal.put ( ptr, new RandomLLNode ( ptr.data ) );
            ptr = ptr.next;
        }

        ptr = head;
        RandomLLNode cloneNode = null;

        while ( ptr != null ) {
            cloneNode = copyForOriginal.get ( ptr );
            cloneNode.next = copyForOriginal.get ( ptr.next );
            cloneNode.random = copyForOriginal.get ( ptr.random );

            ptr = ptr.next;
        }

        return copyForOriginal.get ( head );
    }
}
