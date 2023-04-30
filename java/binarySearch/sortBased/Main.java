import java.util.Scanner;

public class Main {

    public static void main ( String... args ) {

        int [ ] arr = { 0, 2, 3, 5, 6, 7, 8, 9 };
        int [ ] reverse = { 9, 8, 7, 6, 5, 3, 2, 0 };

        BinarySearch bs = new BinarySearch ( );
        int x = ( new Scanner ( System.in ) ).nextInt ();
        System.out.println ( bs.binarySearchRecursive ( arr, x ) );

        System.out.println ( bs.binarySearchIterative ( arr, x ) );


        BinarySearchOnReverseSorted bsr = new BinarySearchOnReverseSorted ( );
        System.out.println ( bsr.binarySearchRecursive ( reverse, x ) );
        System.out.println ( bsr.binarySearchIterative ( reverse, x ) );

        OrderAgnosticSearch oas = new OrderAgnosticSearch ( );

        System.out.println ( oas.orderAgnosticSearch ( arr, x ) );
        System.out.println ( oas.orderAgnosticSearch ( reverse, x ) );
    }
}
