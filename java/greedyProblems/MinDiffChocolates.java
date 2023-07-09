import java.util.List;
import java.util.Collections;

public class MinDiffChocolates {

    public static int minimum ( List<Integer> chocolates, int m ) {
        if ( m > chocolates.size () ) {
            return -1;
        }

        Collections.sort ( chocolates );
        
        int localMinimum = Integer.MAX_VALUE;
        int localMaximum = Integer.MIN_VALUE;

        int minDifference = Integer.MAX_VALUE;

        for ( int i = 0; i <= ( chocolates.size () - m ); ++i ) {
            localMinimum = chocolates.get ( i );
            localMaximum = chocolates.get ( i + m - 1 );

            minDifference = Math.min ( minDifference, ( localMaximum - localMinimum ) );
        }

        return minDifference;
    }
}
