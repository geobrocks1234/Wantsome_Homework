package week4.OnlineStore;

public class CartTest {
    public static void main(String[] args) throws Exception {
        Customer cust = new Customer( "Ionel" , "Popescu" , "1234" , new Address( "Popauti" , 1 , "Iasi" ));
        Cart cart = new Cart(cust);
        cart.addProduct( new Product( 1 , "p1" , "phone" , 190.99 , "blue" ));
        cart.addProduct( new Product( 2 , "p2" , "watch" , 49.99 , "black" ));
        Product p3 = new Product( 3 , "p3" , "hat" , 99.99 , "white" );
        cart.addProduct(p3);
        System. out .println( "Before discounts: \n" + cart.generateInvoice());
        cart.addDiscount( new FixedDiscount( 100 ));
        Discount d2 = new PercentageDiscount( 5 );
        cart.addDiscount(d2);
        System. out .println( "\nAfter discounts: \n" + cart.generateInvoice());
        //replacing a product
        cart.removeProduct(p3);
        cart.addProduct( new Product( 4 , "p4" , "gloves" , 29.99 , "brown" ));
        //replacing a discount
        cart.removeDiscount(d2);
        cart.addDiscount( new PercentageDiscount( 15 ));
        System. out .println( "\nAfter replacing a product and a discount: \n" + cart.generateInvoice());
    }
}
