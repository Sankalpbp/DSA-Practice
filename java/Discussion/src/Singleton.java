public class Singleton {

    private int value;

    private static Singleton singleton;

    private Singleton ( int value ) {
        this.value = value;
    }

    public static Singleton createSingleton ( int value ) {
        if ( singleton == null ) {
            singleton = new Singleton ( value );
        }
        return singleton;
    }

}
