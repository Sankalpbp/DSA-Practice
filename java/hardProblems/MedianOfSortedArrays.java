public class MedianOfSortedArrays {

    public static void print () {
        int [] arr1 = new int [ ] { 1, 2, 3, 4, 5, 6, 7, 8 };
        int [] arr2 = new int [ ] { 1, 2, 3, 4, 5 };

        System.out.println ( "Median of the given sorted arrays are: " + calculateMedian ( arr1, arr2 ) );
    }

    private static double calculateMedian ( int [] arr1, int [] arr2 ) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if ( n1 > n2 ) {
            return calculateMedian ( arr2, arr1 );
        }

        int n = n1 + n2;
        int left = ( n + 1 ) / 2;

        int start = 0;
        int end = n1;

        int mid1, mid2, left1, left2, right1, right2;

        while ( start <= end ) {
            mid1 = start + ( end - start ) / 2;
            mid2 = left - mid1;

            left1 = Integer.MIN_VALUE;
            left2 = Integer.MIN_VALUE;

            right1 = Integer.MAX_VALUE;
            right2 = Integer.MAX_VALUE;

            if ( mid1 < n1 ) {
                right1 = arr1 [ mid1 ];
            } 
            if ( mid2 < n2 ) {
                right2 = arr2 [ mid2 ];
            }
            if ( mid1 - 1 >= 0 ) {
                left1 = arr1 [ mid1 - 1 ];
            }
            if ( mid2 - 1 >= 0 ) {
                left2 = arr2 [ mid2 - 1 ];
            }

            if ( left1 <= right2 && left2 <= right1 ) {
                if ( n % 2 == 1 ) {
                    return Math.max ( left1, left2 );
                } else {
                    return ( Math.max ( left1, left2 ) + Math.max ( right1, right2 ) ) / 2.0;
                }
            } else if ( left1 > right2 ) {
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }
        return Double.NEGATIVE_INFINITY;
    }
}
