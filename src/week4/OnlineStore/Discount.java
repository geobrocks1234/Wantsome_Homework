package week4.OnlineStore;

public abstract class Discount {
    private double discount;

    abstract double discountToApplyOn(double price);

    public double getDiscount() {
        return discount;
    }
}

