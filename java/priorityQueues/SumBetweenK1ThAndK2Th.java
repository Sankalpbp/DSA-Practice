import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;

public class SumBetweenK1ThAndK2Th {

    private int kthSmallest ( List<Integer> list, int k ) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<> ( Collections.reverseOrder () );
        
        for ( int i = 0; i < k; ++i ) {
            maxHeap.add ( list.get ( i ) );
        }

        for ( int i = k; i < list.size (); ++i ) {
            maxHeap.add ( list.get ( i ) );
            maxHeap.poll ();
        }

        return maxHeap.peek ();
    }

    public int sum ( int k1, int k2, List<Integer> list ) {

        int k1thSmallestElement = kthSmallest ( list, k1 );
        int k2thSmallestElement = kthSmallest ( list, k2 );

        int sum = 0;

        for ( int x : list ) {
            if ( x > k1thSmallestElement && x < k2thSmallestElement ) {
                System.out.println ( "between: " + k1thSmallestElement + " and " + k2thSmallestElement + " = " + x );
                sum += x;
            }
        }

        return sum;
    }
}
