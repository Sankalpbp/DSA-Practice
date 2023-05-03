import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class NearlySorted {

    public void sort ( List<Integer> list, int k ) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<> ( list.subList ( 0, k + 1 ) );

        IntStream.range ( ( k + 1 ), list.size () )
                 .forEach ( i -> {
                     list.set ( i - ( k + 1 ), minHeap.poll () );
                     minHeap.add ( list.get ( i ) );
                 } );

        IntStream.range ( list.size () - ( k + 1 ), list.size () )
                 .forEach ( i -> list.set ( i, minHeap.poll () ) );

    }
}
