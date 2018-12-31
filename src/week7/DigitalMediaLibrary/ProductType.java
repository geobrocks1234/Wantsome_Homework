package week7.DigitalMediaLibrary;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of all possible product types.
 */
public enum ProductType {

    BOOK("book"),
    VIDEO("video"),
    MP3("mp3");

    private static Map<String, ProductType> map = new HashMap<>();

    static {
        for (ProductType productType : ProductType.values()) {
            map.put(productType.type, productType);
        }
    }

    public final String type;

    ProductType(final String type) {
        this.type = type;
    }

    public static ProductType keyOf(String type) {
        return map.get(type);
    }

    /**
     * Get the product type as a string.
     *
     * @return The product type as a string.
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString () {
        return "ProductType{" +
                "type='" + type + '\'' +
                '}';
    }
}
