import java.util.List;
import java.util.Arrays;

public class CoinChange {

    public static int denominationsDP ( List<Integer> coinTypes, int money ) {
        int [][] cache = new int [ coinTypes.size () + 1 ][ money + 1 ];

        for ( int i = 0; i <= money; ++i ) {
            cache [ 0 ][ money ] = 0;
        }

        for ( int i = 0; i <= coinTypes.size (); ++i ) {
            cache [ i ][ 0 ] = 1;
        }

        cache [ 0 ][ 0 ] = 1;

        for ( int coinIndex = 1; coinIndex <= coinTypes.size (); ++coinIndex ) {
            for ( int requiredMoney = 1; requiredMoney <= money; ++requiredMoney ) {
                if ( coinTypes.get ( coinIndex - 1 ) <= requiredMoney ) {
                    cache [ coinIndex ][ requiredMoney ] = cache [ coinIndex ][ requiredMoney - coinTypes.get ( coinIndex - 1 ) ] +
                                                           cache [ coinIndex - 1 ][ requiredMoney ];
                } else {
                    cache [ coinIndex ][ requiredMoney ] = cache [ coinIndex - 1 ][ requiredMoney ];
                }
            }
        }

        return cache [ coinTypes.size () ][ money ];
    }

    public static int denominationsMemo ( List<Integer> coinTypes, int money ) {
        int [][] memo = new int [ coinTypes.size () + 1 ][ money + 1 ];
        for ( int i = 0; i < memo.length; ++i ) {
            Arrays.fill ( memo [ i ], -1 );
        }
        return denominationsMemo ( coinTypes, money, coinTypes.size (), memo );
    }

    private static int denominationsMemo ( List<Integer> coinTypes, int money, int n, int [][] memo ) {
        if ( money == 0 ) {
            memo [ n ][ money ] = 1;
            return 1;
        }

        if ( n == 0 ) {
            memo [ n ][ money ] = 0;
            return 0;
        }

        if ( memo [ n ][ money ] != -1 ) {
            return memo [ n ][ money ];
        }

        int use = 0;
        if ( coinTypes.get ( n - 1 ) <= money ) {
            use = denominationsMemo ( coinTypes, money - coinTypes.get ( n - 1 ), n, memo );
        }

        int dontUse = denominationsMemo ( coinTypes, money, n - 1, memo );

        return use + dontUse;
    }

    public static int denominations ( List<Integer> coinTypes, int money ) {
        return denominations ( coinTypes, coinTypes.size (), money );
    }

    private static int denominations ( List<Integer> coinTypes, int n, int money ) {

        if ( money == 0 ) {
            return 1;
        }

        if ( n == 0 ) {
            return 0;
        }

        int use = 0;
        if ( coinTypes.get ( n - 1 ) <= money ) {
            use = denominations ( coinTypes, n, money - coinTypes.get ( n - 1 ) );
        }

        int dontUse = denominations ( coinTypes, n - 1, money );

        return use + dontUse;
    }
}
