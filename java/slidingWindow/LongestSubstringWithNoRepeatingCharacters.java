import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithNoRepeatingCharacters {

    public static int longestSubstring ( String s ) {

        Map<Character, Integer> frequencyForCharacter = new HashMap<> ();
        int i = 0;
        int j = 0;

        int longest = 0;

        while ( j < s.length () ) {

            if ( frequencyForCharacter.containsKey ( s.charAt ( j ) ) ) {
                frequencyForCharacter.put ( s.charAt ( j ), frequencyForCharacter.get ( s.charAt ( j ) ) + 1 );
            } else {
                frequencyForCharacter.put ( s.charAt ( j ), 1 );
            }

            int windowSize = ( j - i + 1 );

            if ( frequencyForCharacter.size () == windowSize ) {
                longest = Math.max ( longest, windowSize );
                ++j;
            } else if ( frequencyForCharacter.size () < windowSize ) {
                while ( frequencyForCharacter.size () < windowSize ) {
                    if ( frequencyForCharacter.containsKey ( s.charAt ( i ) ) ) {
                        if ( frequencyForCharacter.get ( s.charAt ( i ) ) > 0 ) {
                            frequencyForCharacter.put ( s.charAt ( i ), frequencyForCharacter.get ( s.charAt ( i ) ) - 1 );
                        } 
                        
                        if ( frequencyForCharacter.get ( s.charAt ( i ) ) == 0 ) {
                            frequencyForCharacter.remove ( s.charAt ( i ) );
                        }
                    }
                    ++i;
                    windowSize = ( j - i + 1 );
                }
                ++j;
            }
        }

        return longest;
    }
}
