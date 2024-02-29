import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class UnweightedShortestPath {

    public static void print ( ) {
        LinkedList<Integer> [] graph = Graphs.buildUnweightedGraphAdjList ();
        System.out.println ( "Shortest distance between 0 nd 5 is: " + calculateShortestDistance ( graph, 0, 5 ) );
        System.out.println ( "Shortest distance between 2 nd 6 is: " + calculateShortestDistance ( graph, 2, 6 ) );
        System.out.println ( "Shortest distance between 1 nd 6 is: " + calculateShortestDistance ( graph, 1, 6 ) );
    }

    private static int calculateShortestDistance ( LinkedList<Integer> [] graph, int source, int destination ) {
        Queue<Integer> pendingNodes = new ArrayDeque<> ();
        boolean [] visited = new boolean [ graph.length ];

        pendingNodes.offer ( source );

        int [] level = new int [ graph.length ];
        Arrays.fill ( level, -1 );
        level [ source ] = 0;
        int current = -1;

        while ( !pendingNodes.isEmpty () ) {
            current = pendingNodes.poll ();
            visited [ current ] = true;

            for ( int neighbor : graph [ current ] ) {
                if ( !visited [ neighbor ] ) {
                    if ( level [ neighbor ] == -1 ) {
                        level [ neighbor ] = level [ current ] + 1;
                        if ( neighbor == destination ) {
                            break;
                        }
                    }
                    pendingNodes.offer ( neighbor );
                }
            }
        }
        
        return level [ destination ];
    }
}
