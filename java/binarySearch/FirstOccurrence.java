public class FirstOccurrence {

    public int firstOccurrence ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;
        int mid;

        int firstOccurrenceIndex = -1;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                firstOccurrenceIndex = mid;
                end = mid - 1;
            } else if ( arr [ mid ] > key ) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return firstOccurrenceIndex;
    }
}
