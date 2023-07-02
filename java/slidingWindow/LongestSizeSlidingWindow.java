import java.util.List;

public class LongestSizeSlidingWindow {

    public static int longest ( List<Integer> list, int sum ) {

        int i = 0;
        int j = 0;
        int currentSum = 0;

        int currentSize = 0;
        int maxSize = 0;

        while ( j < list.size () ) {
            currentSum += list.get ( j );

            if ( currentSum < sum ) {
                ++j;
            } else if ( currentSum == sum ) {
                currentSize = ( j - i + 1 );
                maxSize = Math.max ( maxSize, currentSize );
                ++j;
            } else if ( currentSum > sum ) {
                while ( currentSum > sum ) {
                    currentSum -= list.get ( i );
                    ++i;
                }
                ++j;
            }
        }

        return maxSize;
    }

}
