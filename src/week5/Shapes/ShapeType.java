package week5.Shapes;

public enum ShapeType {

    SQUARE(1), CIRCLE(1), RECTANGLE(2);

    private int numberOfRequiredParams;

    ShapeType(int numberOfRequiredParams){
        this.numberOfRequiredParams = numberOfRequiredParams;
    }

    public int getNumberOfRequiredParams() {
        return numberOfRequiredParams;
    }

}
