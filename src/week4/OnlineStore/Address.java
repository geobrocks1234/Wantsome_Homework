package week4.OnlineStore;

public class Address {
    private String street;
    private int streetNo;
    private String town;

    public Address(String street, int streetNo, String town) {
        this.street = street;
        this.streetNo = streetNo;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streetNo=" + streetNo +
                ", town='" + town + '\'' +
                '}';
    }
}
