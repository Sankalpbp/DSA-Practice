public class PalindromicPartitioning {

    public static int partitions ( String s ) {
        return partitions ( s, 0, s.length () - 1 );
    }

    private static int partitions ( String s, int i, int j ) {
        if ( i >= j ) {
            return 0;
        }

        if ( isPalindrome ( s, i, j ) ) {
            return 0;
        }

        int answer = Integer.MAX_VALUE;

        for ( int k = i; k < j; ++k ) {
            int leftAnswer = partitions ( s, i, k );
            int rightAnswer = partitions ( s, k + 1, j );

            int temporaryAnswer = leftAnswer + 1 + rightAnswer;

            answer = Math.min ( answer, temporaryAnswer );
        }

        System.out.println ( "i: " + i + " j: " + j + "answer: " + answer );
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

    private static int clean ( int x ) {
        return ( x == Integer.MAX_VALUE ) ? 0 : x;
    }
}
