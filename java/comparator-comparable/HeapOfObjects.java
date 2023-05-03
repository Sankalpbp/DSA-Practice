import java.util.stream.IntStream;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.stream.Stream;

public class HeapOfObjects {

    private static int generateRandomNumber ( int minimum, int maximum ) {
        return ( int ) ( Math.random ( ) * ( maximum - minimum + 1 ) + minimum );
    }

    private static void printHeap ( final PriorityQueue<Student> heap ) {
        Stream.generate ( heap :: poll )
              .limit ( heap.size () )
              .forEach ( System.out :: print );
    }

    public static void main ( String... args ) {

/*
        Student [ ] arr = IntStream.range ( 0, 10 )
                                .mapToObj ( i -> new Student ( generateRandomNumber ( 0, 10000 ), generateRandomNumber ( 0, 60 ) ) )
                                .toArray ( Student [ ] :: new );
                                */

        List<Student> students = IntStream.range ( 0, 10 )
                                          .mapToObj ( i -> new Student ( generateRandomNumber ( 0, 10000 ),
                                                                         generateRandomNumber ( 0, 60 ) ) )
                                          .collect ( Collectors.toList () );

        PriorityQueue<Student> minHeap = new PriorityQueue<Student> ( new Comparator () {
            public int compare ( Object a, Object b ) {
                Student student1 = ( Student ) a;
                Student student2 = ( Student ) b;

                if ( student1.getBooksRead () == student2.getBooksRead () ) {
                    return 0;
                } else if ( student1.getBooksRead () > student2.getBooksRead () ) {
                    return 1;
                } 

                return -1;
            }
        });

        students.stream ()
                   .forEach ( minHeap :: add );

        System.out.println ( students );
        System.out.println ( "Min Heap: " );
        System.out.println ( minHeap );


        PriorityQueue<Student> maxHeap = new PriorityQueue<Student> ( new Comparator () {
            public int compare ( Object a, Object b ) {
                Student student1 = ( Student ) a;
                Student student2 = ( Student ) b;

                if ( student1.getBooksRead ( ) == student2.getBooksRead () ) {
                    return 0;
                } else if ( student1.getBooksRead () > student2.getBooksRead () ) {
                    return -1;
                } else {
                    return 1;
                }
            }
        } );

        students.stream ()
                .forEach ( maxHeap :: add );

        System.out.println ( "Max Heap: " );
        System.out.println ( maxHeap );

        System.out.println ( "\n\nEmptying max heap: " );
        printHeap ( maxHeap );
        System.out.println ( "\n\nEmptying min heap: " );
        printHeap ( minHeap );
    }

}
