public class MaxInBitonicArray {

    private boolean checkMaximum ( int [ ] arr, int mid ) {

        if ( arr.length <= 1 ) {
            return true;
        }

        if ( mid == 0 ) {
            return ( arr [ mid ] > arr [ mid + 1 ] );
        } else if ( mid == arr.length - 1 ) {
            return ( arr [ mid ] > arr [ mid - 1 ] );
        } 

        return arr [ mid ] > arr [ mid - 1] && arr [ mid ] > arr [ mid + 1 ];
    }

    public int maxInBitonicArray ( int [ ] arr ) {
        int start = 0;
        int end = arr.length - 1;

        int mid;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( checkMaximum ( arr, mid ) ) {
                return mid;
            } else if ( ( mid < arr.length - 1 ) ) {
                if ( arr [ mid + 1 ] > arr [ mid ] ) {
                    start = mid + 1;
                } else if ( arr [ mid + 1 ] < arr [ mid ] ) {
                    end = mid;
                }
            } else if ( mid > 0 ) {
                if ( arr [ mid - 1 ] < arr [ mid ] ) {
                    start = mid;
                } else if ( arr [ mid - 1 ] > arr [ mid ] ) {
                    end = mid - 1;
                }
            }
        }

        return Integer.MIN_VALUE;
    }
}
