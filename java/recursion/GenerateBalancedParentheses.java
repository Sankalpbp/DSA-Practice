public class GenerateBalancedParentheses {

    public static void permutation ( int n ) {
        permutation ( n, 0, 0, "" );
    }

    private static String repeat ( int n, char ch ) {
        StringBuilder sb = new StringBuilder ( );
        for ( int i = 0; i < n; ++i ) {
            sb.append ( ch );
        }
        return sb.toString ();
    }

    private static void permutation ( int n, int open, int close, String output ) {
        if ( open == n ) {
            output += repeat ( ( n - close ), ')');
            System.out.println ( output );
        } else if ( open == close ) {
            permutation ( n, open + 1, close, output + "(" );
        } else {
            permutation ( n, open + 1, close, output + "(" );
            permutation ( n, open, close + 1, output + ")" );
        }
    }
}
