import java.util.ArrayList;
import java.util.List;

public class Orders implements Printable{
    
    //Private data members for encapsulation

    private String orderId;
    private String customerId;
    private List<Menu> orderedItems;
    private double totalPrice;

    // Constructor for passing parameters

    public Orders(String orderId, String customerID){
        this.orderId = orderId;
        this.customerId = customerID;
        this.orderedItems = new ArrayList<>();
    }

    // Method for adding Item in the Menu Item List

    public void addItem(Menu item){
        // Throw exception for null items
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null"); // Handling null values
        }
        orderedItems.add(item);
        totalPrice += item.getPrice();
    }

    // Override Pritable interface for Order Details
    @Override
    public void printDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Total: BDT " + totalPrice + " TAKA \n");
        System.out.println("Items:");
        orderedItems.forEach(item -> System.out.println("- " + item.getFoodName() + " (BDT " + item.getPrice() + "TAKA)"));
    }
}
