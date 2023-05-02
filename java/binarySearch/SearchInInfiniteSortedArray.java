public class SearchInInfiniteSortedArray {

    private int binarySearch ( int [ ] arr, int start, int end, int key ) {

        int mid;

        while ( start <= end ) {
            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return mid;
            } else if ( arr [ mid ] > key ) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int search ( int [ ] arr, int key ) {

        if ( arr [ 0 ] == key ) {
            return 0;
        }

        int start = 0;
        int mid = 1;

        while ( true ) {
            if ( arr [ mid ] == key ) {
                return mid;
            } else if ( arr [ mid ] > key ) {
                return binarySearch ( arr, start, mid - 1, key );
            } else {
                start = mid;
                mid *= 2;
            }
        }
    }
}
