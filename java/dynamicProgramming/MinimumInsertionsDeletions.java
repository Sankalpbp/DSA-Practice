public class MinimumInsertionsDeletions {

    public static void print ( String s, String t ) {
        int lcs = getLCS ( s, t );

        String longer = ( s.length () >= t.length () ) ? s : t;
        String smaller = ( s.length () <= t.length () ) ? s : t;

        System.out.println ( "Insertions: " + ( longer.length () - lcs ) );
        System.out.println ( "Deletions: " + ( smaller.length () - lcs ) );
    }

    private static int getLCS ( String s, String t ) {
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
                    cache [ i ][ j ] = Math.max ( cache [ i - 1 ][ j ], cache [ i ][ j - 1 ] );
                }
            }
        }

        return cache [ s.length () ][ t.length () ];
    }
}
