public class FlipsForAToB {

    public static void print () {
        int x = Integer.parseInt ( "0010", 2 );
        int y = Integer.parseInt ( "0100", 2 );

        System.out.println ( "Flips required: " + getFlips ( x, y, 4 ) );
    }

    private static int getFlips ( int x, int y, int bits ) {
        int xor = x ^ y;

        int numberOfOnes = 0;
        int i = 0;

        while ( bits-- > 0 ) {
            if ( ( xor & ( 1 << i ) ) > 0 ) {
                ++numberOfOnes;
            }
            ++i;
        }
        
        return numberOfOnes;
    }
}
