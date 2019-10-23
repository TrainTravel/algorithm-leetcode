package OOD.FactoryPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 16:34
 * Created with IntelliJ IDEA
 */

public class DrawingClient {
    public DrawingClient() {
    }

    public void draw(ShapeType type) throws Exception {
        Shape shape = ShapeFactory.createShape(type);
        shape.draw();
    }
}
