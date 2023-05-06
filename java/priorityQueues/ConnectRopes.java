import java.util.List;
import java.util.PriorityQueue;

public class ConnectRopes {

    public int minCost ( List<Integer> lengths ) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<> ( lengths );

        int smallest = 0;
        int secondSmallest = 0;

        int cost = 0;

        while ( minHeap.size () > 1 ) {
            smallest = minHeap.poll ();
            secondSmallest = minHeap.poll ();

            cost += ( smallest + secondSmallest );

            minHeap.add ( cost );
        }

        return minHeap.poll ();
    }
}
