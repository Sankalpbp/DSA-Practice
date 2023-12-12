public class PhoneLetterDigits {

    public static void print ( int number ) {
        generate ( number, "" );
    }

    private static void generate ( int number, String generatedString ) {
        if ( number == 0 ) {
            System.out.println ( generatedString );
            return;
        }

        String options = getOptions ( number % 10 );

        for ( char x : options.toCharArray () ) {
            generate ( number / 10, x + generatedString );
        }
    }

    private static String getOptions ( int number ) {
        if ( number == 2 ) {
            return "abc";
        }
        if ( number == 3 ) {
            return "def";
        }
        if ( number == 4 ) {
            return "ghi";
        }
        if ( number == 5 ) {
            return "jkl";
        }
        if ( number == 6 ) {
            return "mno";
        }
        if ( number == 7 ) {
            return "pqrs";
        }
        if ( number == 8 ) {
            return "tuv";
        }
        if ( number == 9 ) {
            return "wxyz";
        }

        return "";
    }
}
