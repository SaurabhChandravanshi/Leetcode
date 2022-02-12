package heap;

public class MaxHeap {
    int[] maxHeap;
    int heapSize;
    int realSize = 0;

    public MaxHeap(int heapSize) {
        this.heapSize = heapSize;
        maxHeap = new int[heapSize + 1];
        maxHeap[0] = 0;
    }

    public boolean offer(int element) {
        realSize++;
        if(realSize > heapSize) {
            realSize--;
            return false;
        }
        maxHeap[realSize] = element;
        int index = realSize;
        int parent = index / 2;
        while (maxHeap[index] > maxHeap[parent]  && index > 1) {
            int temp = maxHeap[index];
            maxHeap[index] = maxHeap[parent];
            maxHeap[parent] = temp;
            index = parent;
            parent = index / 2;
        }
        return true;
    }

    public int poll() {
        if (realSize < 1) return Integer.MAX_VALUE;
        else {
            int removeElement = maxHeap[1];
            maxHeap[1] = maxHeap[realSize];
            realSize--;
            int index = 1;
            while (index <= realSize / 2) {
                int left = 2 * index;
                int right = 2 * index + 1;

                if(maxHeap[left] > maxHeap[index] || maxHeap[right] > maxHeap[index]) {
                    if(maxHeap[left] > maxHeap[right]) {
                        int temp = maxHeap[left];
                        maxHeap[left] = maxHeap[index];
                        maxHeap[index] = temp;
                        index = left;
                    } else {
                        int temp = maxHeap[right];
                        maxHeap[right] = maxHeap[index];
                        maxHeap[index] = temp;
                        index = right;
                    }
                } else {
                    break;
                }
            }
            return removeElement;
        }
    }

    public int peek() {
        return maxHeap[1];
    }
    public int size() {
        return realSize;
    }
    public String toString() {
        if (realSize == 0) {
            return "No element!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 1; i <= realSize; i++) {
                sb.append(maxHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Test case
        MaxHeap maxheap = new MaxHeap(5);
        maxheap.offer(1);
        maxheap.offer(2);
        maxheap.offer(3);
        // [3,1,2]
        System.out.println(maxheap.toString());
        // 3
        System.out.println(maxheap.peek());
        // 3
        System.out.println(maxheap.poll());
        System.out.println(maxheap.poll());
        System.out.println(maxheap.poll());
        // No element
        System.out.println(maxheap.toString());
        maxheap.offer(4);
        // Add too many elements
        maxheap.offer(5);
        // [4,1,2]
        System.out.println(maxheap.toString());
    }
}
