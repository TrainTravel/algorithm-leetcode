package OOD.FactoryPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 16:32
 * Created with IntelliJ IDEA
 */

public class ShapeFactory {
    public static Shape createShape(ShapeType type) throws Exception {
        switch (type) {
            case Cycle:
                return new Cycle();
            case Triangle:
                return new Triangle();
            default:
                throw new Exception("Incorrect input type");
        }
    }
}
