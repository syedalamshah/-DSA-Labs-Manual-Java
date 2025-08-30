// Node class - Train car that holds data and connection
class Node<T> {
    T data;
    Node<T> next;
    
    Node(T data) { 
        this.data = data; 
        this.next = null; 
    }
}

// Generic Linked List - Student Registration System  
class GenericLinkedList<T> {
    private Node<T> head;
    private int size;
    
    public GenericLinkedList() { head = null; size = 0; }
    
    // Task #1: Check if registration queue is empty
    public boolean isEmpty() { 
        return head == null; 
    }
    
    // Task #2: Get total registered students
    public int getSize() { 
        return size; 
    }
    
    // Task #3: Add priority student (VIP at front)
    public void insertAtFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // Task #4: Add regular student (queue at end)
    public void insertAtLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
    }
    
    // Task #5: Insert at waitlist position
    public void insertAtPosition(int pos, T data) {
        if (pos < 0 || pos > size) throw new IndexOutOfBoundsException();
        if (pos == 0) { insertAtFirst(data); return; }
        
        Node<T> newNode = new Node<>(data);
        Node<T> temp = head;
        for (int i = 0; i < pos - 1; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    
    // Task #6: Process first student (remove from front)
    public T deleteFirst() {
        if (isEmpty()) throw new RuntimeException("No students to process");
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    // Task #7: Cancel last registration
    public T deleteLast() {
        if (isEmpty()) throw new RuntimeException("No students registered");
        if (head.next == null) return deleteFirst();
        
        Node<T> temp = head;
        while (temp.next.next != null) temp = temp.next;
        T data = temp.next.data;
        temp.next = null;
        size--;
        return data;
    }
    
    // Task #8: Remove student from specific position
    public T deleteAtPosition(int pos) {
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();
        if (pos == 0) return deleteFirst();
        
        Node<T> temp = head;
        for (int i = 0; i < pos - 1; i++) temp = temp.next;
        T data = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return data;
    }
    
    // Task #9: Check if student is registered
    public boolean search(T value) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(value)) return true;
            temp = temp.next;
        }
        return false;
    }
    
    // Task #10: Cancel registration by student info
    public boolean deleteValue(T value) {
        if (isEmpty()) return false;
        if (head.data.equals(value)) { deleteFirst(); return true; }
        
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(value)) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    // Task #11: Display registration queue
    public void display() {
        if (isEmpty()) { System.out.println("No registrations"); return; }
        Node<T> temp = head;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " -> " : " -> null\n"));
            temp = temp.next;
        }
    }
}

// Student class for real-world demo
class Student {
    String id, name, course;
    
    Student(String id, String name, String course) {
        this.id = id; this.name = name; this.course = course;
    }
    
    public boolean equals(Object obj) {
        return obj instanceof Student && ((Student)obj).id.equals(this.id);
    }
    
    public String toString() { return name + "(" + id + ")"; }
}

// Main class - University Registration System  
class LinkedListDemo {
    public static void main(String[] args) {
        GenericLinkedList<Student> registration = new GenericLinkedList<>();
        
        System.out.println("=== STUDENT REGISTRATION SYSTEM ===");
        System.out.println("Empty? " + registration.isEmpty()); // true
        
        // Regular registrations (end of queue)
        registration.insertAtLast(new Student("CS001", "Alice", "DSA"));
        registration.insertAtLast(new Student("CS002", "Bob", "Algorithms"));
        registration.insertAtLast(new Student("CS003", "Carol", "Database"));
        
        // Priority registration (front of queue)  
        registration.insertAtFirst(new Student("CS000", "VIP_Student", "AI"));
        
        System.out.println("\nCurrent registrations:");
        registration.display(); // VIP_Student -> Alice -> Bob -> Carol -> null
        System.out.println("Total: " + registration.getSize()); // 4
        
        // Late registration at position 2
        registration.insertAtPosition(2, new Student("CS004", "Eve", "Web"));
        registration.display(); // VIP_Student -> Alice -> Eve -> Bob -> Carol -> null
        
        // Check registration status
        Student searchStudent = new Student("CS002", "Bob", "Algorithms");
        System.out.println("Bob registered? " + registration.search(searchStudent)); // true
        
        // Process admissions (remove from front)
        System.out.println("Admitted: " + registration.deleteFirst()); // VIP_Student
        
        // Cancel registrations
        System.out.println("Last cancelled: " + registration.deleteLast()); // Carol
        registration.deleteValue(new Student("CS002", "Bob", "Algorithms"));
        
        System.out.println("\nFinal queue:");
        registration.display(); // Alice -> Eve -> null
        
        // Test with simple strings
        System.out.println("\n=== COURSE WAITLIST ===");
        GenericLinkedList<String> courses = new GenericLinkedList<>();
        courses.insertAtLast("Data Structures");
        courses.insertAtLast("Algorithms");
        courses.insertAtFirst("Machine Learning");
        courses.display(); // Machine Learning -> Data Structures -> Algorithms -> null
    }
}

/*
🎯 BEGINNER'S LOGIC SUMMARY:

PATTERN 1 - TRAVERSAL (Walk the train):
Node temp = head;
while (temp != null) { temp = temp.next; }

PATTERN 2 - INSERT (Add new car):
newNode.next = targetLocation.next;  // Connect new to next
targetLocation.next = newNode;       // Connect previous to new

PATTERN 3 - DELETE (Remove car):
previous.next = target.next;  // Skip over target car

🚂 REAL-WORLD: University course registration where students join queues,
get priority placement, cancel registrations, and administrators track enrollment.

💡 REMEMBER: Start at HEAD, walk to position, modify connections, update size!
*/