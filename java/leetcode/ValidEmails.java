import java.util.Set;
import java.util.HashSet;

public class ValidEmails {

    public static void main ( String... args ) {
        String [] emails = new String [ 3 ]; 
        emails [ 0 ] = "a+b+c@gmail.com";
        emails [ 1 ] = "abc@gmail.com";
        emails [ 2 ] = "a@gmail.com";

        System.out.println (  numUniqueEmails ( emails ) );
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueAddresses = new HashSet<> ();
        for ( String s : emails ) {
            String [] parts = s.split ( "@" );
            String firstPart = getFirstPart ( parts [ 0 ] );
            System.out.println ( "for String: " + s + " firstPart: " + firstPart );
            String secondPart = parts[1];
            System.out.println ( "for String: " + s + " secondPart: " + secondPart );
            
            System.out.println ( firstPart + "@" + secondPart );
            uniqueAddresses.add ( firstPart + "@" + secondPart );
        }
        return uniqueAddresses.size ();
    }
    
    private static String getFirstPart ( String part ) {
        int plusIndex = part.indexOf ( '+' );
        System.out.println ( "for String: " + part + ", plusIndex: " + plusIndex );
        String filteredString = removePeriods ( part, plusIndex );
        System.out.println ( "filteredString: " + filteredString );
        return filteredString;
    }
    
    private static String removePeriods ( String part, int plusIndex ) {
        if ( plusIndex == -1 ) {
            plusIndex = part.length ();
        }
        if ( plusIndex == 0 ) {
            return "";
        }
        StringBuilder sb = new StringBuilder ();
        for ( int i = 0; i < plusIndex; ++i ) {
            if ( part.charAt ( i ) != '.' ) {
                sb.append ( part.charAt ( i ) );
            }            
        }
        
        return sb.toString ();
    }
}
