// This is the link to the question.
// https://leetcode.com/problems/top-k-frequent-elements/
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements{
    public static void main(String args[]){
        int[] nums = {1,1,1,2,2,3,3,2,2,2,1,1,1,4,8,7,7,7,5,5,3,3,3,4,5,5,5};
        int[] result = topKFrequent(nums, 4);
        for (int i:result){
            System.out.println(i);
        }
    }

    public static int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Comparator<Integer> kComparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer i, Integer j){
                return map.get(i) -  map.get(j);
            }
        };

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(kComparator);

        for (int key:map.keySet()) {
            queue.add(key);
            if (queue.size() > k){
                queue.poll();
            }
        }

        int[] result = new int[k];

        for (int i=0; i < k; i++){
            result[i]=queue.poll();
        }

        return result;
    }
}
