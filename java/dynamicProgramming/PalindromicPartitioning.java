import java.util.Arrays;

public class PalindromicPartitioning {

    public static int partitionsMemo ( String s ) {
        int [][] memo = new int [ s.length () + 1 ][ s.length () + 1 ];
        for ( int i = 0; i <= s.length (); ++i ) {
            Arrays.fill ( memo [ i ], -1 );
        }
        return partitionsMemo ( s, 0, s.length () - 1, memo );
    }

    private static int partitionsMemo ( String s, int i, int j, int [][] memo ) {
        if ( i >= j || isPalindrome ( s, i, j ) ) {
            memo [ i ][ j ] = 0;
            return 0;
        }

        int answer = Integer.MAX_VALUE;

        for ( int k = i; k < j; ++k ) {
            int leftAnswer = partitionsMemo ( s, i, k, memo );
            int rightAnswer = partitionsMemo ( s, k + 1, j, memo );

            int temporaryAnswer = leftAnswer + 1 + rightAnswer;

            answer = Math.min ( answer, temporaryAnswer );
        }

        memo [ i ][ j ] = answer;
        return answer;
    }

    public static int partitions ( String s ) {
        return partitions ( s, 0, s.length () - 1 );
    }

    private static int partitions ( String s, int i, int j ) {
        if ( i >= j || isPalindrome ( s, i, j ) ) {
            return 0;
        }

        int answer = Integer.MAX_VALUE;

        for ( int k = i; k < j; ++k ) {
            int leftAnswer = partitions ( s, i, k );
            int rightAnswer = partitions ( s, k + 1, j );

            int temporaryAnswer = leftAnswer + 1 + rightAnswer;

            answer = Math.min ( answer, temporaryAnswer );
        }

        return answer;
    }

    private static boolean isPalindrome ( String s, int i, int j ) {
        while ( i < j ) {
            if ( s.charAt ( i ) == s.charAt ( j ) ) {
                ++i;
                --j;
            } else {
                return false;
            }
        }

        return true;
    }
}
