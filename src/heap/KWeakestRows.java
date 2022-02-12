package heap;

import javafx.util.Pair;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] sum = new int[mat.length];
        int idx = 0;

        for (int[] ints : mat) {
            int s = 0;
            for (int anInt : ints) {
                s += anInt;
            }
            sum[idx++] = s;
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<sum.length;i++) {
            Pair<Integer, Integer> pair = new Pair<>(sum[i], i);
            pq.add(pair);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        Iterator iterator = pq.iterator();
        int[] res = new int[k];
        int index = 0;
        while (iterator.hasNext()) {
            res[index++] = ((Pair<Integer, Integer>)iterator.next()).getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        KWeakestRows weakestRows = new KWeakestRows();

    }


}
