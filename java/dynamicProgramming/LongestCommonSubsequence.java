import java.util.List;
import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int lcsDP ( String s, String t ) {
        int [][] cache = new int [ s.length () + 1 ][ t.length () + 1 ];

        for ( int sLength = 0; sLength <= s.length (); ++sLength ) {
            cache [ sLength ][ 0 ] = 0;
        }

        for ( int tLength = 0; tLength <= t.length (); ++tLength ) {
            cache [ 0 ][ tLength ] = 0;
        }

        for ( int sLength = 1; sLength <= s.length (); ++sLength ) {
            for ( int tLength = 1; tLength <= t.length (); ++tLength ) {
                if ( s.charAt ( sLength - 1 ) == t.charAt ( tLength - 1 ) ) {
                    cache [ sLength ][ tLength ] = 1 + cache [ sLength - 1 ][ tLength - 1 ];
                } else {
                    cache [ sLength ][ tLength ] = Math.max ( cache [ sLength - 1 ][ tLength ], cache [ sLength ][ tLength - 1 ] );
                }
            }
        }

        return cache [ s.length () ][ t.length () ];
    }

    public static int lcsMemo ( String s, String t ) {
        int [][] memo = new int [ s.length () + 1 ][ t.length () + 1 ];
        for ( int i = 0; i <= s.length (); ++i ) {
            Arrays.fill ( memo [ i ], -1 );
        }
        return lcsMemo ( s, t, s.length (), t.length (), memo );
    }

    private static int lcsMemo ( String s, String t, int n, int m, int [][] memo ) {
        if ( n == 0 || m == 0 ) {
            memo [ n ][ m ] = 0;
            return 0;
        }

        if ( memo [ n ][ m ] != -1 ) {
            return memo [ n ][ m ];
        }

        if ( s.charAt ( n - 1 ) == t.charAt ( m - 1 ) ) {
            memo [ n ][ m ] = 1 + lcsMemo ( s, t, n - 1, m - 1, memo );
            return memo [ n ][ m ];
        }

        memo [ n ][ m ] = Math.max ( lcsMemo ( s, t, n - 1, m, memo ), lcsMemo ( s, t, n, m - 1, memo ) );
        return memo [ n ][ m ];
    }

    public static int lcsRecursive ( String s, String t ) {
        return lcsRecursive ( s, t, s.length (), t.length () );
    }

    private static int lcsRecursive ( String s, String t, int n, int m ) {
        if ( n == 0 || m == 0 ) {
            return 0;
        }

        if ( s.charAt ( n - 1 ) == t.charAt ( m - 1 ) ) {
            return 1 + lcsRecursive ( s, t, n - 1, m - 1 );
        }

        return Math.max ( lcsRecursive ( s, t, n - 1, m ), lcsRecursive ( s, t, n, m - 1 ) );
    }

}
