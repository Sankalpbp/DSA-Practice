public class BinarySearchOnReverseSorted {

    private int binarySearchRecursive ( int [ ] arr, int start, int end, int key ) {
        if ( start > end ) {
            return -1;
        }

        int mid = start + ( end - start ) / 2;

        if ( arr [ mid ] == key ) {
            return mid;
        } else if ( arr [ mid ] > key ) {
            // here comes the difference in the reverse sorted
            return binarySearchRecursive ( arr, mid + 1, end, key );
        }

        return binarySearchRecursive ( arr, start, mid - 1, key );
    }

    public int binarySearchRecursive ( int [ ] arr, int key ) {
        return binarySearchRecursive ( arr, 0, arr.length - 1, key );
    }

    public int binarySearchIterative ( int [ ] arr, int key ) {

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
}
