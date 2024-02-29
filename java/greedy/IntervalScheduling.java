import java.util.Comparator;
import java.util.Arrays;

public class IntervalScheduling {

    public static void print () {
        System.out.println ( "Maximum number of intervals that can be scheduled are: " + schedule ( 1, 3, 2, 5, 3, 9, 6, 8 ) );
    }

    private static int schedule ( int ... timings ) {
        if ( timings.length % 2 != 0 ) {
            throw new RuntimeException ( "Provide a valid array of timings" );
        }

        Interval [] intervals = new Interval [ timings.length / 2 ];

        for ( int i = 0; i < timings.length; i += 2 ) {
            intervals [ i / 2 ] = new Interval ( timings [ i ], timings [ i + 1 ] );
        }

        Arrays.sort ( intervals, new Comparator<Interval> () {
            public int compare ( Interval i1, Interval i2 ) {
/*                return ( i1.endTime > i2.endTime ) ? 1
                                                   : ( ( i1.endTime == i2.endTime ) ? 0
                                                                                    : -1 ); */
                return Integer.compare ( i1.endTime, i2.endTime );
            }
        } );

        int maxIntervals = 1;
        int currentTime = intervals [ 0 ].endTime;

        for ( int i = 1; i < intervals.length; ++i ) {
            if ( intervals [ i ].startTime >= currentTime ) {
                ++maxIntervals;
                currentTime = intervals [ i ].endTime;
            }
        }

        return maxIntervals;
    }

    private static class Interval {
        public int startTime;
        public int endTime;

        public Interval ( int startTime, int endTime ) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
