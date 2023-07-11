import java.util.List;
import java.util.Arrays;

public class SubsetSum {

    public static boolean isPossibleDP ( List<Integer> arr, int sum ) {
        boolean [][] cache = new boolean [ arr.size () + 1 ][ sum + 1 ];

        for ( int requiredSum = 0; requiredSum <= sum; ++requiredSum ) {
            cache [ 0 ][ requiredSum ] = false;
        }

        for ( int itemCount = 0; itemCount <= arr.size (); ++itemCount ) {
            cache [ itemCount ][ 0 ] = true;
        }

        cache [ 0 ][ 0 ] = true;

        for ( int itemCount = 1; itemCount <= arr.size (); ++itemCount ) {
            for ( int requiredSum = 1; requiredSum <= sum; ++requiredSum ) {
                if ( arr.get ( itemCount - 1 ) <= requiredSum ) {
                    cache [ itemCount ][ requiredSum ] = cache [ itemCount - 1 ][ requiredSum - arr.get ( itemCount - 1 ) ] |
                                                         cache [ itemCount - 1 ][ requiredSum ];
                } else {
                    cache [ itemCount ][ requiredSum ] = cache [ itemCount - 1 ][ requiredSum ];
                }
            }
        }

        return cache [ arr.size () ][ sum ];
    }

    public static boolean isPossibleMemo ( List<Integer> arr, int sum ) {
        Boolean [][] memo = new Boolean [ arr.size () + 1 ][ sum + 1 ];
        for ( int i = 0; i <= arr.size (); ++i ) {
            Arrays.fill ( memo [ i ], null );
        }
        return isPossibleMemo ( arr, arr.size (), sum, memo );
    }

    private static boolean isPossibleMemo ( List<Integer> arr, int n, int sum, Boolean [][] memo ) {
        if ( sum == 0 ) {
            memo [ n ][ sum ] = true;
            return memo [ n ][ sum ];
        } 

        if ( n == 0 ) {
            memo [ n ][ sum ] = false;
            return memo [ n ][ sum ];
        }

        if ( memo [ n ][ sum ] != null ) {
            return memo [ n ][ sum ];
        }

        boolean use = false;
        
        if ( arr.get ( n - 1 ) <= sum ) {
            use = isPossibleMemo ( arr, n - 1, sum - arr.get ( n - 1 ), memo );
        }

        boolean dontUse = isPossibleMemo ( arr, n - 1, sum, memo );
        
        memo [ n ][ sum ] = use | dontUse;
        return memo [ n ][ sum ];
    }

    public static boolean isPossible ( List<Integer> arr, int sum ) {
        return isPossible ( arr, arr.size (), sum );
    }

    private static boolean isPossible ( List<Integer> arr, int n, int sum ) {
        if ( sum == 0 ) {
            return true;
        }

        if ( n == 0 ) {
            return false;
        }

        boolean use = false;
        if ( arr.get ( n - 1 ) <= sum ) {
            use = isPossible ( arr, n - 1, sum - arr.get ( n - 1 ) );
        }

        boolean dontUse = isPossible ( arr, n - 1, sum );

        return use | dontUse;
    }
}
