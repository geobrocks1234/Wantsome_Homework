package Shapes;

import org.junit.Test;
import week5.Shapes.Circle;
import week5.Shapes.Rectangle;
import week5.Shapes.Shape;
import week5.Shapes.ShapeApp;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShapeAppTest {

    @Test
    public void testDetectValidShapes() {

        String[] args = {"Circle", "2", "RECTangle", "4", "5"};
        List<Shape> shapes = ShapeApp.detectShapes(args);

        assertEquals(2, shapes.size());
        assertEquals(new Circle (2), shapes.get(0));
        assertEquals(new Rectangle (4, 5), shapes.get(1));

    }

    @Test
    public void testUnknownShapes() {
        String[] args = {"Triangle", "2"};
        List<Shape> shapes = ShapeApp.detectShapes(args);
        assertTrue(shapes.isEmpty());
    }

    @Test
    public void testShapeWithNotEnoughParams() {
        String[] args = {"Rectangle", "2"}; //one more value is missing, as rectangle needs 2 params
        List<Shape> shapes = ShapeApp.detectShapes(args);
        assertEquals(0, shapes.size());
    }

    @Test
    public void testShapeWithParamsNotNumbers() {
        String[] args = {"Rectangle", "2", "??", "Circle", "3"}; //2nd param of rectangle is not a number!
        List<Shape> shapes = ShapeApp.detectShapes(args);
        assertEquals(1, shapes.size());
        assertEquals(new Circle(3), shapes.get(0));
    }

    @Test
    public void testInvalidShapeTypeOrParam() {
        String[] args = {"Square", "3"};
        List<Shape> shapes = ShapeApp.detectShapes(args);
        assertTrue(shapes.isEmpty());
    }
}