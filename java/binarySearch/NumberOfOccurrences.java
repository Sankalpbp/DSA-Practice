public class NumberOfOccurrences {

    public int numberOfOccurrences ( int [ ] arr, int key ) {

        int firstOccurrence = getFirstOccurrence ( arr, key );
        int lastOccurrence = getLastOccurrence ( arr, key );

        // this means that lastOccurrence would also be -1
        // since -1 indicates that the element is not there in the array
        if ( firstOccurrence == -1 ) {
            return 0;
        }

        return lastOccurrence - firstOccurrence + 1;
    }

    public int getFirstOccurrence ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;
        int mid;

        int firstOccurrence = -1;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                firstOccurrence = mid;
                end = mid - 1;
            } else if ( arr [ mid ] > key ) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return firstOccurrence;
    }

    public int getLastOccurrence ( int [ ] arr, int key ) {
        
        int start = 0;
        int end = arr.length - 1;

        int mid;

        int lastOccurrence = -1;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                lastOccurrence = mid;
                start = mid + 1;
            } else if ( arr [ mid ] > key ) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return lastOccurrence;
    }

}
