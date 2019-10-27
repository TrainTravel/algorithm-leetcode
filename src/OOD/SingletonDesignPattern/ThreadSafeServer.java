package OOD.SingletonDesignPattern;

/**
 * Thread-safe server instance.
 * Key point:
 * 1. Use protected keyword to make it inheritable.
 * 2. Double check null. If the instance is null, then add lock. Do not add lock at each null check to reduce time.
 *
 * @author BorisMirage
 * Time: 2019/10/23 14:23
 * Created with IntelliJ IDEA
 */

public class ThreadSafeServer {
    private static ThreadSafeServer INSTANCE;

    protected ThreadSafeServer() {
        // add constructor here...
    }

    /**
     * To reduce the lock usage and reduce the time consume, double check null.
     *
     * @return thread safe server object instance
     */
    public static ThreadSafeServer getInstance() {
        if (INSTANCE == null) {     // check if is null without lock

            synchronized (ThreadSafeServer.class) {     // if instance is null, add lock to avoid race condition
                if (INSTANCE == null) {
                    INSTANCE = new ThreadSafeServer();
                }
            }
        }

        return INSTANCE;
    }
}
