import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Encapsulation and List for getting different data list
    private static final Scanner sc = new Scanner(System.in); //finalize name for all scanners
    private static List<Customer> customers = new ArrayList<>();
    private static List<Menu> menuItems = new ArrayList<>();
    private static List<Orders> orders = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        // Getting All saved data for Menu, Customer, Employee

        MenuItems();
        CustomerList();
        employeeList();
        
        while(true) {
            System.out.println("\n===OO=== Red Cherry Sweets ===OO===");
            System.out.println("1. Customer List");
            System.out.println("2. Menu Items");
            System.out.println("3. Order Management");
            System.out.println("4. Employee Details");
            System.out.println("5. View Reports");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
        
        // Handling exception with try-catch
            try {
                int choice = Integer.parseInt(sc.nextLine());

        // switch- case used for selection of different menu
                
                switch(choice) {
                    case 1 : listCustomers();
                    break;
                    case 2 : listMenu();
                    break;
                    case 3 : manageOrders();
                    break;
                    case 4 : listEmployees();
                    break;
                    case 5 : generateReports();
                    break;
                    case 6 : System.exit(0);
                    default : System.out.println("Invalid choice!");
                }
            } 
            
            // Exception for selected cases if 0 or more than 6
            catch(NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // Predefined Customer List
    private static void CustomerList() {
        customers.add(new Customer("C001", "Mr. Shahidul Islam", "+8801548542"));
        customers.add(new Customer("C002", "Mr Rafi Amin", "+88014825644"));
        customers.add(new Customer("C003", "Mr. Sabbir Ahmed", "+88018648254"));
        customers.add(new Customer("C004", "Mr. Shafikul Ahammed", "+8801975855"));
    }

    // Print each customer details

    private static void listCustomers() {
        System.out.println("\n === List of Customers ===");
        customers.forEach(Customer::printDetails);
    }

    
    // Initialize Menu Items

    private static void MenuItems() {
        menuItems.add(new Menu("M001", "Burger", 499));
        menuItems.add(new Menu("M002", "Sandwich", 399));
        menuItems.add(new Menu("M003", "Hot Dog", 229));
        menuItems.add(new Menu("M004", "Pizza", 600));
        menuItems.add(new Menu("M005", "Cake", 1399));
        menuItems.add(new Menu("M006", "Coffee", 350));
        menuItems.add(new Menu("M007", "Soft Drink", 80));
    }

    // Print each menu Items
    private static void listMenu() {
        System.out.println("\n === Menu Item List === ");
        menuItems.forEach(item -> 
        System.out.println(item.getFoodName() + " - BDT " + item.getPrice() + " TAKA"));
        }

    // Order Management

    private static void manageOrders() {
        System.out.println("\n1. Place Order\n2. View Orders");
        System.out.println("Enter choice: ");
        String menuChoice = sc.nextLine();
        
        switch(menuChoice) {
            case "1" :
             placeOrder();
             break;
            case "2" :
             orders.forEach(Orders::printDetails);
             break;
            default :
             System.out.println("Invalid choice!");
        }
    }

    // Method for placing order

    private static void placeOrder() {
        try {
            System.out.println("Order Id: ");
            String orderId = sc.nextLine();
            System.out.println("Customer ID: ");
            String customerId = sc.nextLine();
            
            Orders order = new Orders(orderId, customerId);
            boolean addingItems = true;

    // Adding items in Ordered Item

            while(addingItems) {
                System.out.println("\nCurrent Menu:");
                menuItems.forEach(item ->
                    System.out.println("\n - " + item.getFoodName() + " (BDT" + item.getPrice() + "TAKA)"));
                System.out.println("Enter food name: (Enter 'done' when finished.)");
                String choice = sc.nextLine();
                if(choice.equalsIgnoreCase("done")) {
                    addingItems = false;
                } else {
                    Menu item = findFoodItem(choice);
                    if(item != null) {
                        order.addItem(item);
                        System.out.println(item.getFoodName() + " added to order!");
                    } else {
                        System.out.println("Item not found in menu!");
                    }
                }
            }
            orders.add(order);
            System.out.println("Order placed successfully!");
        } 
        //Exception for Invalid order name

        catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Get exception from thrown exception in orders class
        }
    }

    // A method for finding food Item in Menu.

    public static Menu findFoodItem(String name) {
        for(Menu item : menuItems) {
            if(item.getFoodName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    // Initializing Employees

    private static void employeeList(){
        employees.add(new Manager("M35", "Mr. Saif Ullah", "Manager", 40000));
        employees.add(new Waiter("W301", "Mr. Rubel Chowdhury", "Waiter", 20000));
        employees.add(new Waiter("W302", "Mr. Abdullah", "Waiter", 18000));
        employees.add(new Waiter("W303", "Mr. Sojib Rahman", "Cashier", 15000));
        employees.add(new Waiter("W304", "Mr. Abdul Motin", "Chef", 25000));
        employees.add(new Waiter("W305", "Mr. Md Shahin ", "Assitant Cook", 18000));
    }

    // Print each employee details
    private static void listEmployees() {
        System.out.println("\n === Employees List === \n");
        employees.forEach(Employee::printDetails);
        }
    

    // Generating reports for customer, employees, orders

    private static void generateReports() {
        System.out.println("\n=== Customers ===");
        customers.forEach(Customer::printDetails);
        
        System.out.println("\n=== Employees ===");
        employees.forEach(Employee::printDetails);
        
        System.out.println("\n=== Orders ===");
        orders.forEach(Orders::printDetails);
    }
}