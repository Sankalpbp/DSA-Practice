public class MaximumSumSubarray {

    public static int maximumSumSubarray ( int [ ] arr, int k ) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;

        while ( ( j - i + 1 ) < k ) {
            sum += arr [ j ];
            ++j;
        }

        while ( j < arr.length ) {
            sum += arr [ j ];
            max = Math.max ( max, sum );

            sum -= arr [ i ];

            ++i;
            ++j;
        }

        return max;
    }
}
