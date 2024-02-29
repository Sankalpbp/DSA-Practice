import java.util.PriorityQueue;

public class MergeFiles {

    public static void print () {
        System.out.println ( "Merging files efficiently would require " + mergeFiles ( 10, 5, 100, 50, 20, 15 ) + " number of operations." );
    }

    private static int mergeFiles ( int... fileLengths ) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<> ();

        for ( int x : fileLengths ) {
            minHeap.add ( x );
        }

        int shortest = Integer.MAX_VALUE;
        int secondShortest = Integer.MAX_VALUE;

        while ( minHeap.size () > 1 ) {
            shortest = minHeap.poll ();
            secondShortest = minHeap.poll ();

            minHeap.add ( shortest + secondShortest );
        }

        return minHeap.poll ();
    }
}
