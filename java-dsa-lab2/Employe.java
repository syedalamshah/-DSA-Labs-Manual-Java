// Task #02: Simple Employee Class
class Employee {
    String firstName;
    String lastName;
    int salary;
    
    // Constructor
    Employee(String first, String last, int s) {
        firstName = first;
        lastName = last;
        if (s > 0) {
            salary = s;
        } else {
            salary = 0;
        }
    }
    
    // Get yearly salary
    int yearlySalary() {
        return salary * 12;
    }
    
    // Give raise
    void raise() {
        salary = salary + (salary / 10);
    }
}

// Test
public class Employe {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Doe", 5000);
        Employee e2 = new Employee("Jane", "Smith", 6000);
        
        System.out.println(e1.firstName + " yearly: " + e1.yearlySalary());
        System.out.println(e2.firstName + " yearly: " + e2.yearlySalary());
        
        e1.raise();
        e2.raise();
        
        System.out.println("After raise:");
        System.out.println(e1.firstName + " yearly: " + e1.yearlySalary());
        System.out.println(e2.firstName + " yearly: " + e2.yearlySalary());
    }
}