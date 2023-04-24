public class RainWaterTrapping {

    public int rainWaterTrapped ( int [ ] arr ) {

        int [ ] leftTallest = getLeftTallest ( arr );
        int [ ] rightTallest = getRightTallest ( arr );

        int water = 0;
        int totalWater = 0;

        for ( int i = 0; i < arr.length; ++i ) {
            water = Math.min ( leftTallest [ i ], rightTallest [ i ] ) - arr [ i ];
            totalWater += water < 0 ? 0 : water;
        }

        return totalWater;
    }

    private int [ ] getLeftTallest ( int [ ] arr ) {

        int [ ] output = new int [ arr.length ];

        output [ 0 ] = 0;

        for ( int i = 1; i < arr.length; ++i ) {
            output [ i ] = Math.max ( output [ i - 1 ], arr [ i - 1 ] );
        }

        return output;
    }

    private int [ ] getRightTallest ( int [ ] arr ) {

        int [ ] output = new int [ arr.length ];

        output [ arr.length - 1 ] = 0;

        for ( int i = arr.length - 2; i >= 0; --i ) {
            output [ i ] = Math.max ( output [ i + 1 ], arr [ i + 1 ] );
        }

        return output;
    }
}
