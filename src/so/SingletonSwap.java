package so;

/**
 * SingletonSwap
 */
public class SingletonSwap {

    private static Swap instance;

    public static Swap getInstance(){
        if( instance == null)
            instance = new Swap(50);
        
        return instance;
    }
}