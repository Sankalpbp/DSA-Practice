import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KLargestElements {

    public List<Integer> kLargestElements ( List<Integer> list, int k ) {

        if ( k > list.size () ) {
            return new ArrayList<> ( 0 );
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<> ( list.subList ( 0, k ) );

        IntStream.range ( k, list.size () )
                 .mapToObj ( list :: get )
                 .forEach ( e -> {
                     minHeap.add ( e );
                     minHeap.poll ();
                 } );

        return new ArrayList<> ( minHeap );
    }
}
