public class binarysearch {
    
    // 1D Binary Search
    static int BinarySearch1D(int[] A, int key, int first, int end) {
        while (first <= end) {
            int mid = (first + end) / 2;
            if (A[mid] == key) return mid;
            if (A[mid] < key) first = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    
    // 2D Binary Search
    static int[] BinarySearch2D(int[][] A, int key) {
        int rows = A.length, cols = A[0].length;
        int first = 0, end = rows * cols - 1;
        
        while (first <= end) {
            int mid = (first + end) / 2;
            int r = mid / cols, c = mid % cols;
            if (A[r][c] == key) return new int[]{r, c};
            if (A[r][c] < key) first = mid + 1;
            else end = mid - 1;
        }
        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        // Test 1D
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45};
        System.out.println("1D: " + BinarySearch1D(arr, 23, 0, 7)); // Output: 5
        
        // Test 2D
        int[][] matrix = {{1, 4, 7}, {8, 10, 12}, {15, 18, 20}};
        int[] result = BinarySearch2D(matrix, 10);
        System.out.println("2D: [" + result[0] + "," + result[1] + "]"); // Output: [1,1]
        
        // Dry Run
        System.out.println("\nDry Run - Search 23 in [2,5,8,12,16,23,38,45]:");
        System.out.println("Step 1: mid=3, A[3]=12 < 23, search right");
        System.out.println("Step 2: mid=5, A[5]=23 == 23, FOUND!");
    }
}
