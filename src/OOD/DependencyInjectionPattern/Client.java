package OOD.DependencyInjectionPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 15:36
 * Created with IntelliJ IDEA
 */

public class Client {
    private ServerInterface server;

    public Client(ServerInterface server) {
        this.server = server;       // dependency injection
    }

    public void processRequest() {
        this.server.processRequest();
    }
}
