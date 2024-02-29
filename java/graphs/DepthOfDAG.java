import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class DepthOfDAG {

    public static void print () {
        LinkedList<Integer> [] graph = Graphs.buildDeepDAG ();
        System.out.println ( "Depth of given graph is: " + calculateDepth ( graph ) );
    }

    private static int calculateDepth ( LinkedList<Integer> [] graph ) {
        Queue<Integer> pendingNodes = new ArrayDeque<> ();
        boolean [] visited = new boolean [ graph.length ];
        int [] levels = new int [ graph.length ];

        pendingNodes.offer ( 0 );
        levels [ 0 ] = 0;

        int maxDepth = 0;
        int parent;
        
        while ( !pendingNodes.isEmpty () ) {
            parent = pendingNodes.poll ();
            visited [ parent ] = true;

            for ( int neighbor : graph [ parent ] ) {
                levels [ neighbor ] = levels [ parent ] + 1;
                maxDepth = Math.max ( maxDepth, levels [ neighbor ] );
                if ( !visited [ neighbor ] ) {
                    pendingNodes.offer ( neighbor );
                }
            }
        }

        return maxDepth;
    }
}
