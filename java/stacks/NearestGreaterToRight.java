import java.util.Stack;

public class NearestGreaterToRight {

    public int [ ] nearestGreaterToRight ( int [ ] arr ) {

        Stack<Integer> pendingElements = new Stack<> ();

        int [ ] nGToRight = new int [ arr.length ];

        for ( int i = arr.length - 1; i >= 0; --i ) {

            while ( !pendingElements.isEmpty () && arr [ pendingElements.peek () ] < arr [ i ] ) {
                pendingElements.pop ();
            }

            nGToRight [ i ] = ( pendingElements.isEmpty () ) 
                                ? -1
                                : arr [ pendingElements.peek () ];

            pendingElements.push ( i );
        }

        return nGToRight;
    }
}
