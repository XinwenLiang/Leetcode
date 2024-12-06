package Day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(result, path, candidates, target, 0, 0);
        return result;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target) break;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(res, path, candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
