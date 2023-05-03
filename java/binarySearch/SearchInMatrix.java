public class SearchInMatrix {

    public int search ( int [ ] [ ] matrix, int key ) {

        int i = 0;
        int j = matrix [ 0 ].length - 1;

        while ( i < matrix.length && j >= 0 ) {

            if ( matrix [ i ][ j ] == key ) {
                System.out.println ( i + " " + j );
                return i + j;
            } else if ( matrix [ i ][ j ] > key ) {
                --j;
            } else {
                ++i;
            }
        }
        
        System.out.println ( -1 + " " + -1 );

        return -2;
    }
}
