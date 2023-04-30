public class SearchInRotatedSortedArray {

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

    private int getPivot ( int [ ] arr ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;
        int next;
        int previous;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;
            previous = ( ( mid - 1 ) + arr.length ) % arr.length;
            next = ( mid + 1 ) % arr.length;

            if ( arr [ mid ] < arr [ previous ] && arr [ mid ] < arr [ next ] ) {
                return mid;
            } else if ( arr [ mid ] > arr [ end ] ) {
                start = next;
            } else if ( arr [ mid ] < arr [ end ] ) {
                end = previous;
            }
        }

        return -1;
    }

    public int search ( int [ ] arr, int key ) {

        int pivot = getPivot ( arr );

        if ( arr [ 0 ] > key ) {
            return binarySearch ( arr, pivot, arr.length - 1, key );
        } else {
            return binarySearch ( arr, 0, pivot - 1, key );
        }
    }

}
