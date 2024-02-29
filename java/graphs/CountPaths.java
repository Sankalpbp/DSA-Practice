import java.util.LinkedList;

public class CountPaths {

    public static void print ( ) {
        LinkedList<Integer> [] graph = Graphs.buildUnweightedGraphAdjList ();
        System.out.println ( "Number of paths from 1 to 6 are: " + countPaths ( graph, 1, 6 ) );

        LinkedList<Integer> [] graph2 = Graphs.buildDAGAdjList ();
        System.out.println ( "Number of paths from 2 to 1 are: " + countPaths ( graph2, 2, 1 ) );

        LinkedList<Integer> [] graph3 = Graphs.buildUnweightedComplexGraphAdjList ();
        System.out.println ( "Number of paths from 1 to 6 are: " + countPaths ( graph3, 1, 6 ) );
    }

    private static int countPaths ( LinkedList<Integer> [] graph, int source, int destination ) {
        boolean [] visited = new boolean [ graph.length ];
        return countPaths ( graph, source, destination, visited );
    }

    private static int countPaths ( LinkedList<Integer> [] graph, int source, int destination, boolean [] visited ) {
        if ( source == destination ) {
            visited [ source ] = false;
            return 1;
        }

        visited [ source ] = true;
        int count = 0;
        
        for ( int x : graph [ source ] ) {
            if ( !visited [ x ] ) {
                count += countPaths ( graph, x, destination, visited );
            }
        }

        visited [ source ] = false;

        return count;
    }
}
