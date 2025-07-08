package newLearnings;
public class RecursiveBinarySearch {
    // Recursive binary search method
    public static int binarySearch(int[] arr, int target, int low, int high) {
        // Base case: if low index exceeds high index, target is not found
        if (low > high) {
            return -1; // Target not found
        }
        // Calculate the middle index
        int mid = low + (high - low) / 2;
        // Check if the middle element is the target
        if (arr[mid] == target) {
            return mid; // Target found, return its index
        }
        // If target is greater than the middle element, search in the right half
        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, high);
        }
        // If target is smaller than the middle element, search in the left half
        return binarySearch(arr, target, low, mid - 1);
    }
    public static void main(String[] args) {
        // Example sorted array
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13; // The value to search for

        // Call the recursive binary search function
        int result = binarySearch(arr, target, 0, arr.length - 1);

        // Print the result
        if (result != -1) {
            System.out.println("Target " + target + " found at index " + result);
        } else {
            System.out.println("Target " + target + " not found.");
        }    }}
