public class SearchCompare {
    
    // Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
    
    // Binary Search
    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // Test array (sorted for binary search)
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        
        int searchKey = 9999; // Worst case for linear search
        
        // Linear Search Time
        long before1 = System.currentTimeMillis();
        int result1 = linearSearch(arr, searchKey);
        long after1 = System.currentTimeMillis();
        
        // Binary Search Time  
        long before2 = System.currentTimeMillis();
        int result2 = binarySearch(arr, searchKey);
        long after2 = System.currentTimeMillis();
        
        // Results
        System.out.println("Time took by Linear Search: " + (after1 - before1) + " milliseconds");
        System.out.println("Time took by Binary Search: " + (after2 - before2) + " milliseconds");
        System.out.println("Found at index: " + result1 + " (Linear), " + result2 + " (Binary)");
        
        // Why Binary is Faster
        System.out.println("\nBinary Search is faster because:");
        System.out.println("Linear: O(n) - checks each element");
        System.out.println("Binary: O(log n) - eliminates half each step");
    }
}