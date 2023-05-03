import java.util.PriorityQueue;
import java.util.Collections;

public class KThSmallest {

    public int kThSmallest ( int [ ] arr, int k ) {

        if ( k > arr.length ) {
            return Integer.MAX_VALUE;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<> ( Collections.reverseOrder () );

        for ( int i = 0; i < k; ++i ) {
            maxHeap.add ( arr [ i ] );
        }

        for ( int i = k; i < arr.length; ++i ) {
            maxHeap.add ( arr [ i ] );
            maxHeap.poll ();
        }

        return maxHeap.peek ();
    }
}
