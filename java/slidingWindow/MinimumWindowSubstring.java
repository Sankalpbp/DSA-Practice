import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstring {

    private static void fillCount ( Map<Character, Integer> countForCharacter, String t ) {
        for ( char x : t.toCharArray () ) {
            if ( countForCharacter.containsKey ( x ) ) {
                countForCharacter.put ( x, countForCharacter.get ( x ) + 1 );
            } else {
                countForCharacter.put ( x, 1 );
            }
        }
    }

    public static String minimumSubstring ( String s, String t ) {

        Map<Character, Integer> countForCharacter = new HashMap<> ();
        fillCount ( countForCharacter, t );

        int i = 0;
        int j = 0;

        int answer = Integer.MAX_VALUE;
        int start = 0;

        int numberOfUniqueCharacters = countForCharacter.size ();

        while ( j < s.length () ) {

            if ( countForCharacter.containsKey ( s.charAt ( j ) ) ) {
                countForCharacter.put ( s.charAt ( j ), countForCharacter.get ( s.charAt ( j ) ) - 1 );
            } 

            if ( countForCharacter.containsKey ( s.charAt ( j ) ) && 
                 countForCharacter.get ( s.charAt ( j ) ) == 0 ) {
                --numberOfUniqueCharacters;
            }

            if ( numberOfUniqueCharacters == 0 ) {
                while ( numberOfUniqueCharacters == 0 ) {

                    // get the possible answer
                    if ( answer > ( j - i + 1 ) ) {
                        answer = Math.min ( answer, ( j - i + 1 ) );
                        start = i;
                    }

                    // shrink the window 
                    // if the character @ j is present in the map, its count would either be 
                    // 0 or be negative
                    if ( countForCharacter.containsKey ( s.charAt ( i ) ) ) {
                        countForCharacter.put ( s.charAt ( i ), countForCharacter.get ( s.charAt ( i ) ) + 1 );
                    } else {
                        countForCharacter.put ( s.charAt ( i ), 1 );
                    }

                    if ( countForCharacter.get ( s.charAt ( i ) ) > 0 ) {
                        ++numberOfUniqueCharacters;
                    }

                    ++i;
                }
            }

            ++j;
        }

        if ( answer != Integer.MAX_VALUE ) {
            return s.substring ( start, answer + 1 ); 
        } 

        return "NO SUCH STRING";
    }
}
