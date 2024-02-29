import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static void print () {
        Interval [] intervals = new Interval [] {
            new Interval ( 1, 3 ),
            new Interval ( 8, 10 ),
            new Interval ( 15, 18 ),
//            new Interval ( 9, 16 ),
            new Interval ( 2, 6 ),
        };

        Interval.printIntervals ( intervals );
        System.out.println ( "Merged Intervals: " + mergeIntervals ( intervals ) );
    }

    private static List<Interval> mergeIntervals ( Interval [] intervals ) {

        Arrays.sort ( intervals, ( i1, i2 ) -> {
            int result = Integer.compare ( i1.startTime, i2.startTime );
            return ( result == 0 ) ? Integer.compare ( i1.endTime, i2.endTime )
                                   : result;
        } );

        System.out.println ( "Sorted intervals: " );
        Interval.printIntervals ( intervals );

        List<Interval> result = new ArrayList<> ();
        Interval last = intervals [ 0 ];

        result.add ( last );

        for ( int i = 1; i < intervals.length; ++i ) {
            if ( last.endTime < intervals [ i ].startTime ) {
                result.add ( intervals [ i ] );
                last = intervals [ i ];
            } else {
                last.endTime = Math.max ( last.endTime, intervals [ i ].endTime );
            }
        }

        return result;
    }

    private static class Interval {
        public int startTime;
        public int endTime;

        public Interval ( int startTime, int endTime ) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Interval () {

        }

        public static void printIntervals ( Interval [] intervals ) {
            for ( int i = 0; i < intervals.length; ++i ) {
                System.out.println ( intervals [ i ] );
            }
        }

        public String toString ( ) {
            return "( startTime = " + startTime + "; endTime = " + endTime + " )";
        }
    }
}
