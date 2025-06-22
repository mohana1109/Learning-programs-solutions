import java.util.Arrays;
import java.util.Comparator;
public class SearchDemo {

    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Mobile", "Electronics"),
            new Product(105, "Bag", "Travel")
        };

 
        System.out.println("Linear Search Result:");
        Product found = linearSearch(products, "Watch");
        System.out.println(found != null ? found : "Product not found");

        Arrays.sort(products, Comparator.comparing((Product p) -> p.productName));
        

        System.out.println("\nBinary Search Result:");
        found = binarySearch(products, "Watch");
        System.out.println(found != null ? found : "Product not found");
    }
}