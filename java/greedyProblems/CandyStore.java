import java.util.List;
import java.util.Collections;

public class CandyStore {

    public static void minMaxPriceCandies ( List<Integer> prices, int k ) {
        Collections.sort ( prices );

        // for Min prices
        int minimum = 0;
        int i = 0; 
        int j = prices.size () - 1;

        while ( j >= i ) {
            minimum += prices.get ( i );
            j -= k;
            ++i;
        }

        System.out.println ( "Minimum price to buy candies: " + minimum );

        // for Max prices
        int maximum = 0;
        i = 0;
        j = prices.size () - 1;

        while ( j >= i ) {
            maximum += prices.get ( j );
            i += k;
            --j;
        }

        System.out.println ( "Maximum price to buy candies: " + maximum );
    }
}
