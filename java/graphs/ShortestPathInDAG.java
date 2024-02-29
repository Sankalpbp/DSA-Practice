import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ShortestPathInDAG {

    public static void print () {
        LinkedList<Integer> [] graph = Graphs.buildDeepDAG ();
        System.out.println ( findShortestPaths ( graph, 0 ) );
    }

    private static List<Integer> findShortestPaths ( LinkedList<Integer> [] graph, int source ) {
        boolean [] visited = new boolean [ graph.length ];
        List<Integer> shortestPaths = new ArrayList<Integer> ( Collections.nCopies ( graph.length, Integer.MAX_VALUE ) );
        Queue<Integer> pendingNodes = new ArrayDeque<> ();

        pendingNodes.offer ( source );
        shortestPaths.set ( 0, 0 );

        int parent;

        while ( !pendingNodes.isEmpty () ) {
            parent = pendingNodes.poll ();
            visited [ parent ] = true;

            for ( int neighbor : graph [ parent ] ) {
                if ( !visited [ neighbor ] ) {
                    shortestPaths.set ( neighbor, Math.min ( shortestPaths.get ( neighbor ), shortestPaths.get ( parent ) + 1 ) );
                    pendingNodes.offer ( neighbor );
                }
            }
        }

        return shortestPaths;
    }
}
