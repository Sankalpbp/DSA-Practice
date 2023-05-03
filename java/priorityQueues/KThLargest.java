import java.util.PriorityQueue;

public class KThLargest {
    
    public int kThLargest ( int [ ] arr, int k ) {

        if ( k > arr.length ) {
            return Integer.MIN_VALUE;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<> ();

        for ( int i = 0; i < k; ++i ) {
            minHeap.add ( arr [ i ] );
        }

        for ( int i = k; i < arr.length; ++i ) {
            minHeap.add ( arr [ i ] );
            minHeap.poll ();
        }

        return minHeap.peek ();

    }
}
