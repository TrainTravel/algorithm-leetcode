package OOD.Implementation;

/**
 * A sample of singleton class.
 *
 * @author BorisMirage
 * Time: 2019/10/23 11:11
 * Created with IntelliJ IDEA
 */

public class SingletonSample {
    private static final SingletonSample singletonInstance = new SingletonSample();

    /**
     * Constructor of singleton class.
     */
    private SingletonSample() {
        // constructor of singleton class
    }

    /**
     * Return the singleton instance. In this way to assure the uniqueness in memory of the class.
     *
     * @return singleton instance
     */
    public static synchronized SingletonSample getInstance() {
        if (singletonInstance == null) {
            return new SingletonSample();
        }
        return singletonInstance;
    }
}
