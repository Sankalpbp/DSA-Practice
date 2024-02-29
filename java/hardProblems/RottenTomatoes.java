import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;

public class RottenTomatoes {

    public static void print () {

        int [][] basket = new int [][] {
            { 2, 1, 0, 2, 1 },
            { 1, 0, 1, 2, 1 },
            { 1, 0, 0, 2, 1 }
        };

        System.out.println ( calculateTimeToRot ( basket ) );
    }

    private static int calculateTimeToRot ( int [][] basket ) {
        Queue<Node> rottenOnes = new ArrayDeque<> ();
        for ( int i = 0; i < basket.length; ++i ) {
            for ( int j = 0; j < basket [ 0 ].length; ++j ) {
                if ( basket [ i ][ j ] == 2 ) {
                    rottenOnes.offer ( new Node ( 0, i, j ) );
                }
            }
        }

        Node current = null;
        int maxTime = 0;

        while ( !rottenOnes.isEmpty () ) {
            current = rottenOnes.poll ();
            processNeighbors ( current, basket, rottenOnes );
            maxTime = Math.max ( maxTime, current.time );
        }

        if ( foundOne ( basket ) ) {
            return -1;
        }

        return maxTime;
    }

    private static boolean foundOne ( int [][] basket ) {
        for ( int i = 0; i < basket.length; ++i ) {
            for ( int j = 0; j < basket [ i ].length; ++j ) {
                if ( basket [ i ][ j ] == 1 ) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void processNeighbors ( Node current, int [][] basket, Queue<Node> rottenOnes ) {
        int [][] pairs = new int [][] {
            { 0, 1 }, 
            { 1, 0 },
            { 0, -1 },
            { -1, 0 }
        };

        for ( int i = 0; i < pairs.length; ++i ) {
            processCell ( rottenOnes, current.x + pairs [ i ][ 0 ], current.y + pairs [ i ][ 1 ], basket, current.time );
        }
        /*
        processCell ( rottenOnes, current.x, current.y + 1, basket, current.time );
        processCell ( rottenOnes, current.x + 1, current.y, basket, current.time );
        processCell ( rottenOnes, current.x, current.y - 1, basket, current.time );
        processCell ( rottenOnes, current.x - 1, current.y, basket, current.time );
        */
    }

    private static void processCell ( Queue<Node> rottenOnes, int x, int y, int [][] basket, int time ) {
        if ( x >= 0 && y >= 0 && x < basket.length && y < basket [ 0 ].length && basket [ x ][ y ] == 1 ) {
            basket [ x ][ y ] = 2;
            rottenOnes.offer ( new Node ( time + 1, x, y ) );
        }
    }

    private static class Node {
        int time;
        int x;
        int y;

        public Node ( int time, int x, int y ) {
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }
}
