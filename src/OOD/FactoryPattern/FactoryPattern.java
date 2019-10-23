package OOD.FactoryPattern;

/**
 * Main entry of factory mode.
 *
 * @author BorisMirage
 * Time: 2019/10/23 16:35
 * Created with IntelliJ IDEA
 */

public class FactoryPattern {
    public static void main(String[] args) throws Exception {
        DrawingClient client = new DrawingClient();
        client.draw(ShapeType.Triangle);
        client.draw(ShapeType.Cycle);
    }
}
