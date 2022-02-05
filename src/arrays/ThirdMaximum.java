package arrays;

public class ThirdMaximum {

    public static void main(String[] args) {
        //int[] arr = new int[] {2,2,3,1};
        int[] arr = new int[] {2,2,3,1};
        //int[] arr = new int[] {2,5,3,1};
        //int[] arr = new int[] {1,3,2,8};
        //int[] arr = new int[] {2,5,3,1};

        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] arr) {
        int fMax = Integer.MIN_VALUE; int fIndex = -1;
        int sMax = Integer.MIN_VALUE; int sIndex = -1;
        int tMax = Integer.MIN_VALUE;

        for(int i=0;i< arr.length;i++) {
            if(arr[i] > fMax) {
                fMax = arr[i];
                fIndex = i;
            }
        }

        for(int i=0;i< arr.length;i++) {
            if (i != fIndex && arr[i] > sMax && arr[i] < fMax) {
                sMax = arr[i];
                sIndex = i;
            }
        }


        if(arr.length < 3) return fMax;

        for(int i=0;i< arr.length;i++) {
            if(i != fIndex && i != sIndex && arr[i] > tMax) {
                tMax = arr[i];
            }
        }

        return tMax;
    }
}
