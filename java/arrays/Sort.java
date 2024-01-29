import java.util.Arrays;

public class Sort {

    public static void print ( ) {
        int [] arr = { 3, 7, 0, 2, 1, 9, 4 };

        printArray ( arr );
        quickSort ( arr, 0, arr.length - 1 );
        printArray ( arr );
    }

    private static void printArray ( int [] arr ) {
        System.out.println ();
        for ( int i = 0; i < arr.length; ++i ) {
            System.out.print ( arr [ i ] + " " );
        }
        System.out.println ();
    }

    private static void quickSort ( int [] arr, int start, int end ) {
        if ( start >= end ) {
            return;
        }

        int pivotIndex = quick ( arr, start, end );

        quickSort ( arr, start, pivotIndex - 1 );
        quickSort ( arr, pivotIndex + 1, end );
    }

    private static int quick ( int [] arr, int start, int end ) {
        int pivot = arr [ end ];
        int i = start - 1;
        
        for ( int j = start; j < end; ++j ) {
            if ( arr [ j ] < pivot ) {
                ++i;
                
                int temp = arr [ i ];
                arr [ i ] = arr [ j ];
                arr [ j ] = temp;
            }
        }

        int temp = arr [ i + 1 ];
        arr [ i + 1 ] = pivot;
        arr [ end ] = temp;

        return i + 1;
    }
}
