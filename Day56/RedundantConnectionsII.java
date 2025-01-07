package Day56;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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