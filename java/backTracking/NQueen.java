import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class NQueen {

    private static void printResult ( List<List<List<Integer> > > result ) {
        System.out.println ( "Number of solutions: " + result.size () );
        for ( int i = 0; i < result.size (); ++i ) {
            result.get ( i ).forEach ( x -> System.out.println ( x ) );
            System.out.println ();
        }
    }

    public static void print ( int n ) {
        List<List<List<Integer>>> result = new ArrayList<> ();

        List<List<Integer>> board = new ArrayList<> ( n );
        for ( int x = 0; x < n; ++x ) {
            List<Integer> innerList = new ArrayList<> ( n );
            for ( int y = 0; y < n; ++y ) {
                innerList.add ( 0 );
            }
            board.add ( innerList );
        }

        nqueen ( n, 0, result, board );
        
        printResult ( result );
    }

    private static void nqueen ( int rows, int row, List<List<List<Integer>>> result, List<List<Integer>> board ) {
        if ( row == rows ) {
            result.add (
                board.stream ()
                     .map ( ArrayList :: new )
                     .collect ( Collectors.toList () )
            );
            return;
        }

        int columns = rows;

        for ( int i = 0; i < columns; ++i ) {
            if ( isSafeToPut ( board, row, i ) ) {
                board.get ( row ).set ( i, 1 );
                nqueen ( rows, row + 1, result, board );
                board.get ( row ).set ( i, 0 );
            }
        }
    }

    private static boolean isSafeToPut ( List<List<Integer>> board, int row, int column ) {
        return isUpperPartOfColumnEmpty ( board, row, column ) 
                 && isLeftDiagonalEmpty ( board, row, column ) 
                 && isRightDiagonalEmpty ( board, row, column );
    }

    private static boolean isRightDiagonalEmpty ( List<List<Integer>> board, int row, int column ) {
        for ( int i = row - 1, j = column + 1; i >= 0 && j < board.get ( 0 ).size (); ) {
            if ( board.get ( i ).get ( j ) == 1 ) {
                return false;
            }
            --i;
            ++j;
        }

        return true;
    }

    private static boolean isLeftDiagonalEmpty ( List<List<Integer>> board, int row, int column ) {
        for ( int i = row - 1, j = column - 1; i >= 0 && j >= 0; ) {
            if ( board.get ( i ).get ( j ) == 1 ) {
                return false;
            }
            --i;
            --j;
        }

        return true;
    }

    private static boolean isUpperPartOfColumnEmpty ( List<List<Integer>> board, int row, int column ) {
        for ( int i = 0; i < row; ++i ) {
            if ( board.get ( i ).get ( column ) == 1 ) {
                return false;
            }
        }

        return true;
    }
}
