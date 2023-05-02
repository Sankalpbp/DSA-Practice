public class Search1InBinarySortedArray {

    private int getFirstOccurrence ( int [ ] arr, int start, int end, int key ) {

        int mid;
        int firstOccurrenceIndex = -1;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                firstOccurrenceIndex = mid;
                end = mid - 1;
            } else if ( arr [ mid ] == 0 ) {
                start = mid + 1;
            }
        }

        return firstOccurrenceIndex;
    }

    public int search ( int [ ] arr ) {

        if ( arr [ 0 ] == 1 ) {
            return 0;
        }

        int start = 0;
        int mid = 1;

        while ( true ) {
            if ( arr [ mid ] == 1 ) {
                return getFirstOccurrence ( arr, start, mid, 1 );
            } else if ( arr [ mid ] == 0 ) {
                start = mid;
                mid *= 2;
            }
        }
    }
}
