public class SearchInNearlySortedArray {

    public int search ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return mid;
            } else if ( ( mid - 1 ) >= start && arr [ mid - 1 ] == key ) {
                return ( mid - 1 );
            } else if ( ( mid + 1 ) <= end && arr [ mid + 1 ] == key ) {
                return mid + 1;
            } else if ( arr [ mid ] > key ) {
                end = mid - 2;
            } else if ( arr [ mid ] < key ) {
                start = mid + 2;
            }
        }

        return -1;
    }
}
