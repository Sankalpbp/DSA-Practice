import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AllocatePages {

    private int getMinimum ( int [ ] books ) {
        int minimum = Integer.MAX_VALUE;
        List<Integer> dummy = Arrays.stream ( books )
                                    .boxed ()
                                    .collect ( Collectors.toList ( ) );

        return Collections.min ( dummy );
    }

    private int getSum ( int [ ] books ) {

        List<Integer> dummy = new ArrayList<> ( books.length );

        for ( int x : books ) {
            dummy.add ( x );
        }

        return dummy.stream ()
                    .mapToInt ( Integer::intValue )
                    .sum ();
    }

    private boolean isValidDistribution ( int [ ] books, int pages, int numberOfStudents ) {

        int requiredStudents = 1;
        int sum = 0;

        for ( int i = 0; i < books.length; ++i ) {
            sum += books [ i ];

            if ( sum > pages ) {
                ++requiredStudents;
                sum = books [ i ];
            }
        }

        return ( requiredStudents == numberOfStudents );
    }

    public int pages ( int [ ] books, int numberOfStudents ) throws Exception {

        if ( books.length < numberOfStudents ) {
            throw new Exception ();
        }

        int start = getMinimum ( books );
        int end = getSum ( books );

        int mid;
        int result = 0;

        while ( start <= end ) {

            mid = start + ( end - start ) / 2;

            if ( isValidDistribution ( books, mid, numberOfStudents ) ) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}
