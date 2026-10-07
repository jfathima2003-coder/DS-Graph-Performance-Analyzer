/**
 * Searching component: Linear Search and Binary Search with step counting.
 * Each method returns int[]{index, steps}. index = -1 if not found.
 * Owner: Fathima (Member 1 & 5)
 */
public class SearchOperations {

    /** Linear search: checks every element one by one. O(n) */
    public static int[] linearSearch(int[] arr, int key) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) {
                return new int[]{i, steps};
            }
        }
        return new int[]{-1, steps};
    }

    /** Binary search: array MUST be sorted. Halves the range each step. O(log n) */
    public static int[] binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int steps = 0;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return new int[]{mid, steps};
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1, steps};
    }
}
