import java.util.Stack;

public class StockSpanProblem {

    public int [ ] stockSpan ( int [ ] stockPrices ) {

        int [ ] span = new int [ stockPrices.length ];
        Stack<Integer> pendingDays = new Stack<> ();

        for ( int i = 0; i < stockPrices.length; ++i ) {

            while ( ! pendingDays.isEmpty () && stockPrices [ pendingDays.peek () ] < stockPrices [ i ] ) {
                pendingDays.pop ();
            }

            span [ i ] = ( pendingDays.isEmpty () )
                            ? ( i + 1 )
                            : i - pendingDays.peek ();

            pendingDays.push ( i );
        }

        return span;
    }
}
