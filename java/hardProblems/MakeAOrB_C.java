public class MakeAOrB_C {

    public static void print () {
        int a = Integer.parseInt ( "0010", 2 );
        int b = Integer.parseInt ( "0110", 2 );
        int c = Integer.parseInt ( "0101", 2 );

        System.out.println ( "Minimum number of flips: " + minFlipsForAOrB_C ( a, b, c, 4 ) );
    }

    private static int minFlipsForAOrB_C ( int a, int b, int c, int bits ) {
        int or = a | b;
        int orAndC = or & c;
        int orXorC = or ^ c;

        return getSetBits ( orAndC, bits ) + getSetBits ( orXorC, bits );
    }

    private static int getSetBits ( int x, int bits ) {
        int numberOfOnes = 0;
        int i = 0;

        while ( bits-- > 0 ) {
            if ( ( x & ( 1 << i ) ) > 0 ) {
                ++numberOfOnes;
            }
            ++i;
        }

        return numberOfOnes;
    }
}
