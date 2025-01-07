# 代码随想录算法训练营第五十五天
## [107. Find if a Path Exists](https://kamacoder.com/problempage.php?pid=1179)

Given an undirected graph with `n` nodes, where the nodes are numbered from 1 to n, your task is to determine if there exists a **path** from node **source** to node **destination**.

**Input Description:**
* The first line contains two positive integers N and M, representing the number of nodes and the number of edges, respectively.
* The next M lines each contain two positive integers `s` and `t`, indicating that there is an edge between node `s` and node `t`.
* The last line contains two positive integers representing the starting node source and the target node destination.

**Output Description:**

Output a single integer, representing whether a path exists from node source to node destination. Output `1` if a path exists, otherwise output `0`.

**Example1:**

**Input**
5 4  <br>
1 2  <br>
2 3  <br>
3 4  <br>
1 4  <br>
1 4

**Output:** 1
![image](https://github.com/user-attachments/assets/8d31237d-b1c1-4fdb-8f7b-b04e4baf6571)


**Ideas:**
Determining whether there is a valid path between two vertices is essentially checking if the two vertices belong to the same set. At this point, we can directly apply the union-find (disjoint set) template.

Use `join(int u, int v)` to add each edge to the union-find structure.

Finally, use `isSame(int u, int v)` to check whether they share the same root.

```Java
public class ValidPaths {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int N = myScanner.nextInt();
        int M = myScanner.nextInt();
        Disjoint disjoint = new Disjoint(N+1);
        for (int i = 0; i < M; i++) {
            disjoint.join(myScanner.nextInt(),myScanner.nextInt());
        }
        if(disjoint.isSame(myScanner.nextInt(), myScanner.nextInt())){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }

}

class Disjoint {
    private int[] father;

    // Initialize the father array.
    public Disjoint(int N) {
        father = new int[N];
        for (int i = 0; i < N; i++) {
            father[i] = i;
        }
    }

    public int find(int n) {
        return n == father[n] ? n : (father[n] = find(father[n]));
    }

    public void join(int n, int m) {
        n = find(n);
        m = find(m);
        if (n == m) return;
        father[m] = n;
    }

    public boolean isSame(int n, int m) {
        n = find(n);
        m = find(m);
        return n == m;
    }
}
```


























