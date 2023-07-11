import java.util.List;

public class CountSubsetSum {

    public static int count2 ( List<Integer> arr, int sum ) {
        int [][] cache = new int [ arr.size () + 1 ][ sum + 1 ];

        for ( int requiredSum = 0; requiredSum <= sum; ++requiredSum ) {
            cache [ 0 ][ requiredSum ] = 0;
        }

        for ( int itemCount = 0; itemCount <= arr.size (); ++itemCount ) {
            cache [ itemCount ][ 0 ] = 1;
        }

        cache [ 0 ][ 0 ] = 1;

        for ( int itemCount = 1; itemCount <= arr.size (); ++itemCount ) {
            for ( int requiredSum = 1; requiredSum <= sum; ++requiredSum ) {
                if ( arr.get ( itemCount - 1 ) <= requiredSum ) {
                    cache [ itemCount ][ requiredSum ] = cache [ itemCount - 1 ][ requiredSum - arr.get ( itemCount - 1 ) ]
                                                         + cache [ itemCount - 1 ][ requiredSum ];
                } else {
                    cache [ itemCount ][ requiredSum ] = cache [ itemCount - 1 ][ requiredSum ];
                }
            }
        }

        return cache [ arr.size () ][ sum ];
    }

    /* DIDN'T WORK */
    public static int count ( List<Integer> arr, int sum ) {
        boolean [][] cache = buildCache ( arr, sum );

        print ( cache );

        int count = 0;
        for ( int itemCount = 0; itemCount <= arr.size (); ++itemCount ) {
            if ( cache [ itemCount ][ sum ] ) {
                ++count;
            }
        }

        return count;
    }

    private static boolean [][] buildCache ( List<Integer> arr, int sum ) {
        boolean [][] cache = new boolean [ arr.size () + 1 ][ sum + 1 ];

        for ( int requiredSum = 0; requiredSum <= sum; ++requiredSum ) {
            cache [ 0 ][ requiredSum ] = false;
        }

        for ( int itemCount = 0; itemCount <= arr.size (); ++itemCount ) {
            cache [ itemCount ][ 0 ] = true;
        }

        cache [ 0 ][ 0 ] = true;

        for ( int itemCount = 1; itemCount <= arr.size (); ++itemCount ) {
            for ( int requiredSum = 1; requiredSum <= sum; ++requiredSum ) {
                if ( arr.get ( itemCount - 1 ) <= requiredSum ) {
                    cache [ itemCount ][ requiredSum ] = cache [ itemCount - 1 ][ requiredSum - arr.get ( itemCount - 1 ) ] |
                                                         cache [ itemCount - 1 ][ requiredSum ];
                } else {
                    cache [ itemCount ][ requiredSum ] = cache [ itemCount - 1 ][ requiredSum ];
                }
            }
        }

        return cache;
    }

    private static void print ( boolean [][] cache ) {
        for ( int i = 0; i < cache.length; ++i ) {
            for ( int j = 0; j < cache [ i ].length; ++j ) {
                System.out.print ( cache [ i ][ j ] + " " );
            }
            System.out.println ();
        }
    }
}
