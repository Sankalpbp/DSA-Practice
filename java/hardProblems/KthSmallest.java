import java.util.PriorityQueue;
import java.util.Collections;

public class KthSmallest {

    public static void print () {
        int [] arr = new int [ ] { 3, 2, 1, 10, 9, 6, 4 };
        System.out.println ( kthSmallest ( arr, 3 ) );
    }

    private static int kthSmallest ( int [] arr, int k ) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<> ( ( x, y ) -> {
            return -1 * Integer.compare ( x, y );
        });

        for ( int i = 0; i < k; ++i ) {
            maxHeap.add ( arr [ i ] );
        }

        for ( int i = k; i < arr.length; ++i ) {
            maxHeap.add ( arr [ i ] );
            maxHeap.poll ( );
        }

        return maxHeap.peek ();
    }
}
