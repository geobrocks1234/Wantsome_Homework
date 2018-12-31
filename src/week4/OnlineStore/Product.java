package week4.OnlineStore;

public class Product {
    private int id;
    private String name;
    private String type;
    private String color;
    private double price;

    public Product(int id, String name, String type, double price, String color) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n-Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
