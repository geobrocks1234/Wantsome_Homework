package week4.OnlineStore;
import java.util.ArrayList;

public class Cart {
    private Customer customer;
    private ArrayList<Product> products;
    private ArrayList<Discount> discounts;

    public Cart(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    void addProduct(Product p){
        products.add(p);
    }

    void removeProduct(Product p){
        products.remove(p);
    }

    void addDiscount(Discount d){
        discounts.add(d);
    }

    void removeDiscount(Discount d){
        discounts.remove(d);
    }

    double computeProductsPrice(){
        double sum = 0;
        for (Product product:products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    double computeTotalPrice() throws Exception {
        double totalPrice = computeProductsPrice();
        //double totalDiscount = computeDiscounts();
        for (Discount discount:discounts) {
            totalPrice = discount.discountToApplyOn(totalPrice);
        }
        if(totalPrice <= 0){
            System.out.println("We apologize, but the net price is less than or equal to 0.00! Something went wrong.");
            System.out.println("Please contact our support team.");
        }
        else{
            return roundAvoid(totalPrice, 2);
        }
        throw new Exception ("The discount price is greater than total price!");
    }

    String toStringDiscounts(){
        String str = "";
        for(Discount d : discounts) {
            str += "\n" + "-" +d.toString();
        }
        return str;
    }

    String toStringProducts(){
        String str = "";
        for(Product p: products) {
            str += p.toString();
        }
        return str;
    }

    String generateInvoice() throws Exception {
        return "===============================================\n"+"INVOICE:\n"+this.customer.toString()+"\nProducts:"+toStringProducts()+
                "\n-----------------------------------------------\n"+"Products price: "+computeProductsPrice()+"\nDiscounts: "+ toStringDiscounts() +
                "\n-----------------------------------------------\n"+"TOTAL: "+computeTotalPrice()+"\n===============================================";
    }
}