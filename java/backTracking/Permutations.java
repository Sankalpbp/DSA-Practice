import java.util.List;
import java.util.ArrayList;

public class Permutations {

    public static void print ( String s ) {
        List<String> result = new ArrayList<> ();
        permute ( new StringBuilder ( s ), 0, result );
        System.out.println ( result );
    }

    private static void permute ( StringBuilder s, int index, List<String> result ) {
        if ( index == s.length () - 1 ) {
            result.add ( s.toString () );
            return;
        }

        for ( int i = index; i < s.length (); ++i ) {
            s = swap ( s, i, index );
            permute ( s, index + 1, result );
            s = swap ( s, index, i );
        }
    }

    private static StringBuilder swap ( StringBuilder s, int i, int j ) {
        char temporary = s.charAt ( i );
        s.setCharAt ( i, s.charAt ( j ) );
        s.setCharAt ( j, temporary );

        return s;
    }
}
