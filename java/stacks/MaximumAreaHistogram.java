import java.util.Stack;

public class MaximumAreaHistogram {

    public int maximumArea ( int [ ] bars ) {

        int maximumAreaValue = 0;
        int area = 0;

        int [ ] nearestSmallerToLeft = getNearestSmallerToLeft ( bars );
        int [ ] nearestSmallerToRight = getNearestSmallerToRight ( bars );

        for ( int i = 0; i < bars.length; ++i ) {
            if ( nearestSmallerToRight [ i ] == -1 && nearestSmallerToLeft [ i ] == -1 ) {
                area = bars.length * bars [ i ];
            } else {
                area = ( nearestSmallerToRight [ i ] - nearestSmallerToLeft [ i ] - 1 ) * bars [ i ];
            }

            System.out.println ( "area: " + area );
            maximumAreaValue = Math.max ( area, maximumAreaValue );
        }

        return maximumAreaValue;
    }

    int [ ] getNearestSmallerToLeft ( int [ ] arr ) {
        int [ ] output = new int [ arr.length ];
        Stack<Integer> pendingBars = new Stack<> ();

        for ( int i = 0; i < arr.length; ++i ) {
            while ( !pendingBars.isEmpty () && arr [ pendingBars.peek () ] >= arr [ i ] ) {
                pendingBars.pop ();
            }

            output [ i ] = ( pendingBars.isEmpty () )
                                ? -1
                                : pendingBars.peek ();

            pendingBars.push ( i );
        }

        return output;
    }

    int [ ] getNearestSmallerToRight ( int [ ] arr ) {
        int [ ] output = new int [ arr.length ];
        Stack<Integer> pendingBars = new Stack<> ();

        for ( int i = arr.length - 1; i >= 0; --i ) {
            while ( !pendingBars.isEmpty () && arr [ pendingBars.peek () ] >= arr [ i ] ) {
                pendingBars.pop ();
            }

            output [ i ] = ( pendingBars.isEmpty () ) 
                                ? -1
                                : pendingBars.peek ();

            pendingBars.push ( i );
        }

        return output;
    }
}
