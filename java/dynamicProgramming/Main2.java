import java.util.Arrays;

public class Main2 {

    public static void main ( String... args ) {
        System.out.println ( SubsetSum.isPossible ( Arrays.asList ( 3, 34, 4, 12, 5, 2 ), 9 ) );
        System.out.println ( SubsetSum.isPossible ( Arrays.asList ( 3, 34, 4, 12, 5, 2 ), 13 ) );

        System.out.println ( SubsetSum.isPossibleMemo ( Arrays.asList ( 3, 34, 4, 12, 5, 2 ), 9 ) );
        System.out.println ( SubsetSum.isPossibleMemo ( Arrays.asList ( 3, 34, 4, 12, 5, 2 ), 13 ) );

        System.out.println ( SubsetSum.isPossibleDP ( Arrays.asList ( 3, 34, 4, 12, 5, 2 ), 9 ) );
        System.out.println ( SubsetSum.isPossibleDP ( Arrays.asList ( 3, 34, 4, 12, 5, 2 ), 13 ) );

        System.out.println ( EqualSumPartition.partition ( Arrays.asList ( 1, 5, 11, 5 ) ) );

        System.out.println ( CountSubsetSum.count2 ( Arrays.asList ( 1, 2, 3, 3 ), 6 ) );
        System.out.println ( CountSubsetSum.count2 ( Arrays.asList ( 1, 1, 1, 1 ), 1 ) );

        System.out.println ( MinimumSubsetDifference.minimum ( Arrays.asList ( 1, 6, 11, 5 ) ) );

        System.out.println ( BooleanParenthesization.ways ( "T^F&T" ) );
        System.out.println ( BooleanParenthesization.waysMemoized ( "T^F&T" ) );
    }
}
