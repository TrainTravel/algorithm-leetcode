package OOD.DependencyInjectionPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 15:33
 * Created with IntelliJ IDEA
 */

public class ServerA implements ServerInterface {
    private String serverName;

    public ServerA(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public void processRequest() {
        System.out.println("This is Server A and its name is : " + serverName);
    }
}
