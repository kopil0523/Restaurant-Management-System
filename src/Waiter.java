// Subclass Manager inherits from Employee super class

public class Waiter extends Employee{

    // Conustructor for getting data super keyword is for accessing parent class parameters


    Waiter(String employeeId, String employeeName,String designation, double salary){
        super(employeeId, employeeName, designation, salary);
    }

    //Polymorphism usage of Override calculatebonus for waiter

    @Override
        public double calculateBonus() {
            double salary = getSalary();
            return (salary * 10) / 100;
        }
    
    // Override printdetails from Printable implemented by parent class for printing Manager Details

    @Override
    public void printDetails() {
        System.out.println("Waiter ID: " + getEmployeeId());
        System.out.println("Name: " + getEmployeeName());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Salary: BDT" + getSalary() + "TK");
        System.out.println("Bonus: BDT" + calculateBonus() + "TK \n");
    }
}
