import java.util.Arrays;

public class AggressiveCows {

    public static void print () {
        System.out.println ( minimumDistance ( 3, new int [] { 1, 2, 4, 8, 9 } ) );
    }

    private static int minimumDistance ( int cows, int [ ] positions ) {
        Arrays.sort ( positions );
        int minimumPossibleDistance = 0;
        int maximumPossibleDistance = positions [ positions.length - 1 ] - positions [ 0 ];

        int start = minimumPossibleDistance;
        int end = maximumPossibleDistance;
        int mid = 0;

        int largestMinDistance = 0;

        while ( start <= end ) {
            mid = start + ( end - start ) / 2;

            if ( couldFit ( mid, positions, cows ) ) {
                largestMinDistance = Math.max ( largestMinDistance, mid );
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return largestMinDistance;
    }

    private static boolean couldFit ( int minimumDistance, int [] positions, int cows ) {
        int lastPosition = positions [ 0 ];
        --cows;

        for ( int i = 1; i < positions.length; ++i ) {
            if ( positions [ i ] - lastPosition >= minimumDistance ) {
                --cows;
                if ( cows == 0 ) {
                    return true;
                }
                lastPosition = positions [ i ];
            }
        }

        return ( cows == 0 );
    }
}
