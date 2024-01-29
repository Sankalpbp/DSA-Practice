import java.util.ArrayDeque;
import java.util.Deque;

public class AddLists {

    public static void print ( ) {
        Node head1 = LinkedList.bigNumber ( );
        System.out.println ( "\n\n\n" ) ;
        LinkedList.printList ( head1 );

        Node head2 = LinkedList.bigNumber ( );
        LinkedList.printList ( head2 );

        System.out.println ( "Using reverse: " );
        LinkedList.printList ( addUsingReverse ( head1, head2 ) );
        System.out.println ( "Using stack: " );
        LinkedList.printList ( addUsingStack ( head1, head2 ) );
        System.out.println ( "Using recursion: " );
        LinkedList.printList ( addUsingRecursion ( head1, head2 ) );

        head1 = LinkedList.bigNumber ( );
        System.out.println ( "\n\n\n" ) ;
        LinkedList.printList ( head1 );

        head2 = LinkedList.bigNumber2 ( );
        LinkedList.printList ( head2 );

        System.out.println ( "Using reverse: " );
        LinkedList.printList ( addUsingReverse ( head1, head2 ) );
        System.out.println ( "Using stack: " );
        LinkedList.printList ( addUsingStack ( head1, head2 ) );
        System.out.println ( "Using recursion: " );
        LinkedList.printList ( addUsingRecursion ( head1, head2 ) );
    }

    private static Node addUsingRecursion ( Node head1, Node head2, int [] carry, int len1, int len2 ) {
        if ( head1 == null && head2 == null ) {
            return null;
        }

        Node result = null;
        int sum = 0;

        if ( len1 > len2 ) {
            result = addUsingRecursion ( head1.next, head2, carry, len1 - 1, len2 );
            sum = head1.data + carry [ 0 ];
        } else if ( len2 > len1 ) {
            result = addUsingRecursion ( head1, head2.next, carry, len1, len2 - 1 );
            sum = head2.data + carry [ 0 ];
        } else {
            result = addUsingRecursion ( head1.next, head2.next, carry, len1 - 1, len2 - 1 );
            sum = head1.data + head2.data + carry [ 0 ];
        }

        Node newNode = new Node ( sum % 10 );
        carry [ 0 ] = sum / 10;

        newNode.next = result;
        return newNode;
    }

    private static Node addUsingRecursion ( Node head1, Node head2 ) {
        int [] carry = new int [] { 0 };
        Node result = addUsingRecursion ( head1, head2, carry, getLength ( head1 ), getLength ( head2 ) );
        if ( carry [ 0 ] > 0 ) {
            Node newNode = new Node ( carry [ 0 ] );
            newNode.next = result;
            result = newNode;
        }
        return result;
    }

    private static int getLength ( Node head ) {
        if ( head == null ) {
            return 0;
        }
        return 1 + getLength ( head.next );
    }

    private static Node addUsingStack ( Node head1, Node head2 ) {
        Deque<Node> pendingNodes1 = new ArrayDeque<> ();
        Deque<Node> pendingNodes2 = new ArrayDeque<> ();

        Node ptr1 = head1; 
        Node ptr2 = head2;

        while ( ptr1 != null ) {
            pendingNodes1.push ( ptr1 );
            ptr1 = ptr1.next;
        }

        while ( ptr2 != null ) {
            pendingNodes2.push ( ptr2 );
            ptr2 = ptr2.next;
        }

        Node sumHead = null;
        Node sumLast = null;

        int sum = 0;
        int carry = 0;

        while ( !pendingNodes1.isEmpty () || !pendingNodes2.isEmpty () || carry > 0 ) {
            sum = ( pendingNodes1.isEmpty () ) ? 0 : pendingNodes1.pop ().data;
            sum += ( pendingNodes2.isEmpty () ) ? 0 : pendingNodes2.pop ().data;
            sum += carry;

            sumHead = new Node ( sum % 10 );
            carry = sum / 10;

            sumLast = ( sumLast == null ) ? sumHead : sumLast;
            if ( sumLast != sumHead ) {
                sumHead.next = sumLast;
            }

            sumLast = sumHead;
        }

        return sumHead;
    }

    private static Node addUsingReverse ( Node head1, Node head2 ) {
        Node reversedHead1 = ReverseRecursive.reverse ( head1 );
        Node reversedHead2 = ReverseRecursive.reverse ( head2 );

        Node ptr1 = reversedHead1;
        Node ptr2 = reversedHead2;

        Node newNode = null;
        Node sumHead = null;
        Node sumLast = null;

        int carry = 0;
        int sum = 0;

        while ( ptr1 != null || ptr2 != null || carry > 0 ) {
            sum = ( ptr1 != null ) ? ptr1.data : 0;
            sum += ( ptr2 != null ) ? ptr2.data : 0;
            sum += carry;

            newNode = new Node ( sum % 10 );
            carry = sum / 10;

            sumHead = ( sumHead == null ) ? newNode : sumHead;
            if ( sumLast != null ) {
                sumLast.next = newNode;
            }
            sumLast = newNode;

            ptr1 = ( ptr1 != null ) ? ptr1.next : null;
            ptr2 = ( ptr2 != null ) ? ptr2.next : null;
        }

        head1 = ReverseRecursive.reverse ( reversedHead1 );
        head2 = ReverseRecursive.reverse ( reversedHead2 );

        return ReverseRecursive.reverse ( sumHead );
    }

    private static void printData ( Node ptr ) {
        if ( ptr != null ) {
            System.out.println ( ptr.data );
        } else {
            System.out.println ( "ptr is null" );
        }
    }
}
