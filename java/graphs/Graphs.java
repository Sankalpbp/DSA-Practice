import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Graphs {

    public static LinkedList<Integer> [] buildDeepDAG () {
        return buildAdjacencyList ( true, 0, 1, 1, 2, 0, 3, 0, 2, 3, 4, 4, 5, 5, 3 );
    }

    public static LinkedList<Integer> [] buildForBridges () {
        return buildAdjacencyList ( false, 0, 1, 0, 2, 1, 2, 0, 4, 3, 4, 3, 5, 4, 5 );
    }

    public static LinkedList<Integer> [] buildLargeDisconnectedGraph ( ) {
        return buildAdjacencyList ( false, 0, 1, 1, 2, 3, 4, 5, 6, 5, 7, 6, 7 );
    }

    public static LinkedList<Integer> [] cycle () {
        return buildAdjacencyList ( false, 0, 1, 0, 2, 2, 3, 3, 4, 2, 4 );
    }

    public static LinkedList<Integer> [] acyclic () {
        return buildAdjacencyList ( false, 0, 1, 1, 2, 2, 3 );
    }

    public static LinkedList<Integer> [] directedCyclic () {
        return buildAdjacencyList ( true, 0, 1, 0, 2, 2, 3, 3, 4, 4, 2 );
    }

    public static LinkedList<Integer> [] directedAcyclic () {
        return buildAdjacencyList ( true, 0, 1, 0, 2, 2, 3, 3, 4, 2, 4 );
    }

    @SuppressWarnings ( "unchecked" )
    public static LinkedList<Integer> [] buildAdjacencyList ( boolean directed, int... edgePairs ) {
        if ( edgePairs.length % 2 != 0 ) {
            throw new RuntimeException ( "The edge pairs list is not generated correctly, odd number of elements present" );
        }

        int vertices = getCountOfUniqueNumber ( edgePairs );
        LinkedList<Integer> [] adjacencyList = new LinkedList [ vertices ];
        for ( int i = 0; i < vertices; ++i ) {
            adjacencyList [ i ] = new LinkedList<> ();
        }

        for ( int i = 0; i < edgePairs.length; i += 2 ) {
            adjacencyList [ edgePairs [ i ] ].add ( edgePairs [ i + 1 ] );
            if ( !directed ) {
                adjacencyList [ edgePairs [ i + 1 ] ].add ( edgePairs [ i ] );
            }
        }

        return adjacencyList;
    }

    public static LinkedList<Integer> [] buildUnweightedGraphAdjList ( ) {
        return buildAdjacencyList ( false, 0, 1, 0, 2, 1, 3, 1, 4, 3, 5, 4, 6, 5, 6 );
    }

    public static LinkedList<Integer> [] buildUnweightedComplexGraphAdjList ( ) {
        return buildAdjacencyList ( false, 0, 1, 0, 2, 1, 3, 1, 4, 3, 5, 4, 6, 5, 6, 3, 4 );
    }

    public static LinkedList<Integer> [] buildLCAGraph () {
        return buildAdjacencyList ( false, 0, 1, 1, 2, 2, 3, 2, 4, 1, 5, 5, 6, 6, 7, 4, 7 );
    }

    @SuppressWarnings ( "unchecked" )
    public static LinkedList<Integer> [] getAdjacencyList () {
        /* this is a bad practice to create a generic array, btw. Use Collections instead */
        LinkedList<Integer> [] adjacencyList = new LinkedList [ 4 ];
        for ( int i = 0; i < 4; ++i ) {
            adjacencyList [ i ] = new LinkedList<> ();
        }

        adjacencyList [ 0 ].add ( 1 );
        adjacencyList [ 2 ].add ( 3 );

        return adjacencyList;
    }

    public static int [][] getAdjacencyMatrix () {
        int [][] adjacencyMatrix = new int [ 4 ][ 4 ];
        adjacencyMatrix [ 0 ][ 1 ] = 1;
        adjacencyMatrix [ 2 ][ 3 ] = 1;

        return adjacencyMatrix;
    }

    public static int [][] buildDAG () {
        int [][] adjacencyMatrix = new int [ 4 ][ 4 ];

        adjacencyMatrix [ 0 ][ 1 ] = 1;
        adjacencyMatrix [ 1 ][ 2 ] = 1;
        adjacencyMatrix [ 0 ][ 2 ] = 1;
        adjacencyMatrix [ 0 ][ 3 ] = 1;
        adjacencyMatrix [ 2 ][ 3 ] = 1;

        return adjacencyMatrix;
    }

    @SuppressWarnings ( "unchecked" )
    public static LinkedList<Integer> [] buildDAGAdjList () {
        /* this is a bad practice to create a generic array, btw. Use Collections instead */
        LinkedList<Integer> [] adjacencyList = new LinkedList [ 4 ];
        for ( int i = 0; i < 4; ++i ) {
            adjacencyList [ i ] = new LinkedList<> ();
        }

        adjacencyList [ 0 ].add ( 1 );
        adjacencyList [ 1 ].add ( 2 );
        adjacencyList [ 0 ].add ( 2 );
        adjacencyList [ 0 ].add ( 3 );
        adjacencyList [ 2 ].add ( 3 );

        return adjacencyList;
    }

    private static int getCountOfUniqueNumber ( int... edgePairs ) {
        Set<Integer> uniqueElements = new HashSet<> ();
        for ( int x : edgePairs ) {
            uniqueElements.add ( x );
        }
        return uniqueElements.size ();
    }

}
