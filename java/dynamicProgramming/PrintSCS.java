public class PrintSCS {

    public static String getSCS ( String s, String t ) {
        int [][] lcs = buildLCS ( s, t );

        String scs = "";
        int i = s.length ();
        int j = t.length ();

        while ( i > 0 && j > 0 ) {
            if ( s.charAt ( i - 1 ) == t.charAt ( j - 1 ) ) {
                scs += s.charAt ( i - 1 );
                --i;
                --j;
            } else {
                if ( lcs [ i - 1 ][ j ] > lcs [ i ][ j - 1 ] ) {
                    scs += s.charAt ( i - 1 );
                    --i;
                } else {
                    scs += t.charAt ( j - 1 );
                    --j;
                }
            }
        }

        while ( i > 0 ) {
            scs += s.charAt ( i - 1 );
            --i;
        }

        while ( j > 0 ) {
            scs += t.charAt ( j - 1 );
            --j;
        }

        return reverse ( scs );
    }

    private static String reverse ( String s ) {
        StringBuilder sb = new StringBuilder ();

        for ( int i = s.length () - 1; i >= 0; --i ) {
            sb.append ( s.charAt ( i ) );
        }

        return sb.toString ();
    }

    private static int [][] buildLCS ( String s, String t ) {
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

        return cache;
    }
}
