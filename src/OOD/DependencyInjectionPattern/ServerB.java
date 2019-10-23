package OOD.DependencyInjectionPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 15:36
 * Created with IntelliJ IDEA
 */

public class ServerB implements ServerInterface {
    private String serverName;

    public ServerB(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public void processRequest() {
        System.out.println("This is Server B and its name is : " + serverName);
    }
}