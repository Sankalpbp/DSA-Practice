import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HeapUsingComparable {

    private static int generateRandomNumber ( int minimum, int maximum ) {
        return ( int ) Math.round ( Math.random ( ) * ( maximum - minimum + 1 ) + minimum );
    }

    private static void printBooks ( PriorityQueue<Book> heap ) {
        Stream.generate ( heap :: poll )
              .limit ( heap.size () )
              .forEach ( System.out :: print );
    }

    public static void main ( String... args ) {

        PriorityQueue<Book> minHeap = IntStream.range ( 0, 10 )
                                               .mapToObj ( i -> new Book ( generateRandomNumber ( 0, 1000 ) ) )
                                               .collect ( Collectors.toCollection ( PriorityQueue :: new ) );

        System.out.println ( minHeap );
        printBooks ( minHeap );
    }
}
