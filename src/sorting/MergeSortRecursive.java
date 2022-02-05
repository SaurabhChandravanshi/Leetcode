package sorting;

public class MergeSortRecursive {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3,5,6,7,2,1,0};

        System.out.println("Before Sorting: ");
        for(int i:arr) {
            System.out.print(i+" ");
        }

        MergeSortRecursive sort = new MergeSortRecursive();

        sort.mergeSort(arr,0, arr.length  - 1);
        System.out.println("\nAfter Sorting: ");
        for(int i:arr) {
            System.out.print(i+" ");
        }
    }


    public  void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid + 1, end);
            merge(arr,start,mid,end);
        }
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int index  = start;
        int[] aux = new int[arr.length];


        while (i <= mid && j <= end) {
            if(arr[i] < arr[j]) {
                aux[index] = arr[i];
                i++;
            } else {
                aux[index] = arr[j];
                j++;
            }
            index++;
        }

        while (i <= mid) {
            aux[index] = arr[i];
            index++; i++;
        }

        while (j <= end) {
            aux[index] = arr[j];
            index++; j++;
        }

        for(int k=start;k<=end;k++) {
            arr[k] = aux[k];
        }
    }
}
