public class PeakElement {

    public boolean checkPeak ( int [ ] arr, int mid ) {

        if ( mid == 0 ) {
            return ( arr [ mid ] > arr [ mid + 1 ] );
        } else if ( mid == arr.length - 1 ) {
            return ( arr [ mid ] > arr [ mid - 1 ] );
        } 

        return ( arr [ mid ] > arr [ mid - 1 ] && arr [ mid ] > arr [ mid + 1 ] );
    }

    public int peakElement ( int [ ] arr ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;

        while ( start <= end ) {
            mid = start + ( end - start ) / 2;

            if ( checkPeak ( arr, mid ) ) {
                return mid;
            } else if ( mid < arr.length - 1 && arr [ mid + 1 ] > arr [ mid ] ) {
                start = mid + 1;
            } else if ( mid > 0 && arr [ mid - 1 ] > arr [ mid ] ) {
                end = mid - 1;
            }
        } 

        return Integer.MIN_VALUE;
    }
}
