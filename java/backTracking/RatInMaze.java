public class RatInMaze {

    public static void print ( int [][] matrix ) {
        int [][] solution = new int [ matrix.length ][ matrix[ 0 ].length ];
        findDestination ( matrix, 0, 0, matrix.length - 1, matrix [ 0 ].length - 1, solution );
    }

    private static void findDestination ( int [][] matrix, int startX, int startY, int endX, int endY, int [][] solution ) {
        if ( startX == endX && startY == endY ) {
            if ( matrix [ startX ][ startY ] == 1 ) {
                solution [ startX ][ startY ] = 1;
                printMatrix ( solution );
                solution [ startX ][ startY ] = 0;
            }
            return;
        }

        if ( isBeyondBoundaries ( startX, startY, endX, endY ) 
             || !isValidCell ( matrix, startX, startY, solution ) ) {
            return;
        }

        solution [ startX ][ startY ] = 1;

        findDestination ( matrix, startX + 1, startY, endX, endY, solution );
        findDestination ( matrix, startX, startY + 1, endX, endY, solution );
        findDestination ( matrix, startX - 1, startY, endX, endY, solution );
        findDestination ( matrix, startX, startY - 1, endX, endY, solution );

        solution [ startX ][ startY ] = 0;
    }

    private static boolean isValidCell ( int [][] matrix, int startX, int startY, int [][] solution ) {
        if ( matrix [ startX ][ startY ] == 1 && solution [ startX ][ startY ] == 0 ) {
            return true;
        }
        return false;
    }

    private static boolean isBeyondBoundaries ( int startX, int startY, int endX, int endY ) {
        if ( startX > endX || endX > endY || startX < 0 || startY < 0 ) {
            return true;
        }
        return false;
    }

    private static void printMatrix ( int [][] matrix ) {
        for ( int i = 0; i < matrix.length; ++i ) {
            for ( int j = 0; j < matrix [ 0 ].length; ++j ) {
                System.out.print ( matrix [ i ][ j ] );
            }
            System.out.println ();
        }
        System.out.println ();
    }
}
