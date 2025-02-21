public abstract class Employee implements Printable{
   private String employeeId;
   private String employeeName;
   private String designation;
   private double salary;

   // Passing parameters with constructor

   public Employee(String employeeId, String employeeName, String designation, double salary){
    // Throw exception for negative salary
    if (salary<0){ 
        throw new IllegalArgumentException("Salary can not be negative."); // Handling negative salary
    }
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.designation = designation;
    this.salary = salary;
    }

    // Abstract Method for calculating Bonus

    public abstract double calculateBonus();

    // Public Getters for accessing private variables

    public String getEmployeeId(){
        return employeeId;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public double getSalary(){
        return salary;
    }
    public String getDesignation(){
        return designation;
    }
}
