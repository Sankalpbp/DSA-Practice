import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class CountConnectedComponents {

    public static void print ( ) {
        LinkedList<Integer> [] graph = Graphs.buildLargeDisconnectedGraph ();
        System.out.println ( "Number of connected components in the given graph using DFS are: " + 
                                                calculateConnectedComponents ( graph, "DFS" ) );
        System.out.println ( "Number of connected components in the given graph using BFS are: " + 
                                                calculateConnectedComponents ( graph, "BFS" ) );
    }

    private static int calculateConnectedComponents ( LinkedList<Integer> [] graph, String algorithm ) {
        boolean [] visited = new boolean [ graph.length ];
        int count = 0;

        for ( int i = 0; i < graph.length; ++i ) {
            if ( !visited [ i ] ) {
                ++count;
                if ( algorithm.equals ( "DFS" ) ) {
                    dfs ( graph, visited, i );
                } else { 
                    bfs ( graph, visited, i );
                }
            }
        }

        return count;
    }

    private static void bfs ( LinkedList<Integer> [] graph, boolean [] visited, int source ) {
        Queue<Integer> pendingNodes = new ArrayDeque<> ();
        pendingNodes.offer ( source );

        int current = -1;

        while ( !pendingNodes.isEmpty () ) {
            current = pendingNodes.poll ();
            visited [ current ] = true;

            for ( int x : graph [ current ] ) {
                if ( !visited [ x ] ) {
                    pendingNodes.offer ( x );
                }
            }
        }
    }

    private static void dfs ( LinkedList<Integer> [] graph, boolean [] visited, int source ) {
        visited [ source ] = true;

        for ( int neighbor : graph [ source ] ) {
            if ( !visited [ neighbor ] ) {
                dfs ( graph, visited, neighbor );
            }
        }
    }

}
