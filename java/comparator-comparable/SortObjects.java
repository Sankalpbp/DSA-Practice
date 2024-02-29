import java.util.Arrays;
import java.util.Comparator;


public class SortObjects {

    private static int getRandomNumber ( int minimum, int maximum ) {
        return ( int ) Math.round ( Math.random () * ( maximum - minimum + 1 ) + minimum );
    }

    public static void main ( String... args ) {

        Student [ ] arr = new Student [ 10 ];
        for ( int i = 0; i < 10; ++i ) {
            arr [ i ] = new Student ( getRandomNumber ( 0, 10000 ), getRandomNumber ( 0, 60 ) );
        }

        System.out.println ( "Unsorted: " );
        Arrays.stream ( arr )
              .forEach ( System.out::println );

        Arrays.sort ( arr, new Comparator<Student> ( ) {
            public int compare ( Student student1, Student student2 ) {
                if ( student1.getBooksRead () == student2.getBooksRead () ) {
                    if ( student1.getAge () == student2.getAge () ) {
                        return 0;
                    } else if ( student1.getAge () > student2.getAge () ) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                if ( student1.getBooksRead ( ) > student2.getBooksRead ( ) ) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } );

        System.out.println ( "Sorted: " );
        Arrays.stream ( arr )
              .forEach ( System.out::println );
    }

}
