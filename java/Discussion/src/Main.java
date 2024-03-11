public class Main {
    public static void main(String[] args) {
        Student [] students = {
                new Student ( "Ram", 23, 99 ),
                new Student ( "Balram", 61, 81 ),
                new Student ( "Shyam", 21, 91 )
        };

        System.out.println ( "Before" );
        printStudents ( students );

        UsingComparator.sortMarksWise ( students );

        System.out.println ( "After" );
        printStudents ( students );

        UsingComparable.sortRollNumberWise( students );

        System.out.println ( "Roll Number wise After" );
        printStudents ( students );
    }

    public static void printStudents ( Student [] students ) {
        for ( Student s : students ) {
            System.out.println ( s );
        }
    }
}
