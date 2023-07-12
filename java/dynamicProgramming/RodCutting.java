import java.util.List;
import java.util.Arrays;

public class RodCutting {

    public static int maxProfitDP ( List<Integer> lengths, List<Integer> profits, int totalLength ) {
        int [][] cache = new int [ lengths.size () + 1 ][ totalLength + 1 ];
        
        for ( int length = 0; length <= totalLength; ++length ) {
            cache [ 0 ][ length ] = 0;
        }

        for ( int lengthType = 0; lengthType <= lengths.size (); ++lengthType ) {
            cache [ lengthType ][ 0 ] = 0;
        }

        for ( int lengthTypeIndex = 1; lengthTypeIndex <= lengths.size (); ++lengthTypeIndex ) {
            for ( int length = 1; length <= totalLength; ++length ) {
                if ( lengths.get ( lengthTypeIndex - 1 ) <= length ) {
                    cache [ lengthTypeIndex ][ length ] = Math.max ( profits.get ( lengthTypeIndex - 1 ) + cache [ lengthTypeIndex ][ length - lengths.get ( lengthTypeIndex - 1 ) ],
                                                                     cache [ lengthTypeIndex - 1 ][ length ] );
                } else {
                    cache [ lengthTypeIndex ][ length ] = cache [ lengthTypeIndex - 1 ][ length ];
                }
            }
        }
        
        return cache [ lengths.size () ][ totalLength ];
    }

    public static int maxProfitMemo ( List<Integer> lengths, List<Integer> profits, int totalLength ) {
        int [][] memo = new int [ lengths.size () + 1 ][ totalLength + 1 ];
        for ( int i = 0; i < memo.length; ++i ) {
            Arrays.fill ( memo [ i ], -1 );
        }

        return maxProfitMemo ( lengths, profits, lengths.size (), totalLength, memo );
    }

    private static int maxProfitMemo ( List<Integer> lengths, List<Integer> profits, int n, int totalLength, int [][] memo ) {
        if ( n == 0 || totalLength == 0 ) {
            memo [ n ][ totalLength ] = 0;
            return memo [ n ][ totalLength ];
        }

        if ( memo [ n ][ totalLength ] != -1 ) {
            return memo [ n ][ totalLength ];
        }

        int use = 0;
        if ( lengths.get ( n - 1 ) <= totalLength ) {
            use = profits.get ( n - 1 ) + maxProfitMemo ( lengths, profits, n, totalLength - lengths.get ( n - 1 ), memo );
        }

        int dontUse = maxProfitMemo ( lengths, profits, n - 1, totalLength, memo );

        memo [ n ][ totalLength ] = Math.max ( use, dontUse );

        return memo [ n ][ totalLength ];
    }

    public static int maxProfit ( List<Integer> lengths, List<Integer> profits, int totalLength ) {
        return maxProfit ( lengths, profits, lengths.size (), totalLength );
    }

    private static int maxProfit ( List<Integer> lengths, List<Integer> profits, int n, int totalLength ) {
        if ( n == 0 || totalLength == 0 ) {
            return 0;
        }

        int use = 0;
        if ( lengths.get ( n - 1 ) <= totalLength ) {
            use = profits.get ( n - 1 ) + maxProfit ( lengths, profits, n, totalLength - lengths.get ( n - 1 ) );
        }
        
        int dontUse = maxProfit ( lengths, profits, n - 1, totalLength );
        
        return Math.max ( use, dontUse );
    }
}
