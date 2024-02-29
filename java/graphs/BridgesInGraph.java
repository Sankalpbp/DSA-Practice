import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class BridgesInGraph {

    public static void print () {
        LinkedList<Integer> [] graph = Graphs.buildForBridges ();
        System.out.println ( findBridges ( graph ) );
    }

    private static void dfs ( LinkedList<Integer> [] graph, int parent, int timer, int [] timeIn, int [] low, int source, boolean [] visited, List<List<Integer> > result ) {
        visited [ source ] = true;
        timeIn [ source ] = timer;
        low [ source ] = timer;
        ++timer;

        for ( int neighbor : graph [ source ] ) {
            if ( neighbor == parent ) {
                continue;
            } else if ( !visited [ neighbor ] ) {
                dfs ( graph, source, timer, timeIn, low, neighbor, visited, result );
                low [ source ] = Math.min ( low [ source ], low [ neighbor ] );
                if ( low [ neighbor ] > timeIn [ source ] ) {
                    result.add ( List.of ( neighbor, source ) );
                }
            } else {
                // Back Edge
                low [ source ] = Math.min ( low [ source ], timeIn [ neighbor ] );
            }
        }
    }

    private static List<List<Integer>> findBridges ( LinkedList<Integer> [] graph ) {
        boolean [] visited = new boolean [ graph.length ];
        int [] low = new int [ graph.length ];
        int [] timeIn = new int [ graph.length ];

        Arrays.fill ( low, -1 );
        Arrays.fill ( timeIn, -1 );

        int parent = -1;
        int timer = 0;

        List<List<Integer> > result = new ArrayList<> ();
        dfs ( graph, parent, timer, timeIn, low, 0, visited, result );

        return result;
    }
}
