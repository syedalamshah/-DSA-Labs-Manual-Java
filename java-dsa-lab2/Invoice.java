
public class Invoice {
    private String partNumber, partDescription;
    private int quantity;
    private float pricePerItem;
    
    // Constructor with validation
    public Invoice(String number, String desc, int qty, float price) {
        partNumber = number;
        partDescription = desc;
        quantity = (qty > 0) ? qty : 0;
        pricePerItem = (price > 0) ? price : 0;
    }
    
    // Getters
    public String getPartNumber() { return partNumber; }
    public String getPartDescription() { return partDescription; }
    public int getQuantity() { return quantity; }
    public float getPricePerItem() { return pricePerItem; }
    
    // Calculate invoice amount
    public float getInvoiceAmount() { return quantity * pricePerItem; }
    
    // Test
    public static void main(String[] args) {
        Invoice inv1 = new Invoice("A123", "Hammer", 2, 15.5f);
        Invoice inv2 = new Invoice("B456", "Screws", -3, 5.0f); // Test validation
        
        System.out.println("Invoice 1: " + inv1.getPartDescription() + 
                          " | Amount: $" + inv1.getInvoiceAmount());
        System.out.println("Invoice 2: " + inv2.getPartDescription() + 
                          " | Quantity: " + inv2.getQuantity() + 
                          " | Amount: $" + inv2.getInvoiceAmount());
    }
} 
