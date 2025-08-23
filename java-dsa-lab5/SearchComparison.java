public class SearchComparison {
    
    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
    
    static int binarySearch(int[] arr, int key) {
        int first = 0, end = arr.length - 1;
        while (first <= end) {
            int mid = (first + end) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) first = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // Create large array for better time comparison
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        
        int target = 99999; // Worst case for linear search
        
        // Linear Search Time
        long before1 = System.currentTimeMillis();
        int result1 = linearSearch(arr, target);
        long after1 = System.currentTimeMillis();
        
        // Binary Search Time
        long before2 = System.currentTimeMillis();
        int result2 = binarySearch(arr, target);
        long after2 = System.currentTimeMillis();
        
        // Results
        System.out.println("Time took by Linear Search : " + (after1 - before1) + " milliseconds");
        System.out.println("Time took by Binary Search : " + (after2 - before2) + " milliseconds");
        System.out.println("Linear result: " + result1 + ", Binary result: " + result2);
        
        // Why Binary is faster
        System.out.println("\nWhy Binary is faster:");
        System.out.println("Linear: O(n) - checks all " + arr.length + " elements");
        System.out.println("Binary: O(log n) - checks only ~17 elements");
    }
}
