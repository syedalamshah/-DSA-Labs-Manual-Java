import java.util.Scanner;

// ContactApp - Array Operations for DSA Lab
public class ContactApp {
    private String[][] contacts;
    private int size, capacity;
    
    public ContactApp(int capacity) {
        this.capacity = capacity;
        this.contacts = new String[capacity][2];
        this.size = 0;
    }
    
    // 1. TRAVERSAL - O(n)
    public void displayAllContacts() {
        if (size == 0) {
            System.out.println("No contacts!");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "] " + contacts[i][0] + " -> " + contacts[i][1]);
        }
    }
    
    // 2. SEARCHING - O(n)
    public void searchContact(String name) {
        for (int i = 0; i < size; i++) {
            if (contacts[i][0].equalsIgnoreCase(name)) {
                System.out.println("Found: " + contacts[i][0] + " -> " + contacts[i][1] + " at position " + i);
                return;
            }
        }
        System.out.println("Contact not found!");
    }
    
    // 3. INSERTION - O(n)
    public void addContact(String name, String number, int position) {
        if (size >= capacity || position < 0 || position > size) {
            System.out.println("Cannot add contact!");
            return;
        }
        
        // Shift elements right
        for (int i = size; i > position; i--) {
            contacts[i][0] = contacts[i-1][0];
            contacts[i][1] = contacts[i-1][1];
        }
        
        contacts[position][0] = name;
        contacts[position][1] = number;
        size++;
        System.out.println("Contact added!");
    }
    
    // 4. UPDATE - O(n)
    public void updateContact(String oldName, String newName) {
        for (int i = 0; i < size; i++) {
            if (contacts[i][0].equalsIgnoreCase(oldName)) {
                contacts[i][0] = newName;
                System.out.println("Contact updated!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }
    
    // 5. DELETION - O(n)
    public void deleteContact(String name) {
        for (int i = 0; i < size; i++) {
            if (contacts[i][0].equalsIgnoreCase(name)) {
                // Shift elements left
                for (int j = i; j < size - 1; j++) {
                    contacts[j][0] = contacts[j + 1][0];
                    contacts[j][1] = contacts[j + 1][1];
                }
                size--;
                System.out.println("Contact deleted!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactApp app = new ContactApp(5);
        
        while (true) {
            System.out.println("\n1.Display 2.Search 3.Add 4.Update 5.Delete 0.Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1: 
                    app.displayAllContacts(); 
                    break;
                case 2: 
                    System.out.print("Name: ");
                    app.searchContact(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Number: ");
                    String number = sc.nextLine();
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    app.addContact(name, number, pos);
                    break;
                case 4:
                    System.out.print("Old name: ");
                    String oldName = sc.nextLine();
                    System.out.print("New name: ");
                    String newName = sc.nextLine();
                    app.updateContact(oldName, newName);
                    break;
                case 5:
                    System.out.print("Name to delete: ");
                    app.deleteContact(sc.nextLine());
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}