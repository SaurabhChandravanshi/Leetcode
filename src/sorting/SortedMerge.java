package sorting;

public class SortedMerge {

    public static void main(String[] args) {

        int[] A = new int[6];
        A[0] = 1;
        A[1] = 8;
        A[2] = 8;

        int[] B = new int[]{-4,5,6};


        System.out.print("A=");
        printArray(A);

        System.out.print("B=");
        printArray(B);

        sortedMerge(A,B);

        System.out.print("Merged A=");
        for (int j : A) {
            System.out.print(j + " ");
        }
    }

    private static void sortedMerge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] helper = new int[a.length];

        while(j < b.length && i < a.length - b.length) {
            if(a[i] <= b[j]) {
                helper[k] = a[i];
                i++; k++;
            } else {
                helper[k] = b[j];
                j++; k++;
            }
        }

        while (j < b.length) {
            helper[k] = b[j];
            j++; k++;
        }
        while (i < a.length - b.length) {
            helper[k] = a[i];
            i++; k++;
        }

        for(int index=0;index<helper.length;index++) {
            a[index] = helper[index];
        }
    }


    public static void printArray(int[] arr) {
        for (int e: arr) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
}
