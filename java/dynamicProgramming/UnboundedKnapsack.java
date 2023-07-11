import java.util.List;
import java.util.Arrays;

public class UnboundedKnapsack {

    public static int getProfitDP ( List<Integer> weights, List<Integer> values, int maxWeight ) {
        int [][] dp = new int [ values.size () + 1 ][ maxWeight + 1 ];

        for ( int itemCount = 0; itemCount <= values.size (); ++itemCount ) {
            dp [ itemCount ][ 0 ] = 0;
        }

        for ( int maxPossibleWeight = 0; maxPossibleWeight <= maxWeight; ++maxPossibleWeight ) {
            dp [ 0 ][ maxPossibleWeight ] = 0;
        }

        for ( int itemCount = 1; itemCount <= values.size (); ++itemCount ) {
            for ( int maxPossibleWeight = 1; maxPossibleWeight <= maxWeight; ++maxPossibleWeight ) {
                if ( weights.get ( itemCount - 1 ) <= maxPossibleWeight ) {
                    dp [ itemCount ][ maxPossibleWeight ] = Math.max ( dp [ itemCount - 1 ][ maxPossibleWeight ], 
                                                            values.get ( itemCount - 1 ) + dp [ itemCount ][ maxPossibleWeight - weights.get ( itemCount - 1 ) ] );
                } else {
                    dp [ itemCount ][ maxPossibleWeight ] = dp [ itemCount - 1 ][ maxPossibleWeight ];
                }
            }
        }

        return dp [ values.size () ][ maxWeight ];
    }

    public static int getProfitMemo ( List<Integer> weights, List<Integer> values, int maxWeight ) {
        int [][] memo = new int [ values.size () + 1 ][ maxWeight + 1 ];
        for ( int i = 0; i <= values.size (); ++i ) {
            Arrays.fill ( memo [ i ], -1 );
        }
        return getProfitMemo ( weights, values, values.size (), maxWeight, memo );
    }

    private static int getProfitMemo ( List<Integer> weights, List<Integer> values, int n, int maxWeight, int [][] memo ) {
        if ( n == 0 || maxWeight == 0 ) {
            memo [ n ][ maxWeight ] = 0;
            return 0;
        }

        if ( memo [ n ][ maxWeight ] != -1 ) {
            return memo [ n ][ maxWeight ];
        }

        int use = 0;
        
        if ( maxWeight >= weights.get ( n - 1 ) ) {
            use = values.get ( n - 1 ) + getProfitMemo ( weights, values, n, maxWeight - weights.get ( n - 1 ), memo );
        }

        int dontUse = getProfitMemo ( weights, values, n - 1, maxWeight, memo );

        memo [ n ][ maxWeight ] = Math.max ( use, dontUse );
        return memo [ n ][ maxWeight ];
    }

    public static int getProfitRecursive ( List<Integer> weights, List<Integer> values, int maxWeight ) {
        return getProfitRecursive ( weights, values, maxWeight, weights.size () );
    }

    private static int getProfitRecursive ( List<Integer> weights, List<Integer> values, int maxWeight, int n ) {
        if ( n == 0 || maxWeight == 0 ) {
            return 0;
        }

        int use = 0;
        if ( maxWeight >= weights.get ( n - 1 ) ) {
            use = values.get ( n - 1 ) + getProfitRecursive ( weights, values, maxWeight - weights.get ( n - 1 ), n );
        }

        int dontUse = getProfitRecursive ( weights, values, maxWeight, n - 1 );

        return Math.max ( use, dontUse );
    }
}
