package week4.OnlineStore;
import java.util.ArrayList;

public class Customer {
    private ArrayList<Address> addresses = new ArrayList<>();
    private String firstname;
    private String lastname;
    private String cnp;

    public Customer(String firstname, String lastname, String cnp, Address addresses) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cnp = cnp;
        this.addresses.add(addresses);
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "addresses=" + addresses +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}