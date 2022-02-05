package arrays;

public class SubArrayNegativeSum {


    public static void main(String[] args) {
        int[] arr = {1, -2, 4, -5, 1};

        System.out.println(countNegativeSum(arr));
    }

    public static int countNegativeSum(int[] arr) {

        int subLength = 1;
        int counter = 0;

        while (subLength <= arr.length) {
            for(int i=0;i <= arr.length - subLength;i++) {
                int sum = 0;
                for(int j = i;j < i + subLength;j++) {
                    sum += arr[j];
                }

                if(sum < 0) {
                    counter++;
                }
            }
            subLength++;
        }

        return counter;
    }
}
