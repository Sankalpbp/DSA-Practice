public class SearchInBitonicArray {

    private boolean checkMaximum ( int [ ] arr, int mid ) {

        if ( mid == 0 ) {
            return ( arr [ mid ] > arr [ mid + 1 ] );
        } else if ( mid == arr.length - 1 ) {
            return ( arr [ mid ] > arr [ mid - 1 ] );
        }

        return ( arr [ mid ] > arr [ mid + 1 ] && arr [ mid ] > arr [ mid - 1 ] );
    }

    private int binarySearchDescending ( int [ ] arr, int key, int start, int end ) {

        int mid;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return mid;
            } else if ( arr [ mid ] < key ) {
                end = mid - 1;
            } else if ( arr [ mid ] > key ) {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchAscending ( int [ ] arr, int key, int start, int end ) {

        int mid;
        
        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return mid;
            } else if ( arr [ mid ] > key ) {
                end = mid - 1;
            } else if ( arr [ mid ] < key ) {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int getPivot ( int [ ] arr ) {

        if ( arr.length == 0 ) {
            return -1;
        }

        if ( arr.length <= 1 ) {
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;

        int mid;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( checkMaximum ( arr, mid ) ) {
                return mid;
            } else if ( mid > 0 ) {
                if ( arr [ mid ] < arr [ mid - 1 ] ) {
                    end = mid - 1;
                } else if ( arr [ mid ] > arr [ mid - 1 ] ) {
                    start = mid;
                }
            } else if ( mid < arr.length - 1 ) {
                if ( arr [ mid ] < arr [ mid + 1 ] ) {
                    start = mid + 1;
                } else if ( arr [ mid ] > arr [ mid + 1 ] ) {
                    end = mid;
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    public int search ( int [ ] arr, int key ) {

        int pivot = getPivot ( arr );

        int ascendingResult = binarySearchAscending ( arr, key, 0, pivot );
        if ( ascendingResult != -1 ) {
            return ascendingResult;
        } 

        return binarySearchDescending ( arr, key, pivot + 1, arr.length - 1 );
    }
}
