import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    //Abstraction is a process of hiding the implementation details and showing only functionality to the user.
    private String name;
    private int  id;
    //access modifier
    public Employee(String name,int id){
    //constutor
        this.name=name;
        this.id=id;

    }
    //Encapsulation
    public String getName(){
        return name;

    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();

    //polymorphism

    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+", salary="+calculateSalary()+"]";
    }
}
 class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary =monthlySalary;
    }

        @Override
        public double calculateSalary(){
            return monthlySalary;
        
    }
 }

 class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
 }

 class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main{
    public static void main(String [] args){
        PayrollSystem payrollSystem =new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas", 1, 7000);
        PartTimeEmployee emp2 = new PartTimeEmployee( "Alex", 2, 40, 100);
        
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    
    }  


}