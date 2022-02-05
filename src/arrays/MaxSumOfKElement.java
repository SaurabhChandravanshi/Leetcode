package arrays;

import java.util.Arrays;

public class MaxSumOfKElement {


    public static void main(String[] args) {
        int[] arr = {3, -1, 2, 5};

        System.out.println(maximumSum(arr,1));
    }

    public static int maximumSum(int[] A, int K) {
        Arrays.sort(A);

        if(K > A.length) {
            return 0;
        }

        int index = A.length - 1;
        int sum = A[index];
        int prev = A[index];

        index--;
        K--;
        while (index >= 0) {

            if (prev != A[index] && K <= 0) {
                break;
            }
            sum += A[index];

            if(prev != A[index]) {
                K--;
            }
            prev = A[index--];
        }
        return sum;
    }
}
