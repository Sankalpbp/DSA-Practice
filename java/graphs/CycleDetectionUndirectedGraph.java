import java.util.LinkedList;

public class CycleDetectionUndirectedGraph {

    public static void print ( ) {
        LinkedList<Integer> [] graph = Graphs.cycle ();

        if ( cycleFound ( graph ) ) {
            System.out.println ( "The given Undirected graph is cyclic" );
        } else {
            System.out.println ( "The given Undirected graph is acyclic" );
        }

        if ( cycleFound ( Graphs.acyclic () ) ) {
            System.out.println ( "The given Undirected graph is cyclic" );
        } else {
            System.out.println ( "The given Undirected graph is acyclic" );
        }
    }

    private static boolean cycleFound ( LinkedList<Integer> [] graph ) {
        boolean [] visited = new boolean [ graph.length ];

        // assuming there is only one connected component in the graph
        return cycleFound ( graph, visited, 0, -1 );
    }

    private static boolean cycleFound ( LinkedList<Integer> [] graph, boolean [] visited, int source, int parent ) {
        visited [ source ] = true;

        boolean found = false;

        for ( int neighbor : graph [ source ] ) {
            if ( ( visited [ neighbor ] && parent != neighbor ) 
                 || ( !visited [ neighbor ] && cycleFound ( graph, visited, neighbor, source ) ) ) {
                return true;
            }
        }

        return false;
    }
}
