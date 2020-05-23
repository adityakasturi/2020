import java.util.*;

public class PartitionLabels {
    // Approach #1: Greedy
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

//    Complexity Analysis
//  https://leetcode.com/problems/partition-labels/solution/
//    Time Complexity: O(N)O(N), where NN is the length of SS.
//
//    Space Complexity: O(N)O(N).

    /**
     * Approach Two with HashMap easy to understand.
     * @param S
     * @return
     */
    public List<Integer> partitionLabelsTwo(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> resultList = new ArrayList<>();
        // one edge case when we don't need to split into partitions
        if(S.charAt(0) == S.charAt(S.length() - 1))
        {
            resultList.add(S.length());
            return resultList;
        }
        // map to store last index of every character
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            map.put(S.charAt(i), i);
        }
        int firstIndex = 0, lastIndex = 0;
        // loop again to find all partitions
        for(int i=0; i<S.length(); i++){
            lastIndex = Math.max(lastIndex,  map.get(S.charAt(i)));
            // if we have traversed reached last Index of all the characters occured till now. We have one partition
            if(i==lastIndex){
                resultList.add(lastIndex-firstIndex+1);
                firstIndex = lastIndex+1;
            }
        }

        return resultList;
    }

    // O(N)  Time.
    public List<Integer> partitionLabelsThree(String S) {
        Map<Character, Integer> posMap = new HashMap<Character, Integer>();
        ArrayList<Integer> result = new ArrayList();

        for(int i = 0; i < S.length(); i++){
            Character c = S.charAt(i);
            posMap.put(c, i);
        }

        int left = 0; int right = 0; int curr = 0;
        for(int i = 0; i < S.length(); i++){
            Character c = S.charAt(i);
            curr = posMap.get(c);

            if(curr > right) right = curr;

            if(i == right){
                result.add(right - left + 1);
                left = i + 1;
            }
        }

        return result;
    }
}
