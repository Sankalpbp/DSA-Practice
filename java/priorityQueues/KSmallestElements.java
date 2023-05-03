import java.util.Collections;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class KSmallestElements {

    public List<Integer> kSmallestElements ( List<Integer> list, int k ) {

        if ( k > list.size () ) {
            return new ArrayList<> ( 0 );
        }

        List<Integer> output = new ArrayList<> ( k );

        PriorityQueue<Integer> maxHeap = new PriorityQueue<> ( Collections.reverseOrder () );

        list.stream ()
            .limit ( k )
            .forEach ( maxHeap :: add );

        for ( int i = k; i < list.size (); ++i ) {
            maxHeap.add ( list.get ( i ) );
            maxHeap.poll ();
        }

        output.addAll ( maxHeap );

        return output;
    }
}
