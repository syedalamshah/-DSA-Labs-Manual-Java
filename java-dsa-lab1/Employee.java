import java.util.*;

class Main {
    ArrayList<String> emp = new ArrayList<>();
    
    void main() {
        System.out.println("This employee is working");
        emp.add("John");
        emp.add("Alice");
        System.out.println("Employees: " + emp);
    }
}

class MenuBuilder {
    Stack<String> history = new Stack<>();
    
    // Non-static method
    void addHistory(String msg) {
        history.push(msg);
        System.out.println("Added: " + msg);
    }
    
    // Static method  
    static void showMenu() {
        System.out.println("1. Add  2. Show  3. Exit");
    }
}

public class Employee {
    public static void main(String[] args) {
        Main obj = new Main();
        MenuBuilder menu = new MenuBuilder();
        
        obj.main();
        
        MenuBuilder.showMenu();
        menu.addHistory("Employee added");
    }
}