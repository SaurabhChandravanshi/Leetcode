package arrays;

public class CountSmaller {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2};

        System.out.println(countSmallerOrEquals(arr, 2));

    }

    public static int countSmallerOrEquals(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        int count = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

           if (arr[mid] <= k) {
                count += mid - low + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }
}
