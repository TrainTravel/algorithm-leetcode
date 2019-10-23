package OOD.DependencyInjectionPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 15:37
 * Created with IntelliJ IDEA
 */

public class DependencyInjectionPattern {
    public static void main(String[] args) {
        Client clientA = new Client(new ServerA("Server A"));
        clientA.processRequest();
        Client clientB = new Client(new ServerB("Sever B"));
        clientB.processRequest();
    }
}
