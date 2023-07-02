import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumInSubarraysK {

    public static List<Integer> maximum ( List<Integer> list, int k ) {
        List<Integer> output = new ArrayList<> ( list.size() - k + 1 );
        Deque<Integer> maxNumbers = new LinkedList<> ();

        int i = 0;
        int j = 0;

        while ( j < list.size () ) {
            while ( !maxNumbers.isEmpty () && 
                        maxNumbers.peekLast () < list.get ( j ) ) {
                maxNumbers.pollLast ();
            }

            maxNumbers.addLast ( list.get ( j ) );

            if ( ( j - i + 1 ) < k ) {
                ++j;
            } else if ( ( j - i + 1 ) == k ) {
                output.add ( maxNumbers.peekFirst () );
                if ( maxNumbers.peekFirst () == list.get ( i ) ) {
                    maxNumbers.pollFirst ();
                }
                ++i;
                ++j;
            }
        }

        return output;
    }
}
