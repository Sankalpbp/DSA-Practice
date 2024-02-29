public class FlipBitsFromLSBToi {

    public static void print () {
        int x = 0B0111010110;
        System.out.println ( Integer.toBinaryString ( flip ( x ) ) );
    }

    private static int flip ( int x ) {
        return x & ( ~ ( 1 << ( i + 1 ) - 1 ) );
    }
}
