package OOD.FactoryPattern;

/**
 * @author BorisMirage
 * Time: 2019/10/23 16:31
 * Created with IntelliJ IDEA
 */

public class Cycle extends Shape {
    // attributes
    public Cycle() {
        super("Cycle");
    }

    @Override
    public void draw() {

        // draw triangle operation
        System.out.println("Draw " + shapeName);
    }
}
