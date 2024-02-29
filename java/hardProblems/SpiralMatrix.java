import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {

    public static void print () {
        int [ ] [ ] arr = new int [ ][ ] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        System.out.println ( aggregateSpirally ( arr ) );
    }

    private static List<Integer> aggregateSpirally ( int [][] arr ) {
        int direction = 0;

        int topRow = 0;
        int bottomRow = arr.length - 1;

        int leftColumn = 0;
        int rightColumn = arr [ 0 ].length - 1;

        List<Integer> result = new ArrayList<> ();

        printMatrix ( arr );

        while ( topRow <= bottomRow && leftColumn <= rightColumn ) {

            switch ( direction ) {

                case 0:
                    for ( int i = leftColumn; i <= rightColumn; ++i ) {
                        result.add ( arr [ topRow ][ i ] );
                    }
                    ++topRow;
                    break;

                case 1:
                    for ( int i = topRow; i <= bottomRow; ++i ) {
                        result.add ( arr [ i ][ rightColumn ] );
                    }
                    --rightColumn;
                    break;

                case 2:
                    for ( int i = rightColumn; i >= leftColumn; --i ) {
                        result.add ( arr [ bottomRow ][ i ] );
                    }
                    --bottomRow;
                    break;

                case 3:
                    for ( int i = bottomRow; i >= topRow; --i ) {
                        result.add ( arr [ i ][ leftColumn ] );
                    }
                    ++leftColumn;
                    break;

            }

            direction = ( direction + 1 ) % 4;
        }

        return result;
    }

    private static void printMatrix ( int [][] arr ) {
        for ( int i = 0; i < arr.length; ++i ) {
            for ( int j = 0; j < arr [ i ].length; ++j ) {
                System.out.print ( arr [ i ][ j ] + " " );
            }
            System.out.println ();
        }
    }
}
