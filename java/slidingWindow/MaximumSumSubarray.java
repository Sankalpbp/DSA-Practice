public class MaximumSumSubarray {

    public static int maximumSumSubarray ( int [ ] arr, int k ) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;

        while ( j < arr.length ) {

            sum += arr [ j ];
            if ( ( j - i + 1 ) < k ) {
                ++j;
            } else if ( ( j - i + 1 ) == k ) {
                max = Math.max ( max, sum );

                sum -= arr [ i ];

                ++i;
                ++j;
            }
        }

        return max;
    }
}
