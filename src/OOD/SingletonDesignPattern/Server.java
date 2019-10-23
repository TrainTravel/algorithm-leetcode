package OOD.SingletonDesignPattern;

/**
 * Server instance, not thread-safe.
 *
 * @author BorisMirage
 * Time: 2019/10/23 14:21
 * Created with IntelliJ IDEA
 */

public class Server {
    private static Server INSTANCE = null;

    protected Server() {
        // add constructor here...
    }

    public Server getInstance() {
        if (INSTANCE == null) {     // lazy init, used in most case
            return new Server();
        }
        return INSTANCE;
    }
}
