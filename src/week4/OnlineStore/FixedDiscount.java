package week4.OnlineStore;

public class FixedDiscount extends Discount {
    private double amount;

    public FixedDiscount(double amount){
        this.amount = amount;
    }

    @Override
    double discountToApplyOn(double price) {
        return price - amount;
    }

    @Override
    public String toString() {
        return "FixedDiscount{" +
                "amount=" + amount +
                '}';
    }
}
