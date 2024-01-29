public class SplitCLL {

    public static void executeCLL ( ) {
        CLLNode head = CyclicList.createList ();
        System.out.println ( "\n\nList: " );
        CyclicList.printList ( head );

        Pair pair = splitList ( head );
        CyclicList.printList ( pair.firstHalf );
        CyclicList.printList ( pair.secondHalf );
        System.out.println ( "\n\n" );

        head = CyclicList.createList2 ();
        System.out.println ( "\n\nList: " );
        CyclicList.printList ( head );

        pair = splitList ( head );
        CyclicList.printList ( pair.firstHalf );
        CyclicList.printList ( pair.secondHalf );
        System.out.println ( "\n\n" );

        head = CyclicList.createList3 ();
        System.out.println ( "\n\nList: " );
        CyclicList.printList ( head );

        pair = splitList ( head );
        CyclicList.printList ( pair.firstHalf );
        CyclicList.printList ( pair.secondHalf );
        System.out.println ( "\n\n" );

        head = CyclicList.createList4 ();
        System.out.println ( "\n\nList: " );
        CyclicList.printList ( head );

        pair = splitList ( head );
        CyclicList.printList ( pair.firstHalf );
        CyclicList.printList ( pair.secondHalf );
        System.out.println ( "\n\n" );

        head = CyclicList.createList5 ();
        System.out.println ( "\n\nList: " );
        CyclicList.printList ( head );

        pair = splitList ( head );
        CyclicList.printList ( pair.firstHalf );
        CyclicList.printList ( pair.secondHalf );
        System.out.println ( "\n\n" );
    }

    private static Pair splitList ( CLLNode head ) {
        CLLNode slow = head;
        CLLNode fast = head;

        if ( slow.next != head && fast.next.next != head ) {
            slow = slow.next;
            fast = fast.next.next;
            while ( fast != head && fast.next != head && fast.next.next != head ) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if ( slow == fast ) {
                fast.next.next = fast.next;
                slow.next = head;
            }
        }

        while ( fast.next != head ) {
            fast = fast.next;
        }

        Pair pair = new Pair ();
        fast.next = slow.next;
        pair.secondHalf = slow.next;

        slow.next = head;
        pair.firstHalf = head;

        return pair;
    }

    private static class Pair {
        CLLNode firstHalf;
        CLLNode secondHalf;
    }
}
