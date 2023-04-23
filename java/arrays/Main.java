public class Main {

    public static void printArray ( int [] arr ) {

        System.out.println ();
        for ( int i = 0; i < arr.length; ++i ) {
            System.out.print ( arr [ i ] + " " );
        }

        System.out.println ();
    }
    
    public static void main ( String... args ) {

        int [ ] arr = { 8, 0, 7, 2, 5, 9, 3, 6 };

        LargestToLeftRight llr = new LargestToLeftRight ();
        SmallestToLeftRight slr = new SmallestToLeftRight ( );

        int [ ] leftLargest = llr.largestToLeft ( arr );
        int [ ] rightLargest = llr.largestToRight ( arr );

        int [ ] leftSmallest = slr.smallestToLeft ( arr );
        int [ ] rightSmallest = slr.smallestToRight ( arr );

        printArray ( leftLargest );
        printArray ( rightLargest );
        printArray ( leftSmallest );
        printArray ( rightSmallest );
    }
}
