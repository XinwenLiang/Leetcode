# 代码随想录算法训练营第五十六天
## [Redundant Connections](https://kamacoder.com/problempage.php?pid=1181)

Given a graph that forms a **tree**. It contains `N` nodes (with node numbers from 1 to N) and `N - 1` edges, making it a connected, acyclic, and undirected graph (essentially a linear graph), as shown below:

![image](https://github.com/user-attachments/assets/2800c09d-2e09-41f3-9c9d-0aec18708b59)

Now, based on this tree, one additional edge is added (so the graph still has **N nodes**, but now contains **N edges**), turning it into a graph with a cycle, as shown below:

![image](https://github.com/user-attachments/assets/a2e0bfae-facc-46af-850c-bd593fe424e6)

Your task is to find the redundant edge, which, when removed, will restore the graph to a tree.

**Input Description**
* The first line contains an integer `N`, representing the number of nodes in the graph and the number of edges.
* The next N lines each contain two integers `s` and `t`, representing an edge between nodes `s` and `t` in the graph.

**Output Description** 
Output a single edge that can be removed to restore the graph to a tree. <br>
If there are multiple possible answers, remove the **last edge** (i.e., the last one in the input) that creates the cycle.

**Ideas:**
If two nodes of an edge already appear in the same set, it means that the two nodes of the edge are already connected, and adding this edge must result in a ring. It has been determined that node A and node B are in 
the same set (the same root), and if node A and node B are joined together, a ring must occur. The question asks ‘Remove the last edge that appears in the standard input’, and we just need to iterate from front to 
back to get what we're looking for.

```Java
public class RedundantConnections {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt(); // The number of nodes.
        disjoint.initialize(n);
        for (int i = 0; i < n; i++) {
            int s = myScanner.nextInt();
            int t = myScanner.nextInt();
            if (disjoint.isSame(s, t)) {
                System.out.println(s + " " + t);
            } else {
                disjoint.join(s, t);
            }
        }
        myScanner.close();
    }
}

class disjoint {
    static int[] father;

    // Initialize the father array.
    public static void initialize(int N) {
        father = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            father[i] = i;
        }
    }

    public static int find(int n) {
        return n == father[n] ? n : (father[n] = find(father[n]));
    }

    public static void join(int n, int m) {
        n = find(n);
        m = find(m);
        if (n == m) return;
        father[m] = n;
    }

    public static boolean isSame(int n, int m) {
        n = find(n);
        m = find(m);
        return n == m;
    }
}
```

## [Redundant ConnectionsII](https://github.com/XinwenLiang/leetcode-master/blob/master/problems/kamacoder/0109.%E5%86%97%E4%BD%99%E8%BF%9E%E6%8E%A5II.md)

There is a special directed tree, where:
* The tree has only one root node.
* All other nodes are descendants of this root node.
* Every node (except the root) has exactly one parent, while the root node has no parent.

The directed tree contains `n` nodes and `n - 1` edges. <br>
Now, a directed graph is formed by adding one extra directed edge between two previously unconnected nodes in the directed tree, resulting in a graph with `n` nodes and `n` edges.

**Task**
Given the directed graph (with n nodes and n edges), return one edge that can be removed so that the graph becomes a valid directed tree again.

If there are multiple edges that can be removed, return the last edge (i.e., the edge that appears last in the input).

**Input Description**
* The first line contains an integer N, representing the number of nodes and edges in the directed graph.
* The next N lines each contain two integers s and t, representing a directed edge from node s to node t.

**Output Description**
Output a single edge (in the form of two integers) that can be removed. If there are multiple such edges, output the last one in the input.

**Example1:**

**Input:** <br>
3  <br>
1 2  <br>
1 3  <br>
2 3  <br>
**Output:** <br>
2 3

**Ideas:**
We first think of the nature of the directed tree, if it is a directed tree, only the root node into the degree of **0**, the other nodes into the degree of **1**. <br>
Then this question is divided into three cases: 
1. If we find the degree of entry into the point of **2**, then delete an edge pointing to the node on the line.
2. The node is **2** but we can only delete a **specific** edge.
3. There is **no** entry degree of 2 points, that is, into the directed ring, delete the edge into the ring can be.

```Java
public class RedundantConnectionsII {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        Node[] nodeMap = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeMap[i] = new Node();
        }

        Integer doubleIn = null; // 记录入度为 2 的节点
        for (int i = 0; i < n; i++) {
            int s = myScanner.nextInt();
            int t = myScanner.nextInt();
            // 记录入度
            nodeMap[t].in++;
            if (nodeMap[t].in == 2) doubleIn = t;
            edges.add(new Edge(s, t));
        }

        Edge result = null;

        // 如果存在入度为 2 的节点，需要考虑删除的边
        if (doubleIn != null) {
            List<Edge> doubleInEdges = new ArrayList<>();
            for (Edge edge : edges) {
                if (edge.end == doubleIn) doubleInEdges.add(edge);
                if (doubleInEdges.size() == 2) break;
            }

            // 尝试删除最后一条边，检查是否能构成树
            Edge edge = doubleInEdges.get(1);
            if (isTreeWithExclude(edges, edge, n)) {
                result = edge;
            } else {
                result = doubleInEdges.get(0); // 如果不行，删除第一条边
            }
        } else {
            // 如果没有入度为 2 的节点，直接寻找成环边
            result = getRemoveEdge(edges, n);
        }

        System.out.println(result.start + " " + result.end);
        myScanner.close();
    }

    // 检查在排除某条边的情况下，剩余边是否构成树
    public static boolean isTreeWithExclude(List<Edge> edges, Edge excludeEdge, int n) {
        DisjointSet disjoint = new DisjointSet(n + 1);
        for (Edge edge : edges) {
            if (edge == excludeEdge) continue;
            if (disjoint.isSame(edge.start, edge.end)) {
                return false; // 如果成环，则不是树
            }
            disjoint.join(edge.start, edge.end);
        }
        return true;
    }

    // 寻找导致成环的边
    public static Edge getRemoveEdge(List<Edge> edges, int n) {
        DisjointSet disjoint = new DisjointSet(n + 1);
        for (Edge edge : edges) {
            if (disjoint.isSame(edge.start, edge.end)) {
                return edge;
            }
            disjoint.join(edge.start, edge.end);
        }
        return null;
    }
}

class DisjointSet {
    int[] parent;

    public DisjointSet(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // 路径压缩
        }
        return parent[x];
    }

    public void join(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public boolean isSame(int x, int y) {
        return find(x) == find(y);
    }
}

class Edge {
    int start;
    int end;

    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Node {
    int in; // 入度
}
```























