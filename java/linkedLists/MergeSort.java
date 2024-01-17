public class MergeSort {

    public static void print ( ) {
        Node head = LinkedList.forSorting ();
        LinkedList.printList ( head );

        head = sort ( head );
        LinkedList.printList ( head );
    }

    private static Node sort ( Node head ) {
        if ( head == null || head.next == null ) {
            return head;
        }

        Node middle = getMiddle ( head );
        Node leftListHead = head;
        Node rightListHead = middle.next;

        middle.next = null;

        leftListHead = sort ( leftListHead );
        rightListHead = sort ( rightListHead );

        head = merge ( leftListHead, rightListHead );

        return head;
    }

    private static Node getMiddle ( Node head ) {
        Node slowPtr = head;
        Node fastPtr = head.next;

        while ( slowPtr != null && fastPtr != null && fastPtr.next != null ) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    private static Node merge ( Node list1, Node list2 ) {
        Node dummy = new Node ( 9999 );
        Node ptr = dummy;

        while ( list1 != null && list2 != null ) {
            if ( list1.data > list2.data ) {
                ptr.next = list2;
                list2 = list2.next;
            } else {
                ptr.next = list1;
                list1 = list1.next;
            }

            ptr = ptr.next;
        }

        if ( list1 != null ) {
            ptr.next = list1;
        }

        if ( list2 != null ) {
            ptr.next = list2;
        }

        return dummy.next;
    }

}
