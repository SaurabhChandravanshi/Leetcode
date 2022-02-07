package heap;

public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
    }

    public int parent(int position) {return Heap[position / 2];}
    private int leftChild(int position) {return (2 * position); }
    private int rightChild(int position) {return (2 * position) + 1;}

    public boolean isLeaf(int position) {
        return position > (size / 2) && position <= size;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    

}
