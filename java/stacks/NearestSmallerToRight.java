import java.util.Stack;

public class NearestSmallerToRight {

    public int [ ] nearestSmallerToRight ( int [ ] arr ) {

        Stack<Integer> pendingElements = new Stack<> ();
        int [ ] output = new int [ arr.length ];

        for ( int i = arr.length - 1; i >= 0; --i ) {

            while ( ! pendingElements.isEmpty () && arr [ pendingElements.peek () ] > arr [ i ] ) {
                pendingElements.pop ();
            }

            output [ i ] = ( pendingElements.isEmpty () )
                                ? -1
                                : arr [ pendingElements.peek () ];

            pendingElements.push ( i );
        }

        return output;
    }
}
