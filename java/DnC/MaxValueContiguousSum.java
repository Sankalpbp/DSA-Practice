public class MaxValueContiguousSum {

    public static void print () {
        System.out.println ( maxSum ( new int [] { -2, -3, 4, -1, -2, 1, 5, -3 } ) );
        System.out.println ( maxSum ( new int [] { 2, 3, 4, -1, -2, 1, -5, -3 } ) );
        System.out.println ( maxSum ( new int [] { -2, -3, -4, -1, -2, 1, 5, 3 } ) );
    }

    private static int maxSum ( int [] arr, int start, int end ) {
        if ( start > end ) {
            return 0;
        }

        if ( start == end ) {
            return ( arr [ start ] > 0 ) ? arr [ start ] : 0;
        }

        int mid = start + ( end - start ) / 2;

        int leftMaxSum = maxSum ( arr, start, mid );
        int rightMaxSum = maxSum ( arr, mid + 1, end );
        
        int leftSuffixSum = 0;
        int maxSuffixSum = 0;

        for ( int i = mid; i >= start; --i ) {
            leftSuffixSum += arr [ i ];
            if ( leftSuffixSum > maxSuffixSum ) {
                maxSuffixSum = leftSuffixSum;
            }
        }

        int rightPrefixSum = 0;
        int maxPrefixSum = 0;

        for ( int i = mid + 1; i <= end; ++i ) {
            rightPrefixSum += arr [ i ];
            if ( rightPrefixSum > maxPrefixSum ) {
                maxPrefixSum = rightPrefixSum;
            }
        }

        int thisMaxSum = maxSuffixSum + maxPrefixSum;

        return Math.max ( thisMaxSum, Math.max ( leftMaxSum, rightMaxSum ) );
    }

    private static int maxSum ( int [] arr ) {
        return maxSum ( arr, 0, arr.length - 1 );
    }

}
