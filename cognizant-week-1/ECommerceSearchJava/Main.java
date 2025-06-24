import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args){
        Product[] products = {
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "Laptop", "Electronics"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "T-shirt", "Clothing")
        };

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("Linear Search:");
        Product found = linearSearch(products, 104);
        if (found != null)
            System.out.println("Found: " + found.getProductName());
        else
            System.out.println("Product not found");

        System.out.println("\nBinary Search:");
        found = binarySearch(products, 104);
        if (found != null)
            System.out.println("Found: " + found.getProductName());
        else
            System.out.println("Product not found");
    }

    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midId = products[mid].getProductId();

            if (midId == id) {
                return products[mid];
            } else if (midId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}
