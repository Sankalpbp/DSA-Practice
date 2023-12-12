import java.util.List;

public class WordBreak {

    public static void print ( String s, List<String> dictionary ) {
        System.out.println ( isSCreatable ( s, dictionary , 0, 0 ) );
    }

    private static boolean isSCreatable ( String s, List<String> dictionary, int i, int j ) {
        if ( i == s.length () && j == s.length () ) {
            return true;
        }

        if ( i < s.length () && j == s.length () ) {
            return false;
        }
        
        if ( dictionary.contains ( s.substring ( i, j + 1 ) ) ) {
            return isSCreatable ( s, dictionary, i, j + 1 ) || isSCreatable ( s, dictionary, j + 1, j + 1 );
        }

        return isSCreatable ( s, dictionary, i, j + 1 );
    }
}
