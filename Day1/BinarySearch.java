package Day1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int target2 = 2;
        System.out.println(search(arr, target1));
        System.out.println(search(arr, target2));
        System.out.println(BinarySearch(arr, target1));
        System.out.println(BinarySearch(arr, target2));
    }

    // Case1: Left-closed and right-closed interval.
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (target >= arr[0] && target <= arr[arr.length - 1]) {
            while (left <= right) {
                int middle = (left + right) / 2;
                if (arr[middle] > target) {
                    right = middle - 1;
                } else if (arr[middle] < target) {
                    left = middle + 1;
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }

    // Case2: Left-closed and right-opened interval.
    public static int BinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        if (target >= arr[left] && target <= arr[arr.length- 1]) {
            while (left < right) {
                int middle = (right + left) / 2;
                if (arr[middle] < target) {
                    left = middle + 1;
                } else if (arr[middle] > target) {
                    right = middle;
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }
}
