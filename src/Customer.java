// Customer class implements from Printable Interface

public class Customer implements Printable {

    // All variables are private to maintain Encapsulation.

    private final String customerId;
    private String custName;
    private String phoneNumber;
    
    //Constructor to pass parameters

    public Customer(String customerId, String custName, String phoneNumber) {

        // Throw exception for null or empty input
        if (customerId == null || customerId.isEmpty() || custName == null || custName.isEmpty()) {
            throw new IllegalArgumentException("Customer ID/Name cannot be null or empty."); // Handling null or empty values
        }

        this.customerId = customerId;
        this.custName = custName;
        this.phoneNumber = phoneNumber;
    }

    // Override printdetails to print Customer Data

    @Override
    public void printDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + custName);
        System.out.println("Phone:" + phoneNumber  + "\n");
    }
}