class Node {
    String step;   // e.g., "Bus from City to Stop A"
    Node next;     // link to next step

    Node(String step) {
        this.step = step;
        this.next = null;
    }
}

class TripToMehran {
    Node head; // start of route

    // Add step at end
    public void addStep(String step) {
        Node newNode = new Node(step);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Print full route
    public void printRoute() {
        if (head == null) {
            System.out.println("No route planned.");
            return;
        }
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            System.out.println(pos + ". " + temp.step);
            temp = temp.next;
            pos++;
        }
    }

    // Delete a step by position
    public void deleteStep(int pos) {
        if (head == null) return;

        if (pos == 1) {
            System.out.println("Deleted: " + head.step);
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) return;

        System.out.println("Deleted: " + temp.next.step);
        temp.next = temp.next.next;
    }

    // Search for a step
    public void searchStep(String step) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.step.equals(step)) {
                System.out.println(step + " found at step " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println(step + " not found.");
    }

    // Main method (Demo)
    public static void main(String[] args) {
        TripToMehran trip = new TripToMehran();

        // Build initial route
        trip.addStep("Take Bus from City to Stop A");
        trip.addStep("Take Train from Stop A to Stop B");
        trip.addStep("Take Subway from Stop B to Stop C");
        trip.addStep("Walk to Mehran UET");

        System.out.println("\n🚍 Planned Route:");
        trip.printRoute();

        // Search
        trip.searchStep("Take Train from Stop A to Stop B");
        trip.searchStep("Taxi to Mehran UET");

        // Delete one step
        trip.deleteStep(1);

        System.out.println("\n🚍 Updated Route After Deletion:");
        trip.printRoute();
    }
}