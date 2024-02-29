public class MedianOf2Arrays {

    public static void print () {
        System.out.println ( median ( new int [] { 1, 3, 4, 7, 10, 12 }, new int [] { 2, 3, 6, 15 } ) );
        System.out.println ( median ( new int [] { 1, 3, 4 }, new int [] { 2, 3 } ) );
    }

    private static int medianBS ( int [] arr1, int [] arr2 ) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if ( n2 > n1 ) {
            return median ( arr2, arr1 );
        }

        int low = 0;
        int high = n1;

        while ( low <= high ) {

        }
    }

    private static int median ( int [] arr1, int [] arr2 ) {
        int count = 0;

        int i = 0;
        int j = 0;

        int element1 = 0, element2 = 0;
        int element = 0;
        int finalArrayLength = arr1.length + arr2.length;
        int index1 = finalArrayLength / 2;
        int index2 = finalArrayLength / 2 - 1;

        while ( i < arr1.length && j < arr2.length ) {
            if ( arr1 [ i ] > arr2 [ j ] ) {
                element = arr2 [ j ];
                ++j;
            } else {
                element = arr1 [ i ];
                ++i;
            }
            if ( count == index1 ) {
                element1 = element;
            } else if ( count == index2 ) {
                element2 = element;
            }
            ++count;
        }

        System.out.println ( "element1: " + element1 + ", element2: " + element2 );

        return ( finalArrayLength % 2 != 0 ) ? element2
                                             : ( element1 + element2 ) / 2;
    }
}
