package OOD.FactoryPattern;

/**
 * Abstract class of shape. The implemented class extends this basic class and implement the draw method.
 *
 * @author BorisMirage
 * Time: 2019/10/23 16:29
 * Created with IntelliJ IDEA
 */

abstract class Shape {
    protected String shapeName;

    /**
     * Initialize the shape.
     *
     * @param shapeName name of shape, could be cycle or triangle (in shape type enum)
     */
    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    /**
     * Draw the corresponding type.
     */
    public abstract void draw();
}
