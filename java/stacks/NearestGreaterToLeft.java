import java.util.Stack;

public class NearestGreaterToLeft {

    public int [ ] nearestGreaterToLeft ( int [ ] arr ) {

        Stack<Integer> pendingElements = new Stack<> ();

        int [ ] nGToLeft = new int [ arr.length ];

        for ( int i = 0; i < arr.length; ++i ) {

            while ( !pendingElements.isEmpty () && arr [ pendingElements.peek () ] < arr [ i ] ) {
                pendingElements.pop ();
            }

            nGToLeft [ i ] = ( pendingElements.isEmpty () ) 
                                ? -1 
                                : arr [ pendingElements.peek () ];

            pendingElements.push ( i );
        }

        return nGToLeft;
    }

}
