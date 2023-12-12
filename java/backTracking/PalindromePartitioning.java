import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {

    public static void print ( String s ) {
        List<List<String>> result = new ArrayList<> ();
        partition ( s, 0, result, new ArrayList<> () );
        System.out.println ( result );
    }

    private static void partition ( String s, int prefixStart, List<List<String> > result, List<String> partitions ) {
        if ( prefixStart == s.length () ) {
            result.add ( new ArrayList<> ( partitions ) );
            return;
        }

        for ( int i = prefixStart; i < s.length (); ++i ) {
            String leftPartOfString = s.substring ( prefixStart, i + 1 );
            if ( isPalindrome ( leftPartOfString ) ) {
                partitions.add ( leftPartOfString );
                partition ( s, i + 1, result, partitions );
                partitions.remove ( partitions.size () - 1 );
            }
        }
    }

    private static boolean isPalindrome ( String s ) {
        int i = 0;
        int j = s.length () - 1;

        while ( i < j ) {
            if ( s.charAt ( i ) != s.charAt ( j ) ) {
                return false;
            }
            ++i;
            --j;
        }

        return true;
    }

}
