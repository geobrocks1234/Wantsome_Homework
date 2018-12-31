package week5.Shapes;

import java.util.List;

public class ShapeCreator {
    public static Shape create(ShapeType shapeType, List<Double> shapeParams) throws ShapeNotSupportedException {
        switch(shapeType){
            case CIRCLE:
                return new Circle(shapeParams.get(0));

            case RECTANGLE:
                return new Rectangle(shapeParams.get(0), shapeParams.get(1));

            default: throw new ShapeNotSupportedException("Not supported yet: " + shapeType + "!");
        }
    }
}
