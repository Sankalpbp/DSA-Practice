public class OrderAgnosticSearch {

    private int binarySearchReverse ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return mid;
            } else if ( arr [ mid ] > key ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearch ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;

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

    public int orderAgnosticSearch ( int [ ] arr, int key ) {

        if ( arr.length == 0 ) {
            return -1;
        }

        if ( arr.length == 1 ) {
            return ( arr [ 0 ] == key ) ? 0 : -1;
        }

        if ( arr [ 0 ] > arr [ 1 ] ) {
            return binarySearchReverse ( arr, key );
        }

        return binarySearch ( arr, key );
    }
}
