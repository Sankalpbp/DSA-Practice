import java.util.List;
import java.util.Arrays;

public class ZeroOneKnapsack {

    public static int getProfitDP ( List<Integer> weight, List<Integer> value, int maxWeight ) {
        int [][] cache = new int [ value.size () + 1 ][ maxWeight + 1 ];

        for ( int maxPossibleWeight = 0; maxPossibleWeight <= maxWeight; ++maxPossibleWeight ) {
            cache [ 0 ][ maxPossibleWeight ] = 0;
        }

        for ( int itemCount = 0; itemCount <= value.size (); ++itemCount ) {
            cache [ itemCount ][ 0 ] = 0;
        }

        for ( int itemCount = 1; itemCount <= value.size (); ++itemCount ) {
            for ( int maxPossibleWeight = 1; maxPossibleWeight <= maxWeight; ++maxPossibleWeight ) {
                if ( weight.get ( itemCount - 1 ) <= maxPossibleWeight ) {
                    cache [ itemCount ][ maxPossibleWeight ] = Math.max ( 
                                                cache [ itemCount - 1 ][ maxPossibleWeight ], 
                                                value.get ( itemCount - 1 ) + 
                                                    cache [ itemCount - 1 ][ maxPossibleWeight - weight.get ( itemCount - 1 ) ] );
                } else {
                    cache [ itemCount ][ maxPossibleWeight ] = cache [ itemCount - 1 ][ maxPossibleWeight ];
                }
            }
        }

        return cache [ value.size () ][ maxWeight ];
    }

    public static int getProfitMemo ( List<Integer> weight, List<Integer> value, int maxWeight ) {
        int [][] memo = new int [ value.size () + 1 ][ maxWeight + 1 ];
        for ( int i = 0; i <= value.size (); ++i ) {
            Arrays.fill ( memo [ i ], -1 );
        }
        return getProfitMemo ( weight, value, maxWeight, memo, weight.size () );
    }

    private static int getProfitMemo ( List<Integer> weight, List<Integer> value, int maxWeight, int [][] memo, int n ) {
        if ( n == 0 || maxWeight == 0 ) {
            memo [ n ][ maxWeight ] = 0;
            return 0;
        }

        if ( memo [ n ][ maxWeight ] != -1 ) {
            return memo [ n ][ maxWeight ];
        }

        int use = 0;

        if ( weight.get ( n - 1 ) <= maxWeight ) {
            use = value.get ( n - 1 ) + getProfitMemo ( weight, value, maxWeight - weight.get ( n - 1 ), memo, n - 1 );
        }

        int dontUse = getProfitMemo ( weight, value, maxWeight, memo, n - 1 );

        memo [ n ][ maxWeight ] = Math.max ( use, dontUse );
        return memo [ n ][ maxWeight ];
    }

    public static int getProfitRecursive ( List<Integer> weight, List<Integer> value, int maxWeight ) {
        return getProfitRecursive ( weight, value, maxWeight, weight.size () );
    }

    private static int getProfitRecursive ( List<Integer> weight, List<Integer> value, int maxWeight, int n ) {
        if ( n == 0 || maxWeight == 0 ) {
            return 0;
        }

        int use = 0;

        if ( weight.get ( n - 1 ) <= maxWeight ) {
            use = value.get ( n - 1 ) + getProfitRecursive ( weight, value, maxWeight - weight.get ( n - 1 ), n - 1 );
        }

        int dontUse = getProfitRecursive ( weight, value, maxWeight, n - 1 );

        return Math.max ( use, dontUse );
    }
}
