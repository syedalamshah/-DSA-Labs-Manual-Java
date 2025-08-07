// Task #01: Rectangle Class
class Rectangle {
    private double length = 1.0;
    private double width = 1.0;
    
    // Set length with validation
    public void setLength(double length) {
        if (length > 0.0 && length < 20.0) {
            this.length = length;
        }
    }
    
    // Set width with validation
    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0) {
            this.width = width;
        }
    }
    
    // Get length
    public double getLength() {
        return length;
    }
    
    // Get width
    public double getWidth() {
        return width;
    }
    
    // Calculate area
    public double getArea() {
        return length * width;
    }
    
    // Calculate perimeter
    public double getPerimeter() {
        return 2 * (length + width);
    }
}

// Test program for Rectangle
public class RectangleTest {
    public static void main(String[] args) {
        System.out.println("=== Rectangle Test ===");
        
        // Create rectangle
        Rectangle rect = new Rectangle();
        
        // Test default values
        System.out.println("Default Rectangle:");
        System.out.println("Length: " + rect.getLength());
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());
        System.out.println();
        
        // Set new values
        rect.setLength(5.0);
        rect.setWidth(3.0);
        
        System.out.println("After setting length=5.0, width=3.0:");
        System.out.println("Length: " + rect.getLength());
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());
        System.out.println();
        
        // Test validation (invalid values)
        System.out.println("Testing validation with invalid values:");
        rect.setLength(25.0); // Invalid - too big
        rect.setWidth(-2.0);  // Invalid - negative
        
        System.out.println("Length after invalid input: " + rect.getLength());
        System.out.println("Width after invalid input: " + rect.getWidth());
    }
}