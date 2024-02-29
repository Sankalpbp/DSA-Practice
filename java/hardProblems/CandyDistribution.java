import java.util.stream.IntStream;

public class CandyDistribution {

    public static void print () {
        int [] studentRatings = new int [ ] { 1, 0, 2 };
        System.out.println ( calculateMinimumCandies ( studentRatings ) );
    }

    private static int calculateMinimumCandies ( int [] studentRatings ) {
        int [] candiesToStudents = new int [ studentRatings.length ];
        for ( int i = 0; i < studentRatings.length; ++i ) {
            candiesToStudents [ i ] = 1;
        }

        for ( int i = 0; i < studentRatings.length; ++i ) {
            if ( i - 1 >= 0 && 
                 studentRatings [ i - 1 ] < studentRatings [ i ] &&
                 candiesToStudents [ i ] <= candiesToStudents [ i - 1 ] ) {
                System.out.println ( "found greater, but lesser to the left" );
                candiesToStudents [ i ] = candiesToStudents [ i - 1 ] + 1;
            }

            if ( i + 1 < studentRatings.length && 
                 studentRatings [ i + 1 ] < studentRatings [ i ] && 
                 candiesToStudents [ i ] <= candiesToStudents [ i + 1 ] ) {
                System.out.println ( "found greater, but lesser to the right" );
                candiesToStudents [ i ] = candiesToStudents [ i + 1 ] + 1;
            }
        }

        IntStream.range ( 0, candiesToStudents.length )
                 .forEach ( i -> System.out.println ( candiesToStudents [ i ] ) );

        return IntStream.range ( 0, candiesToStudents.length )
                        .map ( i -> candiesToStudents [ i ] )
                        .sum ();
    }
}
