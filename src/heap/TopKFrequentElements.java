package heap;

/*
Given an integer array nums and an integer k,
return the k most frequent elements. You may return the answer in any order.
 */

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((n1,n2)-> map.get(n1) - map.get(n2));
        for(int n:map.keySet()) {
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }
        int[] res = new int[k];
        int idx = 0;
        while (heap.size() > 0) {
            res[idx++] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements freq = new TopKFrequentElements();
        System.out.println(Arrays.toString(freq.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
