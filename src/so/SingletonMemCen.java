package so;

/**
 * SingletonMemCen
 */
public class SingletonMemCen {

    private static MemCen instance;

    public static MemCen getInstance(){
        if( instance == null)
            instance = new MemCen(30);
        
        return instance;
    }
}