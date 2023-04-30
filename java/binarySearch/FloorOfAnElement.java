public class FloorOfAnElement {

    public int floor ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;
        int floorElement = -1;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return arr [ mid ];
            } else if ( arr [ mid ] < key ) {
                floorElement = arr [ mid ];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return floorElement;
    }
}
