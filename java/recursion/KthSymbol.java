public class KthSymbol {

    public static char kth ( int n, int k ) {

        if ( n == 1 && k == 1 ) {
            return '0';
        }

        if ( k > Math.pow ( 2, ( n - 1 ) ) ) {
            return 'z';
        }

        char smallOutput = kth ( n - 1, ( k + 1 ) / 2 );
        if ( smallOutput == '0' ) {
            return ( k % 2 == 0 ) ? '1' : '0';
        }

        return ( k % 2 == 0 ) ? '0' : '1';
    }
}
