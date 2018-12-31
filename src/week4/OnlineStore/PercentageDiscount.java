package week4.OnlineStore;

public class PercentageDiscount extends Discount {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    double discountToApplyOn(double price) {
        return price - price*percentage/100;
    }

    @Override
    public String toString() {
        return "PercentageDiscount{" +
                "percentage=" + percentage + "%" +
                '}';
    }
}
