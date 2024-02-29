import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class StockPricing {

    public static void print () {
        int [] arr = new int [] { 4, 3, 8, 6, 2, 10, 1 };
        List<Integer> buySell = stockPricing ( arr );
        System.out.println ( buySell + " " + ( arr [ buySell.get ( 1 ) ] - arr [ buySell.get ( 0 ) ] ) );

        List<Integer> buySell2 = stockPricingDnC ( arr, 0, arr.length - 1 );
        System.out.println ( buySell2 + " " + ( arr [ buySell2.get ( 1 ) ] - arr [ buySell2.get ( 0 ) ] ) );
    }

    private static List<Integer> stockPricingDnC ( int [] prices, int start, int end ) {
        if ( start >= end ) {
            return Arrays.asList ( start, start );
        }

        int mid = start + ( end - start ) / 2;

        List<Integer> leftResultIndices = stockPricingDnC ( prices, start, mid );
        List<Integer> rightResultIndices = stockPricingDnC ( prices, mid + 1, end );

        int leftResult = prices [ leftResultIndices.get ( 1 ) ] - prices [ leftResultIndices.get ( 0 ) ];
        int rightResult = prices [ rightResultIndices.get ( 1 ) ] - prices [ rightResultIndices.get ( 0 ) ];

        int leftMinimumIndex = getMinimum ( prices, start, mid );
        int rightMaximumIndex = getMaximum ( prices, mid + 1, end );

        int result = prices [ rightMaximumIndex ] - prices [ leftMinimumIndex ];

        if ( result > leftResult && result > rightResult ) {
            return Arrays.asList ( leftMinimumIndex, rightMaximumIndex );
        } else if ( leftResult > result && leftResult > rightResult ) {
            return leftResultIndices;
        } 
        return rightResultIndices;
    }

    private static List<Integer> stockPricing ( int [] prices ) {
        int maxProfit = Integer.MIN_VALUE;
        int maxIndex = prices.length - 1;
        int profit = 0;

        int maxBuyIndex = -1;
        int maxSellIndex = -1;

        for ( int i = prices.length - 1; i >= 0; --i ) {
            if ( prices [ i ] > prices [ maxIndex ] ) {
                maxIndex = i;
            }

            profit = prices [ maxIndex ] - prices [ i ];
            if ( profit > maxProfit ) {
                maxBuyIndex = i;
                maxSellIndex = maxIndex;
                maxProfit = profit;
            }
        }

        return Arrays.asList ( maxBuyIndex, maxSellIndex );
    }

    private static int getMinimum ( int [] arr, int start, int end ) {
        int minimumIndex = start;

        for ( int i = start + 1; i <= end; ++i ) {
            if ( arr [ i ] < arr [ minimumIndex ] ) {
                minimumIndex = i;
            }
        }

        return minimumIndex;
    }

    private static int getMaximum ( int [] arr, int start, int end ) {
        int maximumIndex = start;

        for ( int i = start + 1; i <= end; ++i ) {
            if ( arr [ i ] > arr [ maximumIndex ] ) {
                maximumIndex = i;
            }
        }

        return maximumIndex;
    }
    
}
