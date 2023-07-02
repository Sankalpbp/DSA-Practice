import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {

    public static int longestSubstring ( String s, int k ) {
        Map<Character, Integer> isCharacterAvailable = new HashMap<> ();
        int i = 0;
        int j = 0;
        int longest = 0;

        while ( j < s.length () ) {

            if ( isCharacterAvailable.containsKey ( s.charAt ( j ) ) ) {
                isCharacterAvailable.put ( s.charAt ( j ), isCharacterAvailable.get ( s.charAt ( j ) ) + 1 );
            } else {
                isCharacterAvailable.put ( s.charAt ( j ), 1 );
            }

            if ( isCharacterAvailable.size () < k ) {
                ++j;
            } else if ( isCharacterAvailable.size () == k ) {
                longest = Math.max ( longest, ( j - i + 1 ) );
                ++j;
            } else if ( isCharacterAvailable.size () > k ) {
                while ( isCharacterAvailable.size () > k ) {
                    if ( isCharacterAvailable.containsKey ( s.charAt ( i ) ) ) {
                        if ( isCharacterAvailable.get ( s.charAt ( i ) ) > 0 ) {
                            isCharacterAvailable.put ( s.charAt ( i ), isCharacterAvailable.get ( s.charAt ( i ) ) - 1 );
                        }

                        if ( isCharacterAvailable.get ( s.charAt ( i ) ) == 0 ) {
                            isCharacterAvailable.remove ( s.charAt ( i ) );
                        }
                    }
                    ++i;
                }
                ++j;
            }
        }

        return longest;
    }
}
