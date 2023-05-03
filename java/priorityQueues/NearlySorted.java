import java.util.List;
import java.util.PriorityQueue;

public class NearlySorted {

    public void sort ( List<Integer> list, int k ) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<> ( list.subList ( 0, k + 1 ) );

        int i = 0;
        for ( i = k + 1; i < list.size (); ++i ) {
            list.set ( i - ( k + 1 ), minHeap.poll ( ) );
            minHeap.add ( list.get ( i ) );
        }

        while ( !minHeap.isEmpty () ) {
            list.set ( i - ( k + 1 ), minHeap.poll () );
            ++i;
        }

    }
}
