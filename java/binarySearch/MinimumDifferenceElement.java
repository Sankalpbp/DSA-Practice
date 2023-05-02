public class MinimumDifferenceElement {

    private int getCeil ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;
        int ceil = 0;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return arr [ mid ]; 
            } else if ( arr [ mid ] > key ) {
                ceil = arr [ mid ];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ceil;
    }

    private int getFloor ( int [ ] arr, int key ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;
        int floor = 0;

        while ( start <= end ) {
            mid = start + ( end - start ) / 2;

            if ( arr [ mid ] == key ) {
                return arr [ mid ];
            } else if ( arr [ mid ] > key ) {
                end = mid - 1;
            } else {
                floor = arr [ mid ];
                start = mid + 1;
            }
        }

        return floor;
    }

    public int minimumDifference ( int [ ] arr, int key ) {

        int floor = getFloor ( arr, key );
        int ceil = getCeil ( arr, key );

        if ( Math.abs ( key - floor ) < Math.abs ( key - ceil ) ) {
            return floor;
        } 

        return ceil;
    }
}
