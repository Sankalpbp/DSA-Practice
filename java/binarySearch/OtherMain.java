public class OtherMain {

    public static void main ( String... args ) throws Exception {

        PeakElement pe = new PeakElement ();

        int [ ] arr = {
             5, 10, 20, 15 
        };

        int [ ] arr2 = {
            5, 6, 8, 2, 24
        };

        int [ ] arr3 = {
            0, 1, 2, 4
        };

        int [ ] arr4 = {
            5, 4, 3, 2, 1
        };

        System.out.println ( pe.peakElement ( arr3 ) );
        System.out.println ( pe.peakElement ( arr4 ) );
        System.out.println ( pe.peakElement ( arr2 ) );
        System.out.println ( pe.peakElement ( arr2 ) );

        MaxInBitonicArray mba = new MaxInBitonicArray ();

        int [ ] bitonic = { 1, 3, 8, 12, 4, 2 };
        int [ ] bitonic2 = { 1, 3, 8, 12 };
        int [ ] bitonic3 = { 12, 4, 2 };
        
        System.out.println ( mba.maxInBitonicArray ( bitonic ) );
        System.out.println ( mba.maxInBitonicArray ( bitonic2 ) );
        System.out.println ( mba.maxInBitonicArray ( bitonic3 ) );

        SearchInBitonicArray sba = new SearchInBitonicArray ( );

        System.out.println ( sba.search ( bitonic, 1 ) );
        System.out.println ( sba.search ( bitonic, -1 ) );
        System.out.println ( sba.search ( bitonic, 3 ) );
        System.out.println ( sba.search ( bitonic, 8 ) );
        System.out.println ( sba.search ( bitonic, 12 ) );
        System.out.println ( sba.search ( bitonic, 4 ) );
        System.out.println ( sba.search ( bitonic, 2 ) );


        int [ ] books = { 10, 30, 20, 40 };

        AllocatePages ap = new AllocatePages ();
        System.out.println ( ap.pages ( books, 2 ) );

    }
}
