import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInteger {

    public static List<Integer> firstNegative ( List<Integer> list, int k ) {

        int i = 0;
        int j = 0;

        List<Integer> output = new ArrayList<> ( k );
        Queue<Integer> negatives = new LinkedList<> ();

        while ( j < list.size () ) {

            if ( list.get ( j ) < 0 ) {
                negatives.add ( list.get ( j ) );
            }

            if ( ( j - i + 1 ) < k ) {
                ++j;
            } else if ( ( j - i + 1 ) == k ) {
                if ( negatives.isEmpty () ) {
                    output.add ( 0 );
                } else {
                    output.add ( negatives.peek () );
                    if ( list.get ( i ) == negatives.peek () ) {
                        negatives.poll ();
                    }
                }
                ++i;
                ++j;
            }
        }

        return output;
    }
}
