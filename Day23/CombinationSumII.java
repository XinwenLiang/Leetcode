package Day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates); // Sort the arrays for the convenience of trimming.
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            // Mark the current element as used and add to path.
            used[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i + 1);

            // backtrack: undo changes
            path.removeLast();
            used[i] = false;
            sum -= candidates[i];
        }
    }
}
