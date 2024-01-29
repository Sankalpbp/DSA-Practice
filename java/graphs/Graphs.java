import java.util.LinkedList;

public class Graphs {

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

}
