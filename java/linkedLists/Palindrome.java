public class Palindrome {

    public static void print () {
        Node head = LinkedList.forPalindrome ( );
        LinkedList.printList ( head );

        if ( isPalindrome ( head ) ) {
            System.out.println ( "yes, the provided list is a palindrome." );
        } else {
            System.out.println ( "no, the provided list is not a palindrome." );
        }
    }

    private static boolean isPalindrome ( Node head ) {
        Node slowPtr = head;
        Node fastPtr = head;

        while ( slowPtr != null && fastPtr != null && fastPtr.next != null ) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        Node rightHalf = null;

        if ( fastPtr == null ) {
            rightHalf = slowPtr;
        } else if ( fastPtr.next == null ) {
            rightHalf = slowPtr.next;
        }


        Node reverseRightHalf = reverse ( rightHalf );
        Node ptr1 = reverseRightHalf;
        Node ptr2 = head;

        boolean palidrome = false;

        while ( ptr != null ) {
            if ( ptr1.data != ptr2.data ) {
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        r

        return true;
    }

}
