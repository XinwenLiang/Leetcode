package Day25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonDecreasingSubsequence {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || hs.contains(nums[i])) {
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
