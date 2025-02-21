// Subclass Manager inherits from Employee super class

public class Manager extends Employee{
    
    // Conustructor for getting data super keyword is for accessing parent class parameters

    Manager(String employeeId, String employeeName, String designation, double salary) {
        super(employeeId, employeeName, designation, salary);
    }

    //Polymorphism usage of Override calculatebonus for Manager

    @Override
    public double calculateBonus() {
        double salary = this.getSalary();
        return (salary * 20) / 100;
    }

    // Override printdetails from Printable implemented by parent class for printing Manager Details

    @Override
    public void printDetails() {
        System.out.println("Manager ID: " + getEmployeeId());
        System.out.println("Name: " + getEmployeeName());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Salary: BDT " + getSalary() + "TK");
        System.out.println("Bonus: BDT " + calculateBonus() + "TK \n");
    }
}
