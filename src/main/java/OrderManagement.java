import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrderManagement {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter textWriter = new PrintWriter(System.out);

        /**

         Input:

         9
         Order-1 49
         Order-2 31
         Order-3 74
         Order-4 21
         Order-5 64
         Order-6 94
         Order-7 23
         Order-8 23
         Order-9 71


         Output:
         Total Amount: 319
         Expensive Category Discount: 131
         Order-1 (1 items)
         Order-2 (1 items)
         Order-3 (1 items)
         Order-4 (1 items)
         Order-5 (1 items)
         Order-6 (1 items)
         Order-7 (1 items)
         Order-8 (1 items)
         Order-9 (1 items)

         * */
        IOrderSystem orderSystem = new OrderSystem();
        int oCount = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= oCount; i++) {
            String[] a = br.readLine().trim().split(" ");
            IOrder e = new Order();
            e.setName(a[0]);
            e.setPrice(Integer.parseInt(a[1]));
            orderSystem.addToCart(e);
        }
        int totalAmount = orderSystem.calculateTotalAmount();
        textWriter.println("Total Amount: " + totalAmount);

        Map<String, Integer> categoryDiscounts = orderSystem.categoryDiscounts();
        for (Map.Entry<String, Integer> entry : categoryDiscounts.entrySet()) {
            if (entry.getValue() > 0) {
                textWriter.println(entry.getKey() + " Category Discount: " + entry.getValue());
            }
        }

        Map<String, Integer> cartItems = orderSystem.cartItems();
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            textWriter.println(entry.getKey() + " (" + entry.getValue() + " items)");
        }

        textWriter.flush();
        textWriter.close();
    }
}

interface IOrder {

    void setName(String name);

    String getName();

    void setPrice(int price);

    int getPrice();
}

interface IOrderSystem {

    void addToCart(IOrder order);

    void removeFromCart(IOrder order);

    int calculateTotalAmount();

    Map<String, Integer> categoryDiscounts();

    Map<String, Integer> cartItems();
}

class Order implements IOrder {

    String name;

    int price;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}

class OrderSystem implements IOrderSystem {

    private static final String CHEAP = "Cheap";

    private static final String MODERATE = "Moderate";

    private static final String EXPENSIVE = "Expensive";

    private Map<IOrder, Integer> cart;

    private Map<String, Integer> categoryDiscountMap;

    private Map<String, Integer> cartItems;

    // private int totalAmount;

    public OrderSystem() {
        this.cart = new HashMap<>();
        this.categoryDiscountMap = new TreeMap<>();
        this.cartItems = new TreeMap<>();
    }

    public void addToCart(IOrder order) {
        cart.put(order, cart.getOrDefault(order, 0) + 1);
        cartItems.put(order.getName(), cartItems.getOrDefault(order.getName(), 0) + 1);
    }

    public void removeFromCart(IOrder order) {
        int count = cartItems.get(order.getName());
        if (count == 1) {
            // cart.remove(order);
            cartItems.remove(order.getName());
        } else {
            // cart.put(order, count - 1);
            cartItems.put(order.getName(), count - 1);
        }
    }

    public int calculateTotalAmount() {
        int total = 0;
        for (IOrder order : cart.keySet()) {

            String category = getCategory(order.getPrice());
            int discount = getDiscountPercentage(order.getPrice());
            int totalDiscount = categoryDiscountMap.getOrDefault(category, 0);
            int discountAmount = (order.getPrice() * discount / 100);
            int discountedAmount = order.getPrice() - discountAmount;
            totalDiscount += discountAmount;
            categoryDiscountMap.put(category, totalDiscount);

            total += discountedAmount * cart.get(order);
        }
        return total;
    }

    public Map<String, Integer> categoryDiscounts() {
        return categoryDiscountMap;
    }

    public Map<String, Integer> cartItems() {
        return cartItems;
    }

    private String getCategory(int orderAmount) {
        if (orderAmount <= 10) { // cheap
            return CHEAP;
        } else if (orderAmount <= 20 && orderAmount > 10) {
            return MODERATE;
        }
        return EXPENSIVE;
    }

    private int getDiscountPercentage(int orderAmount) {
        if (orderAmount <= 10) { // cheap
            return 10;
        } else if (orderAmount <= 20 && orderAmount > 10) {
            return 20;
        }
        return 30;
    }
}


