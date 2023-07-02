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

        System.out.println ( MaximumInSubarraysK.maximum ( Arrays.asList ( 1, 3, -1, -3, 5, 3, 6, 7 ), 3 ) );

        System.out.println ( LongestSizeSlidingWindow.longest ( Arrays.asList ( 4, 1, 1, 1, 2, 3, 5 ), 5 ) );

        System.out.println ( LongestSubstringWithUniqueCharacters.longestSubstring ( "aabacbebebe", 3 ) );

        System.out.println ( LongestSubstringWithNoRepeatingCharacters.longestSubstring ( "pwwkew" ) );

        System.out.println ( PickToys.maxToys ( "14311122112123433334434" ) );

        System.out.println ( MinimumWindowSubstring.minimumSubstring ( "timetopractice", "toc" ) );
    }
}
