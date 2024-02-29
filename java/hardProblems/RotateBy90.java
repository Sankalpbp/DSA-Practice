import java.util.Arrays;

public class RotateBy90 {

    public static void print () {
        int [ ][ ] arr = new int [ ][ ] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        rotateAndPrint ( arr );

        int [ ] [ ] arr2 = new int [ ][ ] {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 }
        };

        rotateAndPrint ( arr2 );
    }

    private static void rotateAndPrint ( int [][] arr ) {
        // first transpose, then swap rows top to bottom
        printMatrix ( arr );
        transpose ( arr );
        printMatrix ( arr );
        swapRows ( arr, 0, arr.length - 1 );
        printMatrix ( arr );
    }

    private static void transpose ( int [][] arr ) {
       for ( int i = 0; i < arr.length - 1; ++i ) {
           for ( int j = 0; j < arr [ 0 ].length - 1 - i; ++j ) {
               int temp = arr [ arr.length - 1 - j ][ arr [ 0 ].length - 1 - i ];
               arr [ arr.length - 1 - j ][ arr [ 0 ].length - 1 - i ] = arr [ i ][ j ];
               arr [ i ][ j ] = temp;
           }
       }
    }

    private static void swapRows ( int [][] arr, int start, int end ) {
        while ( start < end ) {

            for ( int i = 0; i < arr [ 0 ].length; ++i ) {
                int temp = arr [ start ][ i ];
                arr [ start ][ i ] = arr [ end ][ i ];
                arr [ end ][ i ] = temp;
            }

            ++start;
            --end;
        }
    }

    private static void printMatrix ( int [][] arr ) {
        Arrays.stream ( arr )
              .map ( row -> Arrays.toString ( row ) )
              .forEach ( System.out :: println );
        System.out.println ();
    }

}
