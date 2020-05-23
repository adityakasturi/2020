import java.util.*;

public class MinCostToRopes {

    public static int minCost(List<Integer> ropes) {
        // Initializing ropes with poll, they are all in sorted order
        // by different.
        Queue<Integer> pq = new PriorityQueue<>(ropes);
        int totalCost = 0;
        while (pq.size() > 1) {
            int cost = pq.poll() + pq.poll();
            pq.add(cost);
            totalCost += cost;
        }
        return totalCost;
    }

    // same but a little different.
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2) -> i1-i2);
        int cost = 0;
        for (int stick:sticks) {
            pq.add(stick);
        }

        while (pq.size()!=1) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();

            int curr = stick1 + stick2;
            cost += curr;
            pq.add(curr);
        }

        return cost;
    }

    private static int mergeFilesTwo(int[] files) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int f : files) {
            minHeap.offer(f);
        }
        int res = 0;
        while(minHeap.size() > 1) {
            int f1 = minHeap.poll();
            int f2 = minHeap.poll();
            int tmp = f1 + f2;
            res += tmp;
            minHeap.offer(tmp);
        }
        return res;
    }
}
