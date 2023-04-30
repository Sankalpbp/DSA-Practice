public class ArrayRotations {

    int getIndexOfMinimumElement ( int [ ] arr ) {

        int start = 0;
        int end = arr.length - 1;

        int mid;
        int previous;
        int next;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;
            next = ( mid + 1 ) % arr.length;
            previous = ( arr.length + ( mid - 1 ) ) % arr.length;

            if ( arr [ mid ] < arr [ next ] && arr [ mid ] < arr [ previous ] ) {
                return mid;
            } else if ( arr [ mid ] > arr [ end ] ) {
                start = next;
            } else if ( arr [ mid ] < arr [ end ] ) {
                end = previous;
            }
        }

        return -1;
    }

    public int numberOfArrayRotations ( int [ ] arr ) {

        // Rotation is counter-clockwise
        
        // the idea is to find the minimum element... Why? 
        // Go Figure...

        int minimumElementIndex = getIndexOfMinimumElement ( arr );
        return arr.length - minimumElementIndex;
    }
}
