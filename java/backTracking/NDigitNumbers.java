import java.util.List;
import java.util.ArrayList;

public class NDigitNumbers {

    public static void print ( int n ) {
        List<String> result = new ArrayList<> ();
        String smallestNumber = createSmallestNumber ( n );
        solve ( smallestNumber, smallestNumber.length () - 1, result );
        System.out.println ( result );
    }

    private static void solve ( String number, int position, List<String> result ) {
        if ( position < 0 ) {
            result.add ( number );
            return;
        }

        int k = convertCharToNumber ( number.charAt ( position ) );
        int maxK = ( position == number.length () - 1 ) ? 9
                                                        : convertCharToNumber ( number.charAt ( position + 1 ) ) - 1;

        System.out.println ( "k = " + k + ", maxK = " + maxK );
        for ( int i = k; i <= maxK; ++i ) {
            String newNumber = number.substring ( 0, position ) + i + number.substring ( position + 1 );
            solve ( newNumber, position - 1, result );
        }
    }

    private static int convertCharToNumber ( char ch ) {
        return ch - '0';
    }

    private static String createSmallestNumber ( int n ) {
        StringBuilder s = new StringBuilder ( "1" );
        for ( int i = 2; i <= n; ++i ) {
            s.append ( i );
        }
        return s.toString ();
    }
}
