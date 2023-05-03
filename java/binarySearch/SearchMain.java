public class SearchMain {

    public static void main ( String... args ) {

        int [ ][ ] matrix = {
            { 10, 20, 30, 40 },
            { 15, 25, 35, 45 },
            { 27, 29, 37, 48 },
            { 32, 33, 39, 50 }
        };

        SearchInMatrix sm = new SearchInMatrix ( );

        System.out.println ( sm.search ( matrix, 25 ) );
        System.out.println ( sm.search ( matrix, 37 ) );
        System.out.println ( sm.search ( matrix, 50 ) );
        System.out.println ( sm.search ( matrix, 48 ) );
        System.out.println ( sm.search ( matrix, 32 ) );

    }
}
