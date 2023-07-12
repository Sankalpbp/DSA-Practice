public class ShortestCommonSupersequence {

    public static int shortest ( String s, String t ) {
        int lcs = getLCS ( s, t );
        return s.length () + t.length () - lcs;
    }

    private static int getLCS ( String s, String t ) {
        int [][] cache = new int [ s.length () + 1 ][ t.length () + 1 ];

        for ( int i = 0; i <= s.length (); ++i ) {
            cache [ i ][ 0 ] = 0;
        }

        for ( int i = 0; i <= t.length (); ++i ) {
            cache [ 0 ][ i ] = 0;
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
