public class LetterCasePermutation {

    private static final int DIGIT = 1;
    private static final int LOWER_CASE = 2;
    private static final int UPPER_CASE = 3;

    public static void permutation ( String input ) {
        permutation ( input, "" );
    }

    private static void permutation ( String input, String output ) {
        if ( input.length () == 0 ) {
            System.out.println ( output );
            return;
        }

        switch ( getCharacterType ( input.charAt ( 0 ) ) ) {
            case DIGIT:
                permutation ( input.substring ( 1 ), output + input.charAt ( 0 ) );
                break;

            case LOWER_CASE:
                permutation ( input.substring ( 1 ), output + Character.toUpperCase ( input.charAt ( 0 ) ) );
                permutation ( input.substring ( 1 ), output + input.charAt ( 0 ) );
                break;
                
            case UPPER_CASE:
                permutation ( input.substring ( 1 ), output + Character.toLowerCase ( input.charAt ( 0 ) ) );
                permutation ( input.substring ( 1 ), output + input.charAt ( 0 ) );
                break;
        }
    }

    private static int getCharacterType ( char ch ) {
        if ( isUpperCaseCharacter ( ch ) ) {
            return 3;
        }

        if ( isLowerCaseCharacter ( ch ) ) {
            return 2;
        }

        return 1;
    }

    private static boolean isUpperCaseCharacter ( char ch ) {
        if ( ch >= 'A' && ch <= 'Z' ) {
            return true;
        }

        return false;
    }
    
    private static boolean isDigit ( char ch ) {
        if ( ch >= '0' && ch <= '9' ) {
            return true;
        }

        return false;
    }

    private static boolean isLowerCaseCharacter ( char ch ) {
        if ( ch >= 'a' && ch <= 'z' ) {
            return true;
        }

        return false;
    }
}
