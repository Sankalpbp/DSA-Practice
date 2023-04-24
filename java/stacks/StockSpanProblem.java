import java.util.Stack;

public class StockSpanProblem {

    public int [ ] stockSpan ( int [ ] arr ) {

        int [ ] span = new int [ arr.length ];
        Stack<Integer> pendingDays = new Stack<> ();

        for ( int i = 0; i < arr.length; ++i ) {

            while ( !pendingDays.isEmpty () && arr [ pendingDays.peek () ] < arr [ i ] ) {
                pendingDays.pop ();
            }

            if ( pendingDays.isEmpty () ) {
                System.out.println ( i );
            }
            span [ i ] = ( pendingDays.isEmpty () )
                                ? ( i + 1 )
                                : ( i - pendingDays.peek () );

            pendingDays.push ( i );
        }

        return span;
    }
}
