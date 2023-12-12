public class LargestNumberKSwaps {

    public static void print ( int n, int k ) {
        System.out.println ( largestKSwaps ( n, 0, k, 0 ) );
        
    }

    private static int largestKSwaps ( int n, int swaps, int k, int position ) {
        if ( swaps == k ) {
            return n;
        }

        int maxValue = Integer.MIN_VALUE;

        for ( int i = position; i < getNumberOfDigits ( n ); ++i ) {
            int newNumber = swapPositionI ( n, position, i );
            maxValue = Math.max ( maxValue, largestKSwaps ( newNumber, swaps + 1, k, position + 1 ) );
        }
        
        return maxValue;
    }

    private static int getNumberOfDigits ( int n ) {
        return ( int ) Math.log10 ( n ) + 1;
    }

    private static int swapPositionI ( int n, int position, int i ) {
        if ( position == i ) {
            return n;
        }

        int digits = getNumberOfDigits ( n );

        int positionDigit = ( n / ( int ) Math.pow ( 10, digits - 1 - position ) ) % 10;
        int iDigit = ( n / ( int ) Math.pow ( 10, digits - 1 - i ) ) % 10;

        return n + ( iDigit - positionDigit ) * ( int ) Math.pow ( 10, digits - 1 - position )
                 + ( positionDigit - iDigit ) * ( int ) Math.pow ( 10, digits - 1 - i );
    }

}
