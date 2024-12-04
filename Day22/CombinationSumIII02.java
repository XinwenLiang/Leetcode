package Day22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII02 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 0, 1);
        return result;
    }

    public void backtracking(int targetSum, int k, int sum, int startIndex) {
        if (path.size() == k) {
            if(sum > targetSum) return;
            if (targetSum == sum)
                result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9-(k-path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(targetSum, k, sum, i + 1);
            path.removeLast();
            sum -= i;
        }
    }
}

