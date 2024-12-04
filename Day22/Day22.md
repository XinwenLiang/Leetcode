# 代码随想录算法训练营第二十二天
## [77. Combinations](https://leetcode.com/problems/combinations/description/)

Given two integers `n` and `k`, return all possible combinations of `k` numbers chosen from the range `[1, n]`.

You may return the answer **in any order**.

 

**Example 1:**

**Input:** n = 4, k = 2<br>
**Output:** [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]] <br>
**Explanation:** There are 4 choose 2 = 6 total combinations.<br>
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

**Ideas:** We can consider combinations as the leaves in a tree strcuture. Each time an element is selected from the set, the range of selectable elements shrinks as the selection 
progresses, adjusting the available range accordingly. In the diagram, it can be observed that `n` corresponds to the width of the tree, while `k` corresponds to the depth of the tree.
So how can we traverse this tree and collect the desired result set?
In the diagram, each time a leaf node is reached during the search, a result is found.
This means that we only need to collect the results obtained at the leaf nodes to compute the combination set of `k` numbers chosen from `n` numbers.

<p align="center">
  <img src="https://github.com/user-attachments/assets/415e5353-ecc6-40e6-8507-4baab6fe5bc3" alt="图片3" width="600">
</p>

```Java
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
    public void backtracking(int n, int k, int startIndex){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n ; i++) {
            path.push(i);
            backtracking(n, k, i+1); // Prevent repeated numbers.
            path.pop();
        }
    }
}
```

However, we can do some **trim operations** for backtracking problems. Since the backtracking method is essentially a brute-force search, we can optimize the algorithm through appropriate 
pruning. For example, in this problem, the range of the for loop can be optimized and pruned. Here, we use n=4 and k=4 as an example.


![image](https://github.com/user-attachments/assets/f0968455-a01f-41a7-b697-b51a9fa8b02f)

* Number of elements already selected: `path.size()`
* Number of elements still needed: `k-path.size()`
* In the set of n, at most, we need to start traversing from the position: `n-(k-path.size())+1`

```Java
public class Combinations02 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);
            backtracking(n, k, i + 1); // Prevent repeated numbers.
            path.pop();
        }
    }
}
























