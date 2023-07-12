import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LongestPalindromicSubsequence {

    public static int longest ( String s ) {

        String reversedString = reverse ( s );
        return lcs ( s, reversedString );
    }

    private static String reverse ( String s ) {
        char [] array = s.toCharArray ();
        List<Character> charArray = new ArrayList<> ( array.length );
        for ( char x : array ) { charArray.add ( x ); }

        Collections.reverse ( charArray );
        return charArray.toString ()
                        .substring ( 1, 3 * charArray.size () - 1 ) 
                        .replaceAll ( ", ", "" );
    }

    private static int lcs ( String s, String t ) {
        int [][] cache = new int [ s.length () + 1 ][ t.length () + 1 ];

        for ( int i = 0; i <= s.length (); ++i ) {
            cache [ i ][ 0 ] = 0;
        }

        for ( int j = 0; j <= t.length (); ++j ) {
            cache [ 0 ][ j ] = 0;
        }

        for ( int i = 1; i <= s.length (); ++i ) {
            for ( int j = 1; j <= t.length (); ++j ) {
                if ( s.charAt ( i - 1 ) == t.charAt ( j - 1 ) ) {
                    cache [ i ][ j ] = 1 + cache [ i - 1 ][ j - 1 ];
                } else {
                    cache [ i ][ j ] = Math.max ( cache [ i ][ j - 1 ], cache [ i - 1 ][ j ] );
                }
            }
        }

        return cache [ s.length () ][ t.length () ];
    }
}

