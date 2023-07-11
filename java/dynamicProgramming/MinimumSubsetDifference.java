import java.util.List;

public class MinimumSubsetDifference {

    public static int minimum ( List<Integer> arr ) {
        int sum = arr.stream ()
                     .mapToInt ( Integer :: intValue )
                     .sum ();

        boolean [][] cache = new boolean [ arr.size () + 1 ][ sum + 1 ];

        for ( int i = 0; i <= sum; ++i ) {
            cache [ 0 ][ i ] = false;
        }
        
        for ( int i = 0; i <= arr.size (); ++i ) {
            cache [ i ][ 0 ] = true;
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

        int minDifference = Integer.MAX_VALUE;

        for ( int foundSum = 0; foundSum <= sum; ++foundSum ) {
            if ( cache [ arr.size () ][ foundSum ] ) {
                minDifference = Math.min ( minDifference, Math.abs ( 2 * foundSum - sum ) );
            }
        }

        return minDifference;
    }
}
