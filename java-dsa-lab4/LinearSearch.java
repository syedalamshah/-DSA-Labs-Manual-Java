public class LinearSearch {
    
    // Linear search for 1D array
    public static int LinearSearch1D(int[] A, int key) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == key) {
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if not found
    }
    
    // Linear search for 2D array
    public static String LinearSearch2D(int[][] A, int key) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == key) {
                    return "Found at [" + i + "][" + j + "]"; // Return position
                }
            }
        }
        return "Not found"; // Return message if not found
    }
    
    public static void main(String[] args) {
        // Test 1D array
        int[] arr1D = {10, 25, 30, 45, 60};
        int key1 = 30;
        int key2 = 99;
        
        System.out.println("1D Array: [10, 25, 30, 45, 60]");
        System.out.println("Search for " + key1 + ": Index " + LinearSearch1D(arr1D, key1));
        System.out.println("Search for " + key2 + ": Index " + LinearSearch1D(arr1D, key2));
        
        // Test 2D array
        int[][] arr2D = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int key3 = 5;
        int key4 = 12;
        
        System.out.println("\n2D Array:");
        System.out.println("[1, 2, 3]");
        System.out.println("[4, 5, 6]");
        System.out.println("[7, 8, 9]");
        System.out.println("Search for " + key3 + ": " + LinearSearch2D(arr2D, key3));
        System.out.println("Search for " + key4 + ": " + LinearSearch2D(arr2D, key4));
    }
}