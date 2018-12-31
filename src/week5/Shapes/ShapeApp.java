package week5.Shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeApp {

    public static void main(String[] args) {
        List<Shape> shapes = detectShapes(args);
        System.out.println("Detected " + shapes.size() + " shapes, drawing them: ");
        for(Shape shape: shapes){
            shape.draw();
        }
        System.out.println("...done detecting shapes.");
    }

    public static List<Shape> detectShapes(String[] args){

        List<Shape> builtShapes = new ArrayList<>();
        System.out.println("Received an array of " + args.length + " arguments, trying to understand them: " + Arrays.toString(args));

        int i = 0;
        while(i < args.length) {

            String arg = args[i];
            System.out.println(" - Checking arg: " + arg + "' ...");

            ShapeType shapeType = tryRecognizeShapeType(arg);

            if(shapeType == null) {
                System.out.println(" - Unknown shape type, ignoring it: " + arg + "'");
                i++;
            } else {
                int expectedNumberOfParams = shapeType.getNumberOfRequiredParams();
                List<Double> shapeParams = new ArrayList<>();
                int j = i+1;
                try {

                    while(j <= i+expectedNumberOfParams){
                        if(j>=args.length) {
                            throw new IllegalArgumentException("Not enough shape params");
                        }
                        String stringValue = args[j];
                        double numberValue = Double.valueOf(stringValue);
                        shapeParams.add(numberValue);
                        j++;

                    }

                    System.out.println("   - Detected shape of type " + shapeType + ", with params: " + shapeParams);

                    Shape newShape = ShapeCreator.create(shapeType, shapeParams);
                    builtShapes.add(newShape);

                } catch(NumberFormatException e){
                    System.out.println("This shape is skipped.");
                } catch (ShapeNotSupportedException | IllegalArgumentException e){

                    System.out.println("   -> Failed to build a Shape, has invalid type or params: " +
                            "type= " + shapeType + ", params= " + shapeParams +
                            ", error message: " + e.getMessage());
                }

                i=j;
            }
        }
        System.out.println("Done, found " + builtShapes.size() + " shape: " + builtShapes + "\n");
        return builtShapes;
    }

    private static ShapeType tryRecognizeShapeType(String arg) {

        try {
            return ShapeType.valueOf(arg.toUpperCase());
        } catch(IllegalArgumentException e) {
            System.out.println("Wrong shape type: "+arg);
        }

        return null;
    }
}
