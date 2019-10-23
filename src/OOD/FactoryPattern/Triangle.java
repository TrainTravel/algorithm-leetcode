package OOD.FactoryPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 16:30
 * Created with IntelliJ IDEA
 */

public class Triangle extends Shape {
    // attributes
    public Triangle() {
        super("Triangle");
    }

    @Override
    public void draw() {

        // draw triangle operation
        System.out.println("Draw " + shapeName);
    }
}
