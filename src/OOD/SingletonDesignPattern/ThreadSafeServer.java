package OOD.SingletonDesignPattern;

/**
 * Thread-safe server instance.
 *
 * @author BorisMirage
 * Time: 2019/10/23 14:23
 * Created with IntelliJ IDEA
 */

public class ThreadSafeServer {
    private static ThreadSafeServer INSTANCE = null;

    protected ThreadSafeServer() {
        // add constructor here...
    }

    public static ThreadSafeServer getInstance() {
        if (INSTANCE == null) {     // DOUBLE CHECK NULL!

            synchronized (ThreadSafeServer.class) {     // add lock
                if (INSTANCE == null) {
                    INSTANCE = new ThreadSafeServer();
                }
            }
        }

        return INSTANCE;
    }
}
