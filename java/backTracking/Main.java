import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main ( String... args ) {
        Permutations.print ( "abc" );
        LargestNumberKSwaps.print ( 254, 2 );
        NDigitNumbers.print ( 2 );

        WordBreak.print ( "leetcode", Arrays.asList ( "leet", "code" ) );
        WordBreak.print ( "bb", Arrays.asList ( "b", "bbb", "bbbb" ) );
        WordBreak.print ( "catsandog", Arrays.asList ( "cat", "sand", "dog", "and", "cats" ) );

        PalindromePartitioning.print ( "aab" );

        CombinationSum.print ( Arrays.asList ( 2, 3, 6, 7 ), 7 );
        CombinationSum.print ( Arrays.asList ( 10, 2, 3 ), 5 );

        NQueen.print ( 4 );

        int [][] matrix = { { 1, 0, 0, 0 },
                            { 1, 1, 0, 1 },
                            { 1, 1, 0, 0 },
                            { 0, 1, 1, 1 } };
        RatInMaze.print ( matrix );

        int [][] sudoku = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                            {5, 2, 0, 0, 0, 0, 0, 0, 0},
                            {0, 8, 7, 0, 0, 0, 0, 3, 1},
                            {0, 0, 3, 0, 1, 0, 0, 8, 0},
                            {9, 0, 0, 8, 6, 3, 0, 0, 5},
                            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                            {1, 3, 0, 0, 0, 0, 2, 5, 0},
                            {0, 0, 0, 0, 0, 0, 0, 7, 4},
                            {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        Sudoku.print ( sudoku );

        PhoneLetterDigits.print ( 23 );
    }

}
