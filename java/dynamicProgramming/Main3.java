import java.util.Arrays;

public class Main3 {

    public static void main ( String... args ) {

        System.out.println ( RodCutting.maxProfit ( Arrays.asList ( 1, 2, 3, 4, 5, 6, 7, 8 ),
                                                    Arrays.asList ( 1, 5, 8, 9, 10, 17, 17, 20 ), 
                                                    8 ) );

        System.out.println ( RodCutting.maxProfitMemo ( Arrays.asList ( 1, 2, 3, 4, 5, 6, 7, 8 ),
                                                        Arrays.asList ( 1, 5, 8, 9, 10, 17, 17, 20 ), 
                                                        8 ) );

        System.out.println ( RodCutting.maxProfitDP ( Arrays.asList ( 1, 2, 3, 4, 5, 6, 7, 8 ),
                                                      Arrays.asList ( 1, 5, 8, 9, 10, 17, 17, 20 ), 
                                                      8 ) );

        System.out.println ( CoinChange.denominations ( Arrays.asList ( 1, 2, 3 ), 
                                                        4 ) );
        System.out.println ( CoinChange.denominationsMemo ( Arrays.asList ( 1, 2, 3 ), 
                                                            4 ) );
        System.out.println ( CoinChange.denominationsDP ( Arrays.asList ( 1, 2, 3 ), 
                                                            4 ) );

        System.out.println ( MinCoins.minCoins ( Arrays.asList ( 25, 10, 5 ), 30 ) );
        System.out.println ( MinCoins.minCoinsMemo ( Arrays.asList ( 25, 10, 5 ), 30 ) );
        System.out.println ( MinCoins.minCoinsDP ( Arrays.asList ( 25, 10, 5 ), 30 ) );
    }

}
