package week6.BuildingAverages;

public class Building {

    private String name;
    private Category category;
    private double price;
    private String neighbourhood;

    public Building(String name, String neighbourhood, double price, Category category){
        this.name = name;
        this.neighbourhood = neighbourhood;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", neighbourhood='" + neighbourhood + '\'' +
                '}';
    }
}
