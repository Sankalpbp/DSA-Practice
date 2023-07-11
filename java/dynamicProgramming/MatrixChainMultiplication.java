import java.util.List;
import java.util.Arrays;

public class MatrixChainMultiplication {

    public static int solveMemo ( List<Integer> dimensions ) {
        int [][] memo = new int [ dimensions.size () + 1 ][ dimensions.size () + 1 ];
        for ( int i = 0; i <= dimensions.size (); ++i ) {
            Arrays.fill ( memo [ i ], -1 );
        }
        return solveMemo ( dimensions, 1, dimensions.size () - 1, memo );
    }

    private static int solveMemo ( List<Integer> dimensions, int i, int j, int [][] memo ) {
        if ( i >= j ) {
            return 0;
        }

        if ( memo [ i ][ j ] != -1 ) {
            return memo [ i ][ j ];
        }

        int minimum = Integer.MAX_VALUE;

        for ( int k = i; k < j; ++k ) {
            int leftAnswer = solveMemo ( dimensions, i, k, memo );
            int rightAnswer = solveMemo ( dimensions, k + 1, j, memo );

            int temporaryAnswer = leftAnswer + dimensions.get ( i - 1 ) * dimensions.get ( k ) * dimensions.get ( j ) + rightAnswer;
            minimum = Math.min ( minimum, temporaryAnswer );
        }

        memo [ i ][ j ] = minimum;
        return minimum;
    }

    public static int solveRecursive ( List<Integer> dimensions ) {
        return solveRecursive ( dimensions, 1, dimensions.size () - 1 );
    }

    private static int solveRecursive ( List<Integer> dimensions, int i, int j ) {
        if ( i >= j ) {
            return 0;
        }

        int minimum = Integer.MAX_VALUE;

        for ( int k = i; k < j; ++k ) {
            int leftAnswer = solveRecursive ( dimensions, i, k );
            int rightAnswer = solveRecursive ( dimensions, k + 1, j );

            int temporaryAnswer = leftAnswer + dimensions.get ( i - 1 ) * dimensions.get ( k ) * dimensions.get ( j ) + rightAnswer;
            minimum = Math.min ( minimum, temporaryAnswer );
        }

        return minimum;
    }
}
