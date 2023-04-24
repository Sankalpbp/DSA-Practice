import java.util.Stack;

public class NearestSmallerToTheLeft {

    public int [ ] nearestSmallerToLeft ( int [ ] arr ) {

        int [ ] output = new int [ arr.length ];

        Stack<Integer> pendingElements = new Stack<> ();

        for ( int i = 0; i < arr.length; ++i ) {

            while ( !pendingElements.isEmpty () && arr [ pendingElements.peek () ] > arr [ i ] ) {
                pendingElements.pop ();
            }

            output [ i ] = ( pendingElements.isEmpty () )
                                ? -1
                                : arr [ pendingElements.peek () ];

            pendingElements.push ( i );
        }

        return output;
    }

    public int [ ] nearestSmallerToLeftInefficient ( int [ ] arr ) {

        int [ ] output = new int [ arr.length ];

        for ( int i = 0; i < arr.length; ++i ) {
            for ( int j = i - 1; j >= 0; --j ) {
                if ( arr [ j ] < arr [ i ] ) {
                    output [ i ] = arr [ j ];
                    break;
                }
            }
        }

        return output;
    }
}
