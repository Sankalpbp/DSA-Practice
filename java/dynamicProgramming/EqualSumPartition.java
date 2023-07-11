import java.util.List;
import java.util.Arrays;

public class EqualSumPartition {

    public static boolean partition ( List<Integer> arr ) {
        int sum = arr.stream ()
                     .mapToInt ( Integer :: intValue )
                     .sum ();
        if ( sum % 2 == 1 ) {
            return false;
        }

        return partition ( arr, sum / 2 );
    }

    private static boolean partition ( List<Integer> arr, int sum ) {
        boolean [][] cache = new boolean [ arr.size () + 1 ][ sum + 1 ];

        Arrays.fill ( cache [ 0 ], false );

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

        return cache [ arr.size () ][ sum ];
    }
}
