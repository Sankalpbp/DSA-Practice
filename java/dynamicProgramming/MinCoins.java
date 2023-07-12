import java.util.List;
import java.util.Arrays;

public class MinCoins {

    public static int minCoinsDP ( List<Integer> coins, int money ) {
        int [][] cache = new int [ coins.size () + 1 ][ money + 1 ];

        for ( int i = 0; i <= money; ++i ) {
            cache [ 0 ][ money ] = Integer.MAX_VALUE - 1;
        }

        for ( int i = 0; i <= coins.size (); ++i ) {
            cache [ i ][ 0 ] = 0;
        }

        cache [ 0 ][ 0 ] = 0;

        for ( int coinIndex = 1; coinIndex <= coins.size (); ++coinIndex ) {
            for ( int requiredMoney = 1; requiredMoney <= money; ++requiredMoney ) {
                if ( coins.get ( coinIndex - 1 ) <= requiredMoney ) {
                    System.out.println ( "coin: " + coins.get ( coinIndex - 1 ) + " requiredMoney: " + requiredMoney + "answer: " + (1 + cache [ coinIndex ][ requiredMoney - coins.get ( coinIndex - 1 ) ] ) );
                    cache [ coinIndex ][ requiredMoney ] = Math.min ( 1 + cache [ coinIndex ][ requiredMoney - coins.get ( coinIndex - 1 ) ],
                                                                      cache [ coinIndex - 1 ][ requiredMoney ] );
                } else {
                    cache [ coinIndex ][ requiredMoney ] = cache [ coinIndex - 1 ][ requiredMoney ];
                }
            }
        }

        print ( cache );

        return cache [ coins.size () ][ money ];
    }

    public static int minCoinsMemo ( List<Integer> coins, int money ) {
        int [][] memo = new int [ coins.size () + 1 ][ money + 1 ];
        for ( int i = 0; i < memo.length; ++i ) {
            Arrays.fill ( memo [ i ], -1 );
        }

        return minCoinsMemo ( coins, money, coins.size (), memo );
    }

    private static int minCoinsMemo ( List<Integer> coins, int money, int n, int [][] memo ) {
        if ( money == 0 ) {
            memo [ n ][ money ] = 0;
            return memo [ n ][ money ];
        }

        if ( n == 0 ) {
            memo [ n ][ money ] = Integer.MAX_VALUE - 1;
            return memo [ n ][ money ];
        }

        int use = Integer.MAX_VALUE - 1;
        if ( coins.get ( n - 1 ) <= money ) {
            use = 1 + minCoinsMemo ( coins, money - coins.get ( n - 1 ), n, memo );
        }

        int dontUse = minCoinsMemo ( coins, money, n - 1, memo );

        memo [ n ][ money ] = Math.min ( use, dontUse );
        return memo [ n ][ money ];
    }

    public static int minCoins ( List<Integer> coins, int money ) {
        return minCoins ( coins, money, coins.size () );
    }

    private static int minCoins ( List<Integer> coins, int money, int n ) {

        if ( money == 0 ) {
            return 0;
        }

        if ( n == 0 ) {
            return Integer.MAX_VALUE - 1;
        }

        int use = Integer.MAX_VALUE;
        if ( coins.get ( n - 1 ) <= money ) {
            use = 1 + minCoins ( coins, money - coins.get ( n - 1 ), n );
        }

        int dontUse = minCoins ( coins, money, n - 1 );

        return Math.min ( use, dontUse );
    }

    private static void print ( int [][] cache ) {
        for ( int i = 0; i < cache.length; ++i ) {
            for ( int j = 0; j < cache[i].length; ++j ) {
                System.out.print ( cache [i][j] );
            }
            System.out.println ();
        }
    }
}
