import java.util.Arrays;

public class Main {

    public static void main ( String... args ) {

        int [ ] arr = { 2, 5, 1, 8, 2, 9, 1 };
        System.out.println ( MaximumSumSubarray.maximumSumSubarray ( arr, 3 ) );
        System.out.println ( CountOccurrencesOfAnagrams.count ( "aabaabaa", "aaba" ) );
        System.out.println ( CountOccurrencesOfAnagrams.count ( "forxxrofxfoxorf", "for" ) );

        System.out.println ( FirstNegativeInteger.firstNegative ( 
                                Arrays.asList ( 12, -1, -7, 8, -16, 30, 16, 28 ), 
                                3 ) );
    }
}
