// Menu Class for Item Menu
public class Menu {
    
    // Private for Encapsulation

    private String foodId;
    private String foodName;
    private double price;

    // Passing parameter with Constructor

    public Menu(String foodId, String foodName, double price){

        // Throw exception for Negative Price
        if (price < 0){ throw new IllegalArgumentException("Price cannot be negative."); // Handling negative price
        }
        
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
    }

    // Getters for accessing from Other classes

    public String getFoodId(){
        return foodId;
    }
    public String getFoodName(){
        return foodName;
    }
    public double getPrice(){
        return price;
    }
}

