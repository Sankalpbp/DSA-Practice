public class CeilOfAnElement {

    public int ceil ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;
        int ceilElement = -1;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return arr [ mid ];
            } else if ( arr [ mid ] > key ) {
                end = mid - 1;
                ceilElement = arr [ mid ];
            } else {
                start = mid + 1;
            }
        }

        return ceilElement;
    }
}
