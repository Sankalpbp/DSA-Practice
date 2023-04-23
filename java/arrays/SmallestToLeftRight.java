public class SmallestToLeftRight {

    public int [ ] smallestToLeft ( int [ ] arr ) {

        int [ ] output = new int [ arr.length ];

        output [ 0 ] = -1;

        for ( int i = 1; i < arr.length; ++i ) {
            if ( output [ i - 1 ] != -1 ) {
                if ( output [ i - 1 ] > arr [ i ] && arr [ i - 1 ] > arr [ i ] ) {
                    output [ i ] = -1;
                } else {
                    output [ i ] = Math.min ( arr [ i - 1 ], output [ i - 1 ] );
                }
            } else {
                output [ i ] = ( arr [ i - 1 ] < arr [ i ] ) ? arr [ i - 1 ] : -1;
            }
        }

        return output;
    }

    public int [ ] smallestToRight ( int [ ] arr ) {

        int [ ] output = new int [ arr.length ];

        output [ arr.length - 1 ] = -1;

        for ( int i = arr.length - 2; i >= 0; --i ) {
            if ( output [ i + 1 ] != -1 ) {
                if ( output [ i + 1 ] > arr [ i ] && arr [ i + 1 ] > arr [ i ] ) {
                    output [ i ] = -1;
                } else {
                    output [ i ] = Math.min ( arr [ i + 1 ], output [ i + 1 ] );
                }
            } else {
                output [ i ] = ( arr [ i + 1 ] < arr [ i ] ) ? arr [ i + 1 ] : -1;
            }
        }

        return output;
    }

}
