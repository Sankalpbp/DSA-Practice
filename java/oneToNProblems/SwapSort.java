import java.util.List;

public class SwapSort {

    public void sort ( List<Integer> list ) {

        for ( int i = 0; i < list.size (); ++i ) {

            int current = list.get ( i );
            int correctValue = i + 1;
            int potentialPosition = list.get ( i ) - 1;

            int k = 0;

            while ( list.get ( i ) != ( i + 1 ) && 
                    ( list.get ( list.get ( i ) - 1 ) != list.get ( i ) ) ) {
                int j = list.get ( i ) - 1;
                int temp = list.get ( i );
                list.set ( i, list.get ( list.get ( i ) - 1 ) );
                list.set ( j, temp );
            }

        }

    }
}
