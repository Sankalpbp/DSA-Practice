public class SurviveOnIsland {

    public static int buyFoodDays ( int daysToSurvive, int foodRequiredInOneDay, int foodCouldBeBoughtInOneDay ) {
        // On Sundays, the shop is closed
        int sundays = daysToSurvive / 7;
        int possibleNumberOfBuyDays = daysToSurvive - sundays;

        double answer = Math.ceil ( ( Integer ) ( ( daysToSurvive * foodRequiredInOneDay ) / foodCouldBeBoughtInOneDay ) );

        // if the answer comes out to be more than the possible number of days... then, we're gonna die
        if ( answer > possibleNumberOfBuyDays ) {
            return -1;
        }

        return ( int ) answer;
    }
}
