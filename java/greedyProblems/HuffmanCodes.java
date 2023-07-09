import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class HuffmanCodes {

    public static List<String> getCodes ( String s, List<Integer> frequencies ) {
        PriorityQueue<Node> minHeap = new PriorityQueue<> ();

        frequencies.stream ()
                   .limit ( frequencies.size () )
                   .forEach ( ( frequency ) -> {
                       minHeap.add ( new Node ( frequency ) );
                   } );

        Node left = null;
        Node right = null;

        while ( minHeap.size () > 1 ) {
            left = minHeap.poll ();
            right = minHeap.poll ();

            Node parent = new Node ( left.frequency + right.frequency, left, right );
            minHeap.add ( parent );
        }

        Node root = minHeap.poll ();
        List<String> output = new ArrayList<> ();
        traverseTree ( output, root, "" );

        return output;
    }

    private static void traverseTree ( List<String> output, Node root, String current ) {
        // when we hit a leaf, that's our answer
        if ( root.left == null && root.right == null ) {
            output.add ( current );
            return;
        }

        traverseTree ( output, root.left, current + "0" );
        traverseTree ( output, root.right, current + "1" );
    }

    private static class Node implements Comparable<Node> {
        public int frequency;
        public Node left;
        public Node right;

        public Node ( int frequency ) {
            this.frequency = frequency;
        }

        public Node ( int frequency, Node left, Node right ) {
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo ( Node other ) {
            return ( this.frequency == other.frequency )
                   ? 0
                   : ( ( this.frequency > other.frequency ) 
                       ? 1
                       : -1 );
        }
    }
}
