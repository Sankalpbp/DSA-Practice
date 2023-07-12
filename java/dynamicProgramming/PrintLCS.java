public class PrintLCS {

    public static String print ( String s, String t ) {

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
                    cache [ i ][ j ] = Math.max ( cache [ i - 1 ][ j ], cache [ i ][ j - 1 ] );
                }
            }
        }
        
        int i = s.length ();
        int j = t.length ();

        StringBuilder sb = new StringBuilder ();

        while ( i > 0 && j > 0 ) {
            if ( s.charAt ( i - 1 ) == t.charAt ( j - 1 ) ) {
                sb.append ( s.charAt ( i - 1 ) );
                --i;
                --j;
            } else if ( cache [ i ][ j - 1 ] > cache [ i - 1 ][ j ] ) {
                --j;
            } else {
                --i;
            }
        }

        return sb.toString ();
    }

    private static void print ( int [][] cache ) {
        for ( int i = 0; i < cache.length; ++i ) {
            for ( int j = 0; j < cache[i].length; ++j ) {
                System.out.print ( cache [i][j] );
            }
        }
    }
}
