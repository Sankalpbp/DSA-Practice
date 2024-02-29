public class InversionCount {

    public static void print () {
        int [] arr = new int [] { 1, 3, 9, 16, 2, 4, 6, 18 };
        System.out.println ( inversionCounts ( arr ) );
        System.out.println ( inversionCounts ( new int [] { 8, 4, 2, 1 } ) );
    }

    private static int inversionCounts ( int [] arr ) {
        return inversionCounts ( arr, 0, arr.length - 1 );
    }

    private static int inversionCounts ( int [] arr, int start, int end ) {
        if ( start >= end ) {
            return 0;
        }

        int mid = start + ( end - start ) / 2;
        int count = inversionCounts ( arr, start, mid );
        count += inversionCounts ( arr, mid + 1, end );

        return count + countRest ( arr, start, mid, end );
    }

    private static int countRest ( int [] arr, int start, int mid, int end ) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int [] left = new int [ n1 + 1 ];
        int [] right = new int [ n2 + 1 ];

        for ( int i = 0; i < n1; ++i ) {
            left [ i ] = arr [ start + i ];
        }

        for ( int j = 0; j < n2; ++j ) {
            right [ j ] = arr [ mid + 1 + j ];
        }

        left [ n1 ] = Integer.MAX_VALUE;
        right [ n2 ] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        int counts = 0;

        for ( int k = start; k <= end; ++k ) {
            if ( left [ i ] < right [ j ] ) {
                arr [ k ] = left [ i ];
                ++i;
            } else if ( left [ i ] > right [ j ] ) {
                counts += ( n1 - i );
                arr [ k ] = right [ j ];
                ++j;
            }
        }
        
        return counts;
    }
    
}
